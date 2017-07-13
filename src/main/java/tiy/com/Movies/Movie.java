package tiy.com.Movies;

import java.io.Serializable;


import java.util.List;
import java.util.Set;

import java.util.ArrayList;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModelProperty;
import tiy.com.Movies.unused.Review;
import tiy.com.Movies.unused.Role;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "movie")
public class Movie implements Serializable {
	
	@Id
	@GeneratedValue
//	@Column(name="MOVIE_ID")
	@ApiModelProperty(required = true)
	int id;
	
	@NotNull
	private String title;
	private String runtime;
	private Integer year;
	private String plotSummary;
	private Genre genre;
	
//	@ManyToMany(cascade = CascadeType.ALL) KR
//	@JoinColumn(name = "role_id")
//	@JsonBackReference(value = "secondParent")
	
	@JoinTable(name = "movie_role", joinColumns = @JoinColumn(name = "movie_id") , 
			inverseJoinColumns = @JoinColumn(name = "role_id") )
    @ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie() {
	}
	
	public Movie(int id) {
		this.id = id;
	}
	
	public Movie(String title, String runtime, Integer year, String plotSummary, Genre genre) {
//		this();
		this.title = title;
		this.runtime = runtime;
		this.year = year;
		this.plotSummary = plotSummary;
		this.genre = genre;
	}
	public Movie(int id, String title, String runtime, Integer year, String plotSummary, Genre genre) {
		this.id = id;
		this.title = title;
		this.runtime = runtime;
		this.year = year;
		this.plotSummary = plotSummary;
		this.genre = genre;
	}
	


    @ManyToMany(cascade = CascadeType.ALL, mappedBy="movie")
    private List<Review> reviews;
    
    public List<Review> getReviews() { 
    	return reviews; }

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public int getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPlotSummary() {
		return plotSummary;
	}

	public void setPlotSummary(String plotSummary) {
		this.plotSummary = plotSummary;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
//	public List<Review> getReviewList() {
//		return reviewList;
//	}
}
