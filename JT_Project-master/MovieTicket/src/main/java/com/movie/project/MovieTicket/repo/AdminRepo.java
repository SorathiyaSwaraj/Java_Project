package com.movie.project.MovieTicket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.project.MovieTicket.entity.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {

}
