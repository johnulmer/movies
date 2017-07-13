package tiy.com.Movies.unused;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where "
			+ "(:username is null OR UPPER(u.username) LIKE UPPER(CONCAT('%',:username,'%'))) AND "
			+ "(:screenname is null OR UPPER(u.screenname) LIKE UPPER(CONCAT('%',:screenname,'%')))")
	public List<User> findUserBySearch(@Param("username") String username, @Param("screenname") String screenname);

	
//	Optional<User> findByUsername(String username);
}
