package tiy.com.Movies.unused;

public class Rating {
	
	private int id;
	private int numStars;
	private String movie; //FK
	private String user; //FK
	
	public Rating(int numStars, String movie) {
		this.numStars = numStars;
		this.movie = movie;
	}
	
	public Rating() {
		
	}

	public int getNumStars() {
		return numStars;
	}

	public void setNumStars(int numStars) {
		this.numStars = numStars;
	}
	
	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}
	
}
