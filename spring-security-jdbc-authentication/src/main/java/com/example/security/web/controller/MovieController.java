package com.example.security.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.security.service.MovieService;
import com.security.web.model.Movie;

@Controller
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService moviesService;

	@RequestMapping(method = RequestMethod.GET, value = "/adult/member/{name}")
	@ResponseBody
	public String getMovieByName(@PathVariable String name) {
		Movie movie = moviesService.getMovieByName(name);
		return movie.toString();
	}
	@RequestMapping(method=RequestMethod.GET, value="/adult/allMovies")
	public ModelAndView getAllMovies(){
		 return new ModelAndView("allMovies","movies", moviesService.getAllMovies());
	}

}
