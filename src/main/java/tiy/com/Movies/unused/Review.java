package tiy.com.Movies.unused;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tiy.com.Movies.Movie;

@Entity
@Table(name = "review")
public class Review implements Serializable {

	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne
	User author;
	
	@ManyToOne(fetch=FetchType.LAZY)
	Movie movie;
	
	String reviewText;
	
	public Review() {
		
	}
	
	public Review(Movie movie, User author, String reviewText) {
		this.movie = movie;
		this.author = author;
		this.reviewText = reviewText;
	}
	
	public Movie getMovie() { 
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public User getAuthor() {
		return this.author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public int getId() {
		return id;
	}
// Helpful?
// Other users liking / rating the review


	
}
