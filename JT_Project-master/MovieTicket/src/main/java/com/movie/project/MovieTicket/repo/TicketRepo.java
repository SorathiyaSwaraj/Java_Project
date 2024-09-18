package com.movie.project.MovieTicket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.project.MovieTicket.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long>{

}
