package com.movie.project.MovieTicket.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movie_id;
	
	@Column(nullable = false)
	private String Name;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
    private Date Release_date;
	
	@Column
	private String Description;
	
	@Lob
    @Column(name = "image_data", columnDefinition = "BLOB")
    private byte[] imageData;
	
	
	

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movies(Long movie_id, String name, Date release_date, String description, byte[] imageData) {
		super();
		this.movie_id = movie_id;
		Name = name;
		Release_date = release_date;
		Description = description;
		this.imageData = imageData;
	}

	public Long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getRelease_date() {
		return Release_date;
	}

	public void setRelease_date(Date release_date) {
		Release_date = release_date;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	
	
}
