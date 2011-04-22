package ${package}.pages;


/**
 * Page for creating and adding objects to the DB.
 *
 * @note:
 *
 * For adding extra functionality to this page, is easier to copy & paste the code from org.tynamo.pages.Add than
 * trying to use inheritance.

 * Go copy from here:
 * http://svn.codehaus.org/tynamo/tags/tapestry-model-${version}/tapestry-model-core/src/main/java/org/tynamo/pages/Add.java
 *
 */
public class Add extends org.tynamo.pages.Add {

	/**
	 * This method is here just for documentation purposes.
	 * So that you can see what the page activation context is.
	 *
	 * @param clazz
	 * @return null or error @see <a href="http://tapestry.apache.org/page-navigation.html#PageNavigation-Nullresponse">Page Navigation Responses</a>
	 */
	@Override
	protected Object onActivate(Class clazz) {
		return super.onActivate(clazz);
	}

}
