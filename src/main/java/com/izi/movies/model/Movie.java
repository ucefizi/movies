package com.izi.movies.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.izi.movies.utils.DateDeserializer;
import com.izi.movies.utils.DateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that models a movie object
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@ApiModel
@Entity
@Data
@NoArgsConstructor
public class Movie {
    @ApiModelProperty(example = "1")
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(example = "Avengers: Infinity War")
    @Column
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<MovieDirector> directors;

    @ApiModelProperty(example = "25/04/2018")
    @Column
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime releaseDate;

    @OneToOne
    private MovieType type;

    public String toString() {
        return "Movie(title='" + title + "', directors=" + directors + ", " + type + ", releaseDate=" + releaseDate.toString("dd/MM/yyyy") +")";
    }
}
