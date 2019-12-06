package com.izi.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany(mappedBy = "directors", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Movie> movies;
}
