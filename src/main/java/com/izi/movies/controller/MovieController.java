package com.izi.movies.controller;

import com.izi.movies.model.Movie;
import com.izi.movies.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

/**
 * REST controller to handle requests on @{@link Movie} objects
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@Log
@Api("Movie API")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @ApiOperation("Returns all movies")
    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        log.info("/movie called with method GET");
        List<Movie> movies = movieService.getAllMovies();
        log.info("/movie returned " + movies);
        return ResponseEntity.ok(movies);
    }

    @ApiOperation("Returns a movie by id")
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable Long id) {
        log.info("/movie/" + id + " called with method GET");
        Movie movie = movieService.getMovieById(id);
        log.info("/movie/" + id + " returned " + movie);
        return ResponseEntity.ok(movie);
    }

    @ApiOperation("Deletes a movie by id and returns 'success'")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("/movie/" + id + " called with method DELETE");
        movieService.deleteMovieById(id);
        log.info("/movie/" + id + " returned 'success'");
        return ResponseEntity.ok("success");
    }

    @ApiOperation("Save a movie, if it exists it updates it")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Movie> save(@RequestBody Movie movie, HttpRequest req) {
        log.info("/movie called with method" + req.getMethod());
        Movie result = movieService.saveMovie(movie);
        log.info("/movie returned " + result);
        return ResponseEntity.ok(result);
    }
}
