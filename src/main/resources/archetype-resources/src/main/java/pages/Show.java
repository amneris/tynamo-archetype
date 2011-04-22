package ${package}.pages;


/**
 * Page for displayig the properties of an object.
 *
 * @note:
 *
 * For adding extra functionality to this page, is easier to copy & paste the code from org.tynamo.pages.Show than
 * trying to use inheritance.

 * Go copy from here:
 * http://svn.codehaus.org/tynamo/tags/tapestry-model-${version}/tapestry-model-core/src/main/java/org/tynamo/pages/Show.java
 *
 */
public class Show extends org.tynamo.pages.Show {

	/**
	 * This method is here just for documentation purposes.
	 * So that you can see what the page activation context is.
	 *
	 * @param clazz
	 * @param id
	 * @return null or error @see <a href="http://tapestry.apache.org/page-navigation.html#PageNavigation-Nullresponse">Page Navigation Responses</a>
	 */
	@Override
	protected Object onActivate(Class clazz, String id) {
		return super.onActivate(clazz, id);
	}

}
