package ie.cct.ca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class caController {

	//array List for animals
	private ArrayList<Animals> animals;

	public caController() {
		animals = new ArrayList<Animals>();

		// I added some animals to help you
//		animals.add(new Animals("cow", 300f, 0f));
//		animals.add(new Animals("cow", 70f, 0f));
//		animals.add(new Animals("pig", 100f, 0f));
//		animals.add(new Animals("pig", 30f, 0f));
//		animals.add(new Animals("chicken", 6.0f, 0f));
//		animals.add(new Animals("chicken", 2.0f, 0f));

	}

	// #1 Endpoint
	// - Add a new animal.
	//Success Response in case of adding an animal
	// POST http://localhost:8080/add-animal
	@PostMapping("add-animal")
	public SuccessResponse addAnimal(@RequestBody Animals animal) {
		animals.add(animal);
		return new SuccessResponse(" Animal: [" + animal.getType().toLowerCase() + "] added to the farm, Weight is ["
				+ animal.getWeight() + "], Price: " + animal.getPrice());
	}

	// #2 endpoint
	// - Calculate the average weight of each type of animal (one endpoint is
	// sufficient, no need to build one per type of animal).
	// GET http://localhost:8080/average-weight
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

	// #3 endpoint
	// Cow - 300 KG PRICE €500 /// Pig 100 KG PRICE €250.0 /// Chicken - 0.5 KG PRICE €5.0
	// - How many animals of each type can be sold right now.
	// GET http://localhost:8080/canbesold
	@GetMapping("canbesold")
	public List<Animals> canBeSold() {

		List<Animals> canbesold = new ArrayList<Animals>();

		// I was trying to show how many animals would be possible to sell,
		// int cow = 0;
		// int pig = 0;
		// int chicken = 0;

		for (Animals animal : animals) {
			if (animal.getType().toLowerCase().equals("cow") && animal.getWeight().compareTo(299.9f) > 0) {
				animal.setPrice(500.0f);
				canbesold.add(animal);
				// cow++;
			}
			if (animal.getType().toLowerCase().equals("pig") && animal.getWeight().compareTo(99.9f) > 0) {
				animal.setPrice(250.0f);
				canbesold.add(animal);
				// pig++;
			}
			if (animal.getType().toLowerCase().equals("chicken") && animal.getWeight().compareTo(4.9f) > 0) {
				animal.setPrice(5.0f);
				canbesold.add(animal);
				// chicken++;
			}
		}
		if (canbesold.size() == 0) {
			throw new NotFoundException("No animals in the farm");
		}
		return canbesold;

	}

	// #4 endpoint
	// - What is the current value of the full farm stock: That is, the price of all
	// the animals that can be sold right now.
	// GET http://localhost:8080/full-stock
	@GetMapping("full-stock")
	public Float fullFarmStock() {

		List<Animals> fullStock = new ArrayList<Animals>();

		Float price = 0f;
		for (Animals animal : animals) {
			if (animal.getType().toLowerCase().equals("cow") && animal.getWeight().compareTo(299.9f) > 0) {
				fullStock.add(animal);
				animal.setPrice(500.0f);
				price += animal.getPrice();

			}
			if (animal.getType().toLowerCase().equals("pig") && animal.getWeight().compareTo(99.9f) > 0) {
				animal.setPrice(250.0f);
				fullStock.add(animal);
				price += animal.getPrice();

			}
			if (animal.getType().toLowerCase().equals("chicken") && animal.getWeight().compareTo(4.9f) > 0) {
				animal.setPrice(5.0f);
				fullStock.add(animal);
				price += animal.getPrice();
			}
		}
		if (fullStock.size() == 0) {
			throw new NotFoundException("No animals in the farm");
		}
		return price;

	}

	// #5 endpoint
	// - What is the current value of the farm assuming the price of each animal is
	// set by a parameter in the HTTP request. This is an example:
	// - http://localhost:8080/current-value?cow=350&pig=120&chicken=1
	@GetMapping("current-value")
	public String currentValue(@RequestParam(required = true) Float cow, @RequestParam(required = true) Float pig,
			@RequestParam(required = true) Float chicken) {
		return ("Current Value is: €" + (cow + pig + chicken));
		
	}
	

	// ADDITIONAL FUNCTIONS

	// WELCOME MESSAGE
	// GET http://localhost:8080/welcome-message
	@GetMapping("welcome-message")
	public String welcome() {

		return new String("Welcome to my Farm!");
	}

	// RETURNING ALL THE ANIMALS
	// GET http://localhost:8080/all-animals
	@GetMapping("all-animals")
	public ArrayList<Animals> getAllAnimals() {
		if (animals.size() == 0) {
			throw new NotFoundException("No animals in the farm!");
		}
		return animals;
	}

	// GET ALL THE CURRENT WEIGHT
	@GetMapping("full-weight")
	public Float fullWeight() {
		if (animals.size() == 0) {
			throw new NotFoundException("No animals in the farm!");
		}

		Float weight = 0.0f;
		for (Animals animal : animals) {
			weight += animal.getWeight();
		}
		return weight;

	}
	
	
	
	

}
