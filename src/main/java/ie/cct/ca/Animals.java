package ie.cct.ca;

public class Animals {

	private String type;
	private float weight;
	
	public Animals() {
		
	}

	//new Animal("cow", 32.1);
	public Animals(String type, float weight) {
		this.type = type;
		this.weight = weight;
	}
	
	
	public String getType() {
		return type;
	}

	public void setName(String name, String type) {
		this.type = type;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

}
