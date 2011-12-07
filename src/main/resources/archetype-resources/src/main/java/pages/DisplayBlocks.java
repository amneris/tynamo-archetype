package ${package}.pages;

import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.services.PropertyOutputContext;

public class DisplayBlocks
{
	@Environmental
	private PropertyOutputContext context;

	public Boolean getCheck()
	{
		return (Boolean) context.getPropertyValue();
	}

}
