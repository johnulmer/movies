package tiy.com.Movies.unused;

import java.util.List;
import tiy.com.Movies.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	@Query("select m from Movie m where "
			+ "(:title is null OR UPPER(m.title) LIKE UPPER(CONCAT('%',:title,'%')))")
	public List<Movie> findMovieBySearch(@Param("title") String title);

}
