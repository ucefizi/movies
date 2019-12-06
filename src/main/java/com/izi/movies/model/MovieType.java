package com.izi.movies.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity that models a movie type object
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */
@Entity
@Data
@NoArgsConstructor
public class MovieType {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
