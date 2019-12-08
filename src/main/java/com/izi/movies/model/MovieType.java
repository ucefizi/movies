package com.izi.movies.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

@ApiModel
@Entity
@Data
@NoArgsConstructor
public class MovieType {

    @ApiModelProperty(example = "1")
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(example = "sci-fi")
    @Column
    private String name;

    @Override
    public String toString() {
        return "type=" + name;
    }
}
