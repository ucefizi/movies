package com.izi.movies.controller;

import com.izi.movies.model.Movie;
import com.izi.movies.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller to handle requests on @{@link Movie} objects
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@Api("Movie API")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @ApiOperation("Returns all movies")
    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @ApiOperation("Returns a movie by id")
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @ApiOperation("Deletes a movie by id and returns 'success'")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok("success");
    }

    @ApiOperation("Save a movie, if it exists it updates it")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }
}
