package tiy.com.Movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping('movie')
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path = "/movie", method = RequestMethod.GET)
		public String movie(Model model, String title, 
				String runtime, Integer year, String plotSummary, Genre genre) {
				Movie m = new Movie("Title", "too long", 34, "things happened", Genre.HORROR);
	//			http://localhost:8080/movie?title=%22title%22&runtime=%22tooLong%22&year=1995&plotSummary=%22pllot%22
				//resetMovies();
				//resetUsers();
				//resetReviews();
				model.addAttribute("movie", m);
				return "movie";
		}
	
	
	private void resetReviews() {
        Review r1 = new Review(movieRepository.findOne(1), userRepository.findOne(1), "review 1");
        reviewRepository.save(r1);
        Review r2 = new Review(movieRepository.findOne(3), userRepository.findOne(1), "review two");
        reviewRepository.save(r2);
        Review r3 = new Review(movieRepository.findOne(2), userRepository.findOne(2), "review three!");
        reviewRepository.save(r3);
		System.out.printf("The database contains %s users.\n", userRepository.count());
		List<Review> reviewList = reviewRepository.findAll();
        for (Review reviewRow : reviewList) {
            System.out.printf("%s) %s\n", reviewRow.getId(), reviewRow.getReviewText());
        }
	}
	
	private void resetUsers() {
		User u1 = new User("john1", "pwd1", "this is john1 screenname", "mail.com");
		userRepository.save(u1);
		User u2 = new User("john2", "pwd2", "this is john2 screenname", "mail2.com");
		userRepository.save(u2);
		User u3 = new User("john3", "pwd3", "this is john3 screenname", "mail3.com");
		userRepository.save(u3);
		System.out.printf("The database contains %s users.\n", userRepository.count());
		List<User> userList = userRepository.findAll();
        for (User userRow : userList) {
            System.out.printf("%s) %s\n", userRow.getId(), userRow.getScreenname());
        }
	}
	private void resetMovies() {
		//System.out.printf("The database contains %s movies.\n", movieRepository.count());
		Movie m = new Movie("Polyester", "hours", 1981, "macrame is learned and hilarity ensues", Genre.HORROR);
		movieRepository.save(m);
		Movie m2 = new Movie("Dune", "a year or two", 1984, "junkies go bald", Genre.DRAMA);
		movieRepository.save(m2);
		Movie m3 = new Movie("It", "three lifespans", 1990, "turtles fight spiders", Genre.ACTION);
		movieRepository.save(m3);
		Movie m4 = new Movie("It's a Wonderful Life", "eternity", 1946, "a cautionary tale about sub-prime lending", Genre.HORROR);
		movieRepository.save(m4);
		System.out.printf("The database contains %s movies.\n", movieRepository.count());
		List<Movie> movieList = movieRepository.findAll();
        for (Movie mRow : movieList) {
            System.out.printf("%s) %s\n", mRow.getId(), mRow.getTitle());
        }
	}
}
