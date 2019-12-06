package com.izi.movies.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that models a movie director object
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */
@Entity
@Data
@NoArgsConstructor
public class MovieDirector {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "directors")
    private List<Movie> movies;
}
