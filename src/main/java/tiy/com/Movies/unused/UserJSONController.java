package tiy.com.Movies.unused;
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value="Users", description="JSON operations pertaining to IMDBClone users")
//@EnableWebMvc
public class UserJSONController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	/**
	 * Given a user ID (int), return that user from the database.
	 *
	 * @param id An int that is a valid ID for a user.
	 * @return   u (user object) with user name, screen name, password, and email.
	 * @see      User
	 */
	@ApiOperation(value = "Returns a user based on ID")
	@RequestMapping(path = "/api/user/{id}", method = RequestMethod.GET)
	public User userByID(@PathVariable Integer id) {	
		User u = userRepository.getOne(id);
		return u;
	}
	
	/**
	 * Given a user ID (int), delete that user from the database.
	 *
	 * @param id An int that is a valid ID for a user.
	 * @return   u (user object) with user name, screen name, password, and email.
	 * @see      User
	 */
	@ApiOperation(value = "Deletes a user based on ID")
	@RequestMapping(path = "/api/user/{id}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable Integer id) {	
		User u = userRepository.getOne(id);
		userRepository.delete(u);
		return u;
	}
	
	/**
	 * Accepts a JSON User object with title, runtime, year, genre set, 
	 * returns JSON Movie object with auto-generated ID.
	 *
	 * @param addingUser A user object with values for user name, screen name, password, and email.
	 * @return           returnedUser with ID set
	 * @see              User
	 */
	@ApiOperation(value = "Adds a user")
	@RequestMapping(path = "/api/user/", method = RequestMethod.POST)
	public User addUser(@RequestBody User addingUser) {
		User returnedUser = userRepository.save(addingUser);
		return returnedUser;
	}
	
	/**
	 * Accepts a JSON User object with ID and potentially user name, screen name, email, and password set, 
	 * returns updated JSON User object.
	 *
	 * @param updatingUser A user object with values for user name, screen name, password, and email.
	 * @return             u (User object) showing updated values
	 * @see                User
	 */
	@ApiOperation(value = "Updates a user's username, password, screenname, and / or email based on ID")
	@RequestMapping(path = "/api/user/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable Integer id,
			@RequestBody User updatingUser) {
		User u = userRepository.getOne(id);
		if (updatingUser.getUsername() != null) {
			u.setUsername(updatingUser.getUsername());
		}
		if (updatingUser.getPassword() != null) {
			u.setPassword(updatingUser.getPassword());
		}
		if (updatingUser.getScreenname() != null) {
			u.setScreenname(updatingUser.getScreenname());
		}
		if (updatingUser.getEmail() != null) {
			u.setEmail(updatingUser.getEmail());
		}
		userRepository.save(u);
		return u;
	}
	
	/**
	 * Accepts Strings for user name and screen name, returns a list of matching users.
	 *
	 * @param username   A String that will be matched against user names.
	 * @param screenname A String that will be matched against screen names.
	 * @return           userList - a list of matching Users
	 * @see              User
	 */
	@ApiOperation(value = "Search for a user based on username or screenname")
	@RequestMapping(path = "/api/findUsers", method = RequestMethod.GET)
	public List<User> movieSearch(String username, String screenname) {
		List<User> userList = userRepository.findUserBySearch(username, screenname);
		return userList;
	}

	/**
	 * Return a list of users in the DB.
	 *
	 * @return      userList - a list of all Users.
	 * @see         User
	 */
	@ApiOperation(value = "Returns a list of all available users")
	@RequestMapping(path = "/api/getAllUsers", method = RequestMethod.GET)
	public List<User> jsonAllMovies() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
}
