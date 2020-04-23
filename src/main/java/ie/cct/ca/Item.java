package ie.cct.ca;

public class Item {  //animal?? one class each?

	private String name; // type and weight for animals
	private float price;

	public Item() {

	}

	//new Item("test", 32.1);
	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
