
public class Warehouse {
	private String name;
	private String location;
	private int capacity;
	
	Warehouse(){
		this.name = "";
		this.location = "";
		this.capacity = 0;
	}
	
	Warehouse(String name_, String location_, int capacity_)
	{
		this.name = name_;
		this.location = location_;
		this.capacity = capacity_;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public void setName(String name_)
	{
		this.name = name_;
	}
	
	public void setLocation(String location_)
	{
		this.location = location_;
	}
	
	public void setCapacity(int capacity_)
	{
		this.capacity = capacity_;
	}
}
