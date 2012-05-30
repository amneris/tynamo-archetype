package ${package}.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.HibernateConfigurer;
import org.apache.tapestry5.hibernate.HibernateSessionSource;
import org.apache.tapestry5.hibernate.HibernateSymbols;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;

public class ProductionModule
{
	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
	public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration)
	{
//		configuration.add(HibernateSymbols.EARLY_START_UP, true);
//		configuration.add(SymbolConstants.HOSTNAME, "YOUR HOST_NAME");
//		configuration.add(SymbolConstants.HOSTPORT, "80");
	}

	@Contribute(HibernateSessionSource.class)
	public static void configureHibernateSource(OrderedConfiguration<HibernateConfigurer> configurers)
	{
		configurers.add("${artifactId}HibernateConfigurer", new HibernateConfigurer()
		{
			public void configure(org.hibernate.cfg.Configuration configuration)
			{
				configuration.configure("/hibernate.prod.cfg.xml");
			}
		});
	}
}
