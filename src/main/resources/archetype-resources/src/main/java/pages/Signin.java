package ${package}.pages;

import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;
import org.tynamo.security.SecuritySymbols;
import org.tynamo.security.internal.services.LoginContextService;
import org.tynamo.security.pages.Login;
import org.tynamo.security.services.SecurityService;

import java.io.IOException;

public class Signin extends Login
{
	@Inject
	private Logger logger;

	@Property
	private String jsecLogin;

	@Property
	private String jsecPassword;

	@Property
	private boolean jsecRememberMe;

	@Inject
	private AlertManager alertManager;

	@Inject
	@Symbol(SecuritySymbols.REDIRECT_TO_SAVED_URL)
	private boolean redirectToSavedUrl;

	@Inject
	private Response response;

	@Inject
	private RequestGlobals requestGlobals;

	@Inject
	private SecurityService securityService;

	@Inject
	private LoginContextService pageService;

	public Object onActionFromJsecLoginForm() throws IOException
	{

		Subject currentUser = securityService.getSubject();

		if (currentUser == null)
		{
			throw new IllegalStateException("Subject can`t be null");
		}

		UsernamePasswordToken token = new UsernamePasswordToken(jsecLogin, jsecPassword);
		token.setRememberMe(jsecRememberMe);

		try
		{
			currentUser.login(token);
		} catch (UnknownAccountException e)
		{
			String loginMessage = "Account not exists";
			alertManager.error(loginMessage);
			logger.debug(e.getMessage());
			return null;
		} catch (IncorrectCredentialsException e)
		{
			String loginMessage = "Wrong password";
			alertManager.error(loginMessage);
			logger.debug(e.getMessage());
			return null;
		} catch (LockedAccountException e)
		{
			String loginMessage = "Account locked";
			alertManager.error(loginMessage);
			logger.debug(e.getMessage());
			return null;
		} catch (AuthenticationException e)
		{
			// BIG ERROR, let's print the stacktrace too.
			String loginMessage = "Authentication Error!";
			alertManager.error(loginMessage);
			logger.debug(loginMessage, e);
			return null;
		}

		if (redirectToSavedUrl)
		{
			String requestUri = pageService.getSuccessPage();
			if (!requestUri.startsWith("/")) requestUri = "/" + requestUri;
			pageService.redirectToSavedRequest(requestUri);
			return null;
		}

		return pageService.getSuccessPage();
	}
}
