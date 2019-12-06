package com.izi.movies.service;

import com.izi.movies.model.Movie;
import com.izi.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle operations on @{@link Movie} objects
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}
