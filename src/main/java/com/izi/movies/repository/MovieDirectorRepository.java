package com.izi.movies.repository;

import com.izi.movies.model.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO repository for @{@link MovieDirector} entity
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */
@Repository
public interface MovieDirectorRepository extends JpaRepository<MovieDirector, Long> {
    MovieDirector findByName(String name);
}
