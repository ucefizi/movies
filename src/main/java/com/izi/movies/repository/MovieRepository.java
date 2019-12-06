package com.izi.movies.repository;

import com.izi.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO repository for @{@link Movie} entity
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
