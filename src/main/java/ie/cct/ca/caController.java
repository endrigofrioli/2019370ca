package ie.cct.ca;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class caController {

	private ArrayList<Animals> animals;

	public caController() {
		animals = new ArrayList<Animals>();
	}

	// GET http://localhost:8080/hello-world
	@GetMapping("hello-world")
	public String test() {
		return "Hello Farm";
	}

	// POST http://localhost:8080/add-animal
	@PostMapping("add-animal")
	public SuccessResponse addAnimal(@RequestBody Animals animal) {
		animals.add(animal);
		return new SuccessResponse(" ANIMAL [" + animal.getType() + "] added to the farm, WEIGHT is [" +animal.getWeight()+"]");
	} 

	// check video, return a class for animal
//	@GetMapping("average-price")
//	public Float averagePrice() {
//		Float = 0.0f;
//		for(Item itemprice : items) {
//			price += item.getPrice();
//		}
//		price = price/items.size();
//		return price;
//	}
	//GET http://localhost:8080/average-weight
	@GetMapping("average-weight")
	public Float averageWeight() {
		if (animals.size() == 0) {
			throw new NotFoundException("No animals in the farm!");
		}

		Float weight = 0.0f;
		for (Animals animal : animals) {
			weight += animal.getWeight();
		}
		weight = weight / animals.size();
		return weight;

	}
	
	// IF animal=cow AND weight>=350 sell cow add to variable to sell
	//attempt to return number of animals that have more than the desired weight
	// GET http://localhost:8080/canbesold
	@GetMapping("canbesold")
	public int canBeSold() {
		if (animals.size() == 0) {
			throw new NotFoundException("No animals in the farm!");
		}
		int canbesold = 0;
		Float weight = 0.0f;
		for (Animals animal : animals) {
			weight += animal.getWeight();
			if(weight >= 250) {
				//return "Animal: " +animal+ " weight: "+ weight;
				canbesold ++;
			} 
		}
		return canbesold;
				//+ ", " + animals.size();
		
	  
  }
	
	
	
	// CLASS EXAMPLE
//	//GET http://localhost:8080/say-hello?name=Endrigo&surname=Frioli
//	@GetMapping("say-hello")
//	public String sayHello(@RequestParam(required = true) String name, @RequestParam(required = true) String surname) {
//		return "Hello " + name + " " + surname;
//	}

	// GET http://localhost:8080/say-hello?name=Endrigo&surname=Frioli
	@GetMapping("say-hello")
	public String sayHello(@RequestParam(required = true) String animal, 
			@RequestParam(required = true) Float weight) {
		return "Animals to sell: " + animal + " " + weight;
	}

}
