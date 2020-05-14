package ie.cct.ca;

public class Animals {

	private String type;
	private Float weight;
	private Float price;
	
	
	//default constructor - empty
	public Animals() {
		
	}
	
	
	//default constructors
	//new Animal("cow", 32.1);
	public Animals(String type, Float weight, Float price) {
	
		this.type = type;
		this.weight = weight;
		this.price = price;
	}
	
	//defining types of animals in the farm
//	enum type{
//		cow, pig, chicken
//	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
	
}
