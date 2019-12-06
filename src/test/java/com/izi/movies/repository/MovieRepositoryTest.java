package com.izi.movies.repository;

import com.izi.movies.model.Movie;
import com.izi.movies.model.MovieDirector;
import com.izi.movies.model.MovieType;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Tests for @{@link MovieRepository}
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void saveTest() {
        Movie movie = new Movie();
        movie.setTitle("Mock movie");

        MovieType type = new MovieType();
        type.setName("Mock type");

        MovieDirector director = new MovieDirector();
        director.setName("Mock director");

        movie.setDirectors(Collections.singletonList(director));
        movie.setType(type);
        movie.setReleaseDate(new DateTime());

        Movie result = movieRepository.save(movie);

        assertEquals(movie.getTitle(), result.getTitle());
        assertEquals(movie.getType().getName(), result.getType().getName());
        assertEquals(movie.getDirectors().get(0).getName(), result.getDirectors().get(0).getName());
    }

    @Test
    public void deleteTest() {
        assertTrue(movieRepository.findById(5L).isPresent());
        movieRepository.deleteById(5L);
        assertFalse(movieRepository.findById(5L).isPresent());
    }

    @Test
    public void findTest() {
        assertTrue(movieRepository.findById(5L).isPresent());
    }
}