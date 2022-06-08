package toyForm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toyStore")
public class CrudOperations {

	@Autowired
	ToyRepository toyRepo;
	Toy toy = new Toy();
	CrudOperations(ToyRepository toyRepo){
		this.toyRepo=toyRepo;
	}
	
	@GetMapping
	public String options(Model model) {
		
		List<Toy> t = (List<Toy>) toyRepo.findAll();
		model.addAttribute("Toy", toy);
		model.addAttribute("Toys", t);
		return "crudOptions";
	}
	
	@PostMapping
	public String createToys(@ModelAttribute("Toy") Toy toy) {
		
		toyRepo.save(toy);
		return "redirect:/toyStore";
	}
	
	@PostMapping("/updateToyPrice")
	public String updatePrice(@ModelAttribute("Toy") Toy toy) {
		
		Toy findToy = toyRepo.findById(toy.getId()).get();
		findToy.setPrice(toy.price);
		toyRepo.save(findToy);
		return "redirect:/toyStore";
	}
	
	@PostMapping("/deleteToy")
	public String deleteToy(@ModelAttribute("Toy") Toy toy) {
		
		toyRepo.deleteById(toy.getId());
		return "redirect:/toyStore";
	}
	
	
	
	
	
	
}
