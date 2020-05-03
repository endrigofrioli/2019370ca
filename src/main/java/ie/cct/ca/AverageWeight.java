//package ie.cct.ca;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//public class AverageWeight extends Animals {
//
//	@GetMapping("average-weight")
//	public Float averageWeight() {
//		if (animals.size() == 0) {
//			throw new NotFoundException("No animals in the farm!");
//		}
//
//		Float weight = 0.0f;
//		for (Animals animal : animals) {
//			weight += animal.getWeight();
//		}
//		weight = weight / animals.size();
//		return weight;
//
//	}
//
//}
