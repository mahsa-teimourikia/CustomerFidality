
public class Customer {
	private String name;
	private String location;
	private int age;
	private String group;
	
	Customer(){
		this.name = "";
		this.location = "";
		this.age = 0;
		this.group = "";
	}
	
	Customer(String name_, String location_, int age_, String group_)
	{
		this.name = name_;
		this.location = location_;
		this.age = age_;
		this.group = group_;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getGroup()
	{
		return group;
	}
	
	public void setName(String name_)
	{
		this.name = name_;
	}
	
	public void setLocation(String location_)
	{
		this.location = location_;
	}
	
	public void setAge(int age_)
	{
		this.age = age_;
	}
	
	public void setGroup(String group_)
	{
		this.group = group_;
	}
}
