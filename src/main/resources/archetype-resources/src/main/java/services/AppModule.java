package ${package}.services;

import org.apache.shiro.realm.Realm;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.tynamo.PageType;
import org.tynamo.builder.Builder;
import org.tynamo.security.FilterChainDefinition;
import org.tynamo.services.TynamoPageRenderLinkSource;
import org.tynamo.shiro.extension.realm.text.ExtendedPropertiesRealm;

import java.io.IOException;
import java.util.Properties;


/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to configure and extend
 * Tynamo, or to place your own service definitions.
 */
public class AppModule
{

	public static void bind(ServiceBinder binder)
	{
		// Make bind() calls on the binder object to define most IoC services.
		// Use service builder methods (example below) when the implementation
		// is provided inline, or requires more initialization than simply
		// invoking the constructor.

	}

	public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration)
	{
		loadApplicationDefaultsFromProperties("/applicationdefaults.properties", configuration);

	}

	public static void contributeWebSecurityManager(Configuration<Realm> configuration) 
	{
		configuration.add(new ExtendedPropertiesRealm("classpath:shiro-users.properties"));
	}

	public static void contributeSecurityRequestFilter(OrderedConfiguration<FilterChainDefinition> configuration) {
		//Security login page
		configuration.add("assets-anon", new FilterChainDefinition("/assets/**", "anon"));
		configuration.add("login-anon", new FilterChainDefinition("/security/login*", "anon"));

		//Rest
		//configuration.add("rest-anon", new FilterChainDefinition("/rest/**", "authcBasic"));

		//Web
		configuration.add("Inicio", new FilterChainDefinition("/", "roles[admin]"));
		//configuration.add("Add", new FilterChainDefinition("/add/mydomainobject", "roles[user]"));
		configuration.add("List", new FilterChainDefinition("/list/**", "roles[admin]"));
		configuration.add("Add", new FilterChainDefinition("/add/**", "roles[admin]"));
		configuration.add("Edit", new FilterChainDefinition("/edit/**", "roles[admin]"));
	}
	
	/**
	 * By default tapestry-hibernate will scan
	 * InternalConstants.TAPESTRY_APP_PACKAGE_PARAM + ".entities" (witch is equal to "${package}.${artifactId}.entities")
	 * for annotated entity classes.
	 *
	 * Contributes the package "${package}.${artifactId}.model" to the configuration, so that it will be
	 * scanned for annotated entity classes.
	 */
	public static void contributeHibernateEntityPackageManager(Configuration<String> configuration)
	{
//		If you want to scan other packages add them here:
//		configuration.add("${package}.${artifactId}.model");
	}

	/**
	 * Contributes Builders to the BuilderDirector's builders map.
	 * Check GOF's <a href="http://en.wikipedia.org/wiki/Builder_pattern">Builder pattern</a>
	 */
	public static void contributeBuilderDirector(MappedConfiguration<Class, Builder> configuration)
	{
//		configuration.add(org.tynamo.examples.recipe.model.Recipe.class, new RecipeBuilder());
	}

/*
	@Startup
	public static void init(Logger logger, MigrationManager migrationManager)
	{
		logger.info("Starting up...");
//		migrationManager.migrate();
	}
*/

	@Contribute(TynamoPageRenderLinkSource.class)
	public void contributeTynamoPageRenderLinkSource(MappedConfiguration<PageType, Class> configuration)
	{
		configuration.add(PageType.LIST, ${package}.pages.List.class);
		configuration.add(PageType.SHOW, ${package}.pages.Show.class);
		configuration.add(PageType.ADD, ${package}.pages.Add.class);
		configuration.add(PageType.EDIT, ${package}.pages.Edit.class);
	}

	private static void loadApplicationDefaultsFromProperties(String properties, MappedConfiguration<String, String> contributions)
	{
		Properties prop = new Properties();

		try
		{
			prop.load(AppModule.class.getResource(properties).openStream());
		} catch (IOException ioe)
		{
			throw new RuntimeException("Unable to load " + properties, ioe);
		}

		for (Object key : prop.keySet())
		{
			String value = prop.getProperty(key.toString());
			contributions.add(key.toString(), value);
		}
	}

}
