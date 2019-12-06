package com.izi.movies.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.izi.movies.utils.DateDeserializer;
import com.izi.movies.utils.DateSerializer;
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
@Entity
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @OneToMany
    private List<MovieDirector> directors;

    @Column
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime releaseDate;

    @OneToOne
    private MovieType type;
}
