package ${package}.components;

import org.apache.commons.lang.StringUtils;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.corelib.base.AbstractLink;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.Request;
import java.util.regex.Pattern;
import ${package}.entities.MyDomainObject;


public class MenuItem extends AbstractLink
{

    private static final String CONTEXT = "context";

    private static final String SELECTED = "selected";

    private static final String CLASS = "class";

    private static final String LI = "li";

    @Inject
    private ComponentResources resources;

    @Inject
    private PageRenderLinkSource linkSource;

    @Parameter
    private Object[] context;

    @Parameter(required = true, allowNull = false, defaultPrefix = BindingConstants.LITERAL)
    private String page;

    @Parameter(required = false, defaultPrefix = BindingConstants.LITERAL)
    private String expression;

    @Inject
    private Request request;

    private Pattern pattern;

    private boolean hasExpression;

    void setupRender()
    {
        if (StringUtils.isNotBlank(expression))
        {
            pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            hasExpression = true;
        } else
        {
            hasExpression = false;
        }
    }

    void beginRender(MarkupWriter writer)
    {
        final Link link;

        if (resources.isBound(CONTEXT))
        {
            link = linkSource.createPageRenderLinkWithContext(page, context);
        } else
        {
            link = linkSource.createPageRenderLink(page);
        }

        if (isSelected())
        {
            writer.element(LI, CLASS, SELECTED);
            writeLink(writer, link, CLASS, SELECTED);
        } else
        {
            writer.element(LI);
            writeLink(writer, link);
        }
    }

    private boolean isSelected()
    {
        final String pageName = resources.getPageName();
        boolean selected = pageName.equalsIgnoreCase(page);

        if (hasExpression)
        {
            final String path = request.getPath();
            selected = pattern.matcher(path).matches();
        }

        return selected;
    }

    void afterRender(MarkupWriter writer)
    {
        writer.end(); // <a>
        writer.end(); // <li>
    }
}