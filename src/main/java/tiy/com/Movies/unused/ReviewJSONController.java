package tiy.com.Movies.unused;
 
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation; 

@RestController
@Api(value="Reviews", description="JSON operations pertaining to IMDBClone reviews")
//@EnableWebMvc
public class ReviewJSONController {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Return a list of reviews in the DB.
	 *
	 * @return      reviewList - a list of all reviews.
	 * @see         Review
	 */
	@ApiOperation(value = "Return a list of all reviews")
	@RequestMapping(path = "/api/getAllReviews", method = RequestMethod.GET)
	public List<Review> jsonAllReviews() {
		List<Review> reviewList = new ArrayList<Review>();
		reviewList = reviewRepository.findAll();
		//Movie m = movieRepository.getOne(3);
		//reviewList = reviewRepository.findAll(Movie m);
		return reviewList;
	}

}
