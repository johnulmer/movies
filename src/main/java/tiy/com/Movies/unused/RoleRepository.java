package tiy.com.Movies.unused;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tiy.com.Movies.unused.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("select r from Role r where "
			+ "(:fName is null OR UPPER(r.fName) LIKE UPPER(CONCAT('%',:fName,'%'))) AND "
			+ "(:lName is null OR UPPER(r.lName) LIKE UPPER(CONCAT('%',:lName,'%'))) AND "
			+ "(:birthday is null OR UPPER(r.birthday) LIKE UPPER(CONCAT('%',:birthday,'%'))) AND "
			+ "(:bio is null OR UPPER(r.bio) LIKE UPPER(CONCAT('%',:bio,'%')))")
	public List<Role> findPersonBySearch(@Param("fName") String fName, @Param("lName") String lName, @Param("birthday") String birthday, @Param("bio") String bio);
	}
