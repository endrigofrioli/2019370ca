package ie.cct.ca;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class caController {
	
	
	private ArrayList<Item> items;
	
	public caController() {
		items = new ArrayList<Item>();
	}
	

	//GET http://localhost:8080/hello-world
	@GetMapping("hello-world")
	public String test() {
		return "Hello World";
	}
	
	//POST http://localhost:8080/add-item
	@PostMapping("add-item")
	public SuccessResponse addItem(@RequestBody Item item) {
		items.add(item);
		return new SuccessResponse ("Item " + item.getName() + " added.");
	}
	
	
	@GetMapping("average-price")
	public Float averagePrice() {
		Float price = 0.0f;
		for(Item item: items) {
			price += item.getPrice();
		}
		price = price/items.size();
		return price;
	}
	
	
	
	
	

}
