package com.movie.project.MovieTicket.entity;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@Entity

public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Ticket_id;
	
	
	@ManyToOne
	private Customer customer;
	
	@Temporal(TemporalType.DATE)
	@FutureOrPresent(message = "Booking date must be in the future or present")
	@Column(nullable = false)
    private Date Booking_date;
	
	
	@Column(nullable = false)
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 100, message = "Value must be at most 100")
    private int Seats;
	
	@ManyToOne
	
	private Movies movie;
	
	@Positive
	@Column(nullable = false) 
	private Long Amount;

	
	//constructor
	

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Long ticket_id, Customer customer, Date booking_date, int seats, Movies movie, Long amount) {
		super();
		Ticket_id = ticket_id;
		this.customer = customer;
		Booking_date = booking_date;
		Seats = seats;
		this.movie = movie;
		this.Amount = amount;
	}
	
	public Long getTicket_id() {
		return Ticket_id;
	}

	public void setTicket_id(Long ticket_id) {
		Ticket_id = ticket_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getBooking_date() {
		return Booking_date;
	}

	public void setBooking_date(Date booking_date) {
		Booking_date = booking_date;
	}

	public int getSeats() {
		return Seats;
	}

	public void setSeats(int seats) {
		Seats = seats;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public Long getAmount() {
		return Amount;
	}

	public void setAmount(Long amount) {
		this.Amount = amount;
	}
	
	
	
	
	
	
	
}
