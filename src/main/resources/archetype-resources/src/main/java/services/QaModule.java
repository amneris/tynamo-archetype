package ${package}.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;

/**
 * This module is automatically included as part of the Tapestry IoC Registry if <em>tapestry.execution-mode</em>
 * includes <code>qa</code> ("quality assurance").
 */
public class QaModule
{
	public static void bind(ServiceBinder binder)
	{
		// Bind any services needed by the QA team to produce their reports
		// binder.bind(MyServiceMonitorInterface.class, MyServiceMonitorImpl.class);
	}


	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
	public static void applicationDefaults(MappedConfiguration<String, Object> configuration)
	{
		// The factory default is true but during the early stages of an application
		// overriding to false is a good idea. In addition, this is often overridden
		// on the command line as -Dtapestry.production-mode=false
		configuration.add(SymbolConstants.PRODUCTION_MODE, false);
	}

}
