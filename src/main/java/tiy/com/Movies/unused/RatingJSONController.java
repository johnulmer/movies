package tiy.com.Movies.unused;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Ratings", description="JSON operations pertaining to IMDBClone ratings")
public class RatingJSONController {
		
	@ApiOperation(value = "Return a rating")
	@RequestMapping(path = "/rating.json", method = RequestMethod.GET)
	public Rating jsonRating(int numStars, String movie) {
		return new Rating(numStars, movie);
//		return new Movies("Title", "too long", 34, "things happened", Genre.HORROR);
//		http://localhost:8080/movie.json?title=Title&runtime=too%20long&year=34223423&plotSummary=thingshappened
		}
		
}
