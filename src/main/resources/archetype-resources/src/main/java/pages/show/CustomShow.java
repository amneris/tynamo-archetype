package ${package}.pages.show;

/**
 * Abstract parent class for customized Show pages.
 *
 * @param <T>
 */
public abstract class CustomShow<T> extends ${package}.pages.Show {

	public abstract Class<T> getType();

	final protected void onActivate(String id) {
		super.onActivate(getType(), id);
	}

	@Override
	final protected Object[] onPassivate() {
		return new Object[]{getBean()};
	}
}