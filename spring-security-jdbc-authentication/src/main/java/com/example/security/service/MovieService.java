package com.example.security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.security.web.model.Movie;

public interface MovieService {
	@Secured("ROLE_USER")
	Movie getMovieByName(String name);
	public void addNewMovies(List<String> movies);
	public Collection<Movie> getAllMovies();
}
