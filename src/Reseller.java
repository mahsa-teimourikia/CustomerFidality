
public class Reseller {
	private String name;
	private String location;
	
	Reseller(){
		this.name = "";
		this.location = "";
	}
	
	Reseller(String name_, String location_)
	{
		this.name = name_;
		this.location = location_;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setName(String name_)
	{
		this.name = name_;
	}
	
	public void setLocation(String location_)
	{
		this.location = location_;
	}
}
