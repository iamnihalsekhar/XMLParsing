public class Emp {
    private String name;
	private String age;
	private String desig;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "Employee :- Name = " + name + ", Age = " + age
				+ ", Designation = " + desig;
	}

}
