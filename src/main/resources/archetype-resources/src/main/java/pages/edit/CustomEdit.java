package ${package}.pages.edit;

/**
 * Abstract parent class for customized Edit pages.
 *
 * @param <T>
 */
public abstract class CustomEdit<T> extends ${package}.pages.Edit {

	public abstract Class<T> getType();

	final protected void onActivate(String id) {
		super.onActivate(getType(), id);
	}

	@Override
	protected Object[] onPassivate() {
		return new Object[]{getBean()};
	}
}
