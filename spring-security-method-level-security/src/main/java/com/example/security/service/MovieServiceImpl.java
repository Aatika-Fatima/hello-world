package com.example.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Component;

import com.security.web.model.Movie;
@Component
public class MovieServiceImpl implements MovieService {
	private static final Map<String, Movie> MOVIES = new HashMap<String, Movie>();
	static {
		MOVIES.put("die hard", new Movie("Die Hard", "20000000"));
		MOVIES.put("titanic", new Movie("Titanic", "200"));
	}

	@PreAuthorize("#name.length() < 50 and hasRole('ROLE_USER')")
	public Movie getMovieByName(String name) {
		return MOVIES.get(name.toLowerCase());
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PreFilter("not filterObject.contains('badword')")
	@Override
	public void addNewMovies(List<String> movies) {
		for(String movie: movies){
			MOVIES.put(movie, new Movie(movie,"10000"));
		}
		
	}

	@PreAuthorize("isFullyAuthenticated()")
	@PostFilter("(hasRole('ROLE_ADMIN')) or (hasRole('ROLE_USER')) or (hasRole('ROLE_GUEST'))and T(java.lang.Integer).parseInt(filterObject.budget)<50000")
	@Override
	public Collection<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return new ArrayList<Movie>(MOVIES.values());
	}

}
