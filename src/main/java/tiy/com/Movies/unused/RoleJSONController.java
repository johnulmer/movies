package tiy.com.Movies.unused;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tiy.com.Movies.Movie;

@RestController
@Api(value="Roles", description="JSON operations pertaining to IMDBClone roles")
public class RoleJSONController implements Serializable{

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Given a movie ID (int) and a role ID (int), add that role to that movie.
	 *
	 * @param movieId An int that is a valid ID for a movie.
	 * @param roleId  An int that is a valid ID for a role.
	 * @see           Movie
	 * @see           Role
	 */
	@ApiOperation(value = "Add an existing role to an exisiting movie by role & movie IDs")
	@RequestMapping(path = "/role/{movieId}/{roleId}", method = RequestMethod.PUT)
	public void addMovieRole(@PathVariable int movieId,
			@PathVariable int roleId) {
		Movie m = movieRepository.findOne(movieId);
		Role r = roleRepository.findOne(roleId);
		m.getRoles().add(r);
		r.getMovies().add(m);
		movieRepository.save(m);
		roleRepository.save(r);
	}

	/**
	 * Given a first name, last name, birthday, and / or bio find Roles that match.
	 *
	 * @param fName    A String that could be part or all of a first name.
	 * @param lName    A String that could be part or all of a last name.
	 * @param birthday A String that could be part or all of a birthday.
	 * @param bio      A String that could be part or all of a bio.
	 * @return         roleList a list of matching roles
	 * @see            Role
	 */
	@ApiOperation(value = "Find roles based on first name, last name, birthday, and or bio")
	@RequestMapping(path = "/role", method = RequestMethod.GET)
	public List<Role> jsonHome(String fName, String lName, String birthday,
			String bio) {
		// http://localhost:8080/role?fName=John&lName=Ulmer&birthday=Oct&bio=test
		List<Role> roleList = roleRepository.findPersonBySearch(fName, lName,
				birthday, bio);
		return roleList;
	}

	/**
	 * Return a list of all roles.
	 *
	 * @return roleList a list of all roles
	 * @see    Role
	 */
	@ApiOperation(value = "Show all roles")
	@RequestMapping(path = "/role/all", method = RequestMethod.GET)
	public List<Role> findAll() {
		// http://localhost:8080/role.json?fName=John&lName=Ulmer&birthday=Oct&bio=test
		List<Role> roleList = roleRepository.findAll();
		return roleList;
	}

	/**
	 * Given a role ID, return that role.
	 *
	 * @param  id A valid role ID (int).
	 * @return role - the role object matching that ID
	 * @see            Role
	 */
	@ApiOperation(value = "Get an existing role based on role ID")
	@RequestMapping(path = "/role/{id}", method = RequestMethod.GET)
	public Role getRole(@PathVariable int id) {
		Role role = roleRepository.getOne(id);
//		System.out.println(role);
		return role;
	}

	/**
	 * Given a JSON Role object, add the Role to the DB and return the generated ID.
	 *
	 * @param  role A Role object that will be added.
	 * @return r The Role object with the generated ID.
	 * @see        Role
	 */
	@ApiOperation(value = "Add a new role")
	@RequestMapping(path = "/role", method = RequestMethod.POST)
	public Role insertRole(@RequestBody Role role) {
		// http://localhost:8080/role?fName=John&lName=Ulmer&birthday=Oct&bio=test
		Role r = new Role();
		//Role r = new Role("john", "ulmer", "oct", "string string string");
		//Role r2 = new Role("herman", "hesse", "nov", "a bio");
		//Role r3 = new Role("jean paul", "sartre", "dec", "a bio?");
		//Role r4 = new Role("immanuel", "kant", "jan", "a new beginning");
		// enter person
		r.setfName(role.getfName());
		r.setlName(role.getlName());
		r.setBirthday(role.getBirthday());
		r.setBio(role.getBio());
		roleRepository.save(r);
//		roleRepository.save(r2);
//		roleRepository.save(r3);
//		roleRepository.save(r4);
		return r;
	}

	/**
	 * Given a role ID, delete that role.
	 *
	 * @param  id   A valid role ID (int).
	 * @return role The role object that was deleted
	 * @see            Role
	 */
	@ApiOperation(value = "Delete an existing role by ID")
	@RequestMapping(path = "/role/{id}", method = RequestMethod.DELETE)
	public Role deleteRole(@PathVariable int id) {
		Role role = roleRepository.findOne(id);
		roleRepository.delete(role);
		System.out.println(role);
		return role;
	}

	// to test, go to postman > PUT > role/id > Body > "raw" radio button >
	// fields to update in {} & ""
	/**
	 * Given a role ID and new property values, update that role.
	 *
	 * @param  id     A valid role ID (int).
	 * @param  role   A role object containing the new values.
	 * @return role   The role object that was updated
	 * @see           Role
	 */
	@ApiOperation(value = "Update a role")
	@RequestMapping(path = "/role/{id}", method = RequestMethod.PUT)
	public Role updateRole(@PathVariable int id, @RequestBody Role role) {
		Role roleRepo = roleRepository.findOne(id);

		if (role.getfName() != null) {
			roleRepo.setfName(role.getfName());
		}
		if (role.getlName() != null) {
			roleRepo.setlName(role.getlName());
		}
		if (role.getBirthday() != null) {
			roleRepo.setBirthday(role.getBirthday());
		}
		if (role.getBio() != null) {
			roleRepo.setBio(role.getBio());
		}

		roleRepository.save(roleRepo);
		return roleRepo;

	}

}
