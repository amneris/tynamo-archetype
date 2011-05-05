package ${package}.entities;

import org.tynamo.descriptor.annotation.beaneditor.BeanModel;
import org.tynamo.descriptor.annotation.beaneditor.BeanModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "mydomainobject")
@BeanModels({
		@BeanModel(reorder = "id") // == @ReorderProperties("id")
})
public class MyDomainObject
{
	private Long id;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@NotNull(message = "name can't be null")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MyDomainObject that = (MyDomainObject) o;

		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}

	public int hashCode()
	{
		return (getId() != null ? getId().hashCode() : 0);
	}

	public String toString()
	{
		return getName();
	}
}
