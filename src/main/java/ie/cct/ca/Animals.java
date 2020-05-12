package ie.cct.ca;

public class Animals {

	private String type;
	private float weight;
	private float price;
	
	
	//default constructor - empty
	public Animals() {
		
	}
	
	
	//default constructors
	//new Animal("cow", 32.1);
	public Animals(String type, float weight, float price) {
	
		this.type = type;
		this.weight = weight;
		this.price = price;
	}
	
	//defining types of animals in the farm, no giraffes sorry
//	enum type{
//		cow, pig, chicken
//	}
//	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
