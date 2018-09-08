
public class ProductGroup {
	private String[] types;
	private String name;
	
	ProductGroup() {
		types = null;
		name = "";
	}
	
	ProductGroup(String[] types_, String name_)
	{
		this.types = types_;
		this.name = name_;
	}
	
	public void setTypes(String[] types_)
	{
		this.types = types_;
	}

	public void setName(String name_)
	{
		this.name = name_;
	}
	
	public String[] getTypes()
	{
		return types;
	}
	
	public String getName()
	{
		return name;
	}
}
