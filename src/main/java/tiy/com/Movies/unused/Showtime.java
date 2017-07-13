package tiy.com.Movies.unused;

public class Showtime {

	private int id;
	private String showDate;
	private String showTime;
	private String movie;
	
	public Showtime(String showDate, String showTime, String movie) {
		super();
		this.showDate = showDate;
		this.showTime = showTime;
		this.movie = movie;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	
	
}
