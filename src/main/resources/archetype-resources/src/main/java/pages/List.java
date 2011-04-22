package ${package}.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.corelib.components.Grid;

/**
 * Page for listing elements of a given type.
 *
 * @note:
 *
 * For adding extra functionality to this page, is easier to copy & paste the code from org.tynamo.pages.List than
 * trying to use inheritance.

 * Go copy from here:
 * http://svn.codehaus.org/tynamo/tags/tapestry-model-${version}/tapestry-model-core/src/main/java/org/tynamo/pages/List.java
 *
 */
public class List extends org.tynamo.pages.List {

	@Component
	private Grid grid;

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


	/**
	 * This is where you can perform any one-time per-render setup for your component. This is a good place to read
	 * component parameters and use them to set temporary instance variables.
	 * More info: http://tapestry.apache.org/tapestry5.1/guide/rendering.html
	 * {@see org.apache.tapestry5.annotations.SetupRender}
	 */
	void setupRender() {
		grid.reset();
	}
}
