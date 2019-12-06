package com.izi.movies.repository;

import com.izi.movies.model.MovieDirector;
import com.izi.movies.model.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO repository for @{@link MovieType} entity
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */
@Repository
public interface MovieTypeRepository extends JpaRepository<MovieType, Long> {
}
