package tiy.com.Movies.unused;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RatingController {
	
	@RequestMapping(path = "/rating", method = RequestMethod.GET) 
 	public String rating(Model model, int numStars, String movie) { 
//		http://localhost:8080/role?fName=John&lName=Ulmer&birthday=Oct&bio=test		
 		Rating r = new Rating(numStars, movie);  
 		model.addAttribute("rating", r); 
 		return "rating";
 	}

}
