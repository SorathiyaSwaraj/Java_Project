package com.movie.project.MovieTicket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.movie.project.MovieTicket.entity.Admin;
import com.movie.project.MovieTicket.entity.roles;
import com.movie.project.MovieTicket.entity.Customer;
import com.movie.project.MovieTicket.entity.User;
import com.movie.project.MovieTicket.entity.Movies;
import com.movie.project.MovieTicket.entity.Ticket;
import com.movie.project.MovieTicket.repo.AdminRepo;
import com.movie.project.MovieTicket.repo.CustomerRepo;
import com.movie.project.MovieTicket.repo.MoviesRepo;
import com.movie.project.MovieTicket.repo.RolesRepo;
import com.movie.project.MovieTicket.repo.TicketRepo;
import com.movie.project.MovieTicket.repo.UserRepo;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	CustomerRepo customerRepo ;
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	MoviesRepo moviesRepo;
	@Autowired
	TicketRepo ticketRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	RolesRepo rolesRepo;
	
	@GetMapping("/customer")
	public List<Customer> findAll() {
		List<Customer> ls = customerRepo.findAll();
		for(Customer c: ls) {
			System.out.println(c.getName());
		}
		return ls;
	}
	@GetMapping("/customer/{customer_id}")
    public Customer findCustomernById(@PathVariable("customer_id") Long customerId) {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            System.out.println(customer.getName());
            return customer;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
    }
	

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		return customerRepo.save(theCustomer);
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		return customerRepo.save(theCustomer);
	}
	
	@DeleteMapping("/customer")
	public void deleteCustomer(@RequestBody Customer theCustomer) {
		 customerRepo.delete(theCustomer);
		 System.out.println("Deleted");
	}
	
	@DeleteMapping("/customer/{customer_id}")
	public void deleteCustomerById(@PathVariable("customer_id") Long customerId) {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        Customer customer = customerOptional.get();
		customerRepo.delete(customer);
		 System.out.println(customer.getName() + " Deleted");
	}
	
	
//---------------------------------	ADMIN CRUD -------------------------------------------------
	
	
	@GetMapping("/admin")
	public List<Admin> findAllAdmin() {
		List<Admin> ls = adminRepo.findAll();
		for(Admin c: ls) {
			System.out.println(c.getName());
		}
		return ls;
	}
	
	@GetMapping("/admin/{admin_id}")
    public Admin findAdminById(@PathVariable("admin_id") Long adminId) {
        Optional<Admin> adminOptional = adminRepo.findById(adminId);
        
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            System.out.println(admin.getName());
            return admin;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }
    }
	
	@PostMapping("/admin")
	public Admin addAdmin(@RequestBody Admin theAdmin) {
//		Admin ad = theAdmin;
//		User u = userRepo.getReferenceById(user_id);
//		ad.setUser(u);
		return adminRepo.save(theAdmin);
	}
	
	@PutMapping("/admin")
	public Admin updateAdmin(@RequestBody Admin theAdmin) {
		return adminRepo.save(theAdmin);
	}
	
	
	@DeleteMapping("/admin")
	public void deleteAdmin(@RequestBody Admin theAdmin) {
		adminRepo.delete(theAdmin);
		 System.out.println("Deleted");
	}
	
	@DeleteMapping("/admin/{admin_id}")
	public void deleteAdminById(@PathVariable("admin_id") Long adminId) {
        Optional<Admin> adminOptional = adminRepo.findById(adminId);
        Admin admin = adminOptional.get();
		adminRepo.delete(admin);
		 System.out.println(admin.getName() + " Deleted");
	}
	
	
	//---------------------------------	MOVIE CRUD -------------------------------------------------
	
	@GetMapping("/movies")
	public List<Movies> findAllMovies() {
		List<Movies> ls = moviesRepo.findAll();
		for(Movies c: ls) {
			System.out.println(c.getName());
		}
		return ls;
	}
	
	
	@GetMapping("/movies/{movies_id}")
    public Movies findMoviesById(@PathVariable("movies_id") Long moviesId) {
        Optional<Movies> adminOptional = moviesRepo.findById(moviesId);
        
        if (adminOptional.isPresent()) {
            Movies movies= adminOptional.get();
            System.out.println(movies.getName());
            return movies;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }
    }
	
	@PostMapping("/movies")
	public Movies addMovies(@RequestBody Movies theMovies) {
		return moviesRepo.save(theMovies);
	}
	
	@PutMapping("/movies")
	public Movies updateMovies(@RequestBody Movies theMovies) {
		
		return moviesRepo.save(theMovies);
	}
	
	@DeleteMapping("/movies")
	public void deleteMovies(@RequestBody Movies theMovies) {
		moviesRepo.delete(theMovies);
		 System.out.println("Deleted");
	}
	
//	@DeleteMapping("/movies/{movies_id}")
//	public void deleteMoviesById(@PathVariable Long movies_id) {
//		System.out.println("HELLO");
//        Optional<Movies> movieOptional = moviesRepo.findById(movies_id);
//        Movies movies = movieOptional.get();
//		moviesRepo.delete(movies);
//		 System.out.println(movies.getName() + "  Deleted");
//	}
	
	
	//---------------------------------	TICKET CRUD -------------------------------------------------
	
	@GetMapping("/ticket")
	public List<Ticket> findAllTicket() {
		List<Ticket> ls = ticketRepo.findAll();
		for(Ticket c: ls) {
			System.out.println(c.getTicket_id());
		}
		return ls;
	}
	
	@GetMapping("/ticket/{ticket_id}")
    public Ticket findTicketById(@PathVariable("ticket_id") Long ticketId) {
        Optional<Ticket> adminOptional = ticketRepo.findById(ticketId);
        
        if (adminOptional.isPresent()) {
        	Ticket ticket= adminOptional.get();
            System.out.println(ticket.getTicket_id());
            return ticket;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }
    }
	
	@PostMapping("/ticket/{movie_id}/{customer_id}")
	public Ticket addTicket(@RequestBody Ticket theTicket, @PathVariable Long movie_id,@PathVariable Long customer_id) {
		Movies m1 = moviesRepo.getReferenceById(movie_id);
		Customer c1 = customerRepo.getReferenceById(customer_id);
		theTicket.setMovie(m1);
		theTicket.setCustomer(c1);
		return ticketRepo.save(theTicket);
	}
	
	@PutMapping("/ticket/{movie_id}/{customer_id}")
	public Ticket updateTicket(@RequestBody Ticket theTicket,@PathVariable Long movie_id,@PathVariable Long customer_id) {
		Movies m1 = moviesRepo.getReferenceById(movie_id);
		Customer c1 = customerRepo.getReferenceById(customer_id);
		theTicket.setMovie(m1);
		theTicket.setCustomer(c1);
		return ticketRepo.save(theTicket);
	}
	
	@DeleteMapping("/ticket")
	public void deleteTicket(@RequestBody Ticket theTicket) {
		ticketRepo.delete(theTicket);
		 System.out.println("Deleted");
	}
	
	
	@DeleteMapping("/ticket/{ticket_id}")
	public void deleteTicketById(@PathVariable("ticket_id") Long ticketId) {
        Optional<Ticket> adminOptional = ticketRepo.findById(ticketId);
        Ticket ticket = adminOptional.get();
        ticketRepo.delete(ticket);
		 System.out.println(ticket.getTicket_id() + " Deleted");
	}
	
	
	@PostMapping("/addCustomerUser")
	public User addCustomerUser(@RequestBody User user) {
		User user1 = userRepo.save(user);
		roles userRole = new roles();
		userRole.setUser_id(user1);
		userRole.setRole("ROLE_CUSTOMER");
		rolesRepo.save(userRole);
		return user1;
		
	}
	
	@PostMapping("/addAdminUser")
	public User addAdminUser(@RequestBody User user) {
		User u = userRepo.save(user);
		roles userRole = new roles();
		userRole.setUser_id(u);
		userRole.setRole("ROLE_ADMIN");
		rolesRepo.save(userRole);
		return u;
	}
} 

