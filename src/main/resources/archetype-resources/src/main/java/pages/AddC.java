package ${package}.pages;


/**
 * Add elements to a composition.
 *
 * @note:
 *
 * For adding extra functionality to this page, is easier to copy & paste the code from org.tynamo.pages.AddC than
 * trying to use inheritance.

 * Go copy from here:
 * http://svn.codehaus.org/tynamo/tags/tapestry-model-${version}/tapestry-model-core/src/main/java/org/tynamo/pages/AddC.java
 *
 */
public class AddC extends org.tynamo.pages.AddC
{

	/**
	 * This method is here just for documentation purposes.
	 * So that you can see what the page activation context is.
	 *
	 * @param clazz
	 * @param parentId
	 * @param property
	 * @return null or error @see <a href="http://tapestry.apache.org/page-navigation.html#PageNavigation-Nullresponse">Page Navigation Responses</a>
	 */
	@Override
	protected Object onActivate(Class clazz, String parentId, String property)
	{
		return super.onActivate(clazz, parentId, property);
	}

}