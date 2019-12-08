package com.izi.movies.service;

import com.izi.movies.model.Movie;
import com.izi.movies.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    private List<Movie> movies;
    private Movie movie;
    private Movie movie1;

    @BeforeEach
    public void init() {
        movie1 = new Movie();
        movie1.setTitle("title1");

        Movie movie2 = new Movie();
        movie2.setTitle("title2");

        movie = new Movie();
        movie.setId(2L);
        movie.setTitle("title1");

        movies = Arrays.asList(movie1, movie2);
    }

    @Test
    void getAllMovies() {
        when(movieRepository.findAll()).thenReturn(movies);
        List<Movie> result = movieService.getAllMovies();
        assertEquals(movies, result);
    }

    @Test
    void getMovieById() {
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie1));
        Movie result = movieService.getMovieById(1L);
        assertEquals(movie1, result);
    }

    @Test
    void saveMovie() {
        when(movieRepository.save(movie1)).thenReturn(movie);
        Movie result = movieService.saveMovie(movie1);
        assertEquals(movie, result);
    }
}