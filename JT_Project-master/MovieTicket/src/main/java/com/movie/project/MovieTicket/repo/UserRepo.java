package com.movie.project.MovieTicket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.project.MovieTicket.entity.Movies;
import com.movie.project.MovieTicket.entity.User;

public interface UserRepo extends JpaRepository<User,Long>{

}
