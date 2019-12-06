package com.izi.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that models a movie director object
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@ApiModel
@Entity
@Data
@NoArgsConstructor
public class MovieDirector {

    @ApiModelProperty(example = "1")
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(example = "Anthony RUSSO")
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "directors", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Movie> movies;
}
