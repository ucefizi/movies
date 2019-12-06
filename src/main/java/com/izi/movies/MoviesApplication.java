package com.izi.movies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.izi.movies.model.Movie;
import com.izi.movies.model.MovieDirector;
import com.izi.movies.model.MovieType;
import com.izi.movies.repository.MovieDirectorRepository;
import com.izi.movies.repository.MovieRepository;
import com.izi.movies.repository.MovieTypeRepository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.izi.movies.utils.Constants.DATE_FORMAT;

/**
 * Spring boot application
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */

@SpringBootApplication
public class MoviesApplication {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private MovieDirectorRepository directorRepository;
	@Autowired
	private MovieTypeRepository typeRepository;

	private Gson gson = new Gson();

	/**
	 * Loads json data into database
	 * 
	 * @throws IOException when loading the JSON file fails
	 */
	@PostConstruct
	public void loadData() throws IOException {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);

		InputStream is = TypeReference.class.getResourceAsStream("/archive/movies.json");

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();
		String str;
		while ((str = reader.readLine()) != null) {
			sb.append(str);
		}

		String json = sb.toString();

		Type mapsListType = new TypeToken<List<Map<String, Object>>>() {}.getType();

		List<Map<String, Object>> movieMaps = gson.fromJson(json, mapsListType);

		List<Movie> movies = new ArrayList<>();
		for (Map<String, Object> movieMap: movieMaps) {
			Movie movie = new Movie();
			movie.setTitle((String) movieMap.get("title"));
			movie.setReleaseDate(new DateTime(formatter.parseDateTime((String) movieMap.get("releaseDate"))));

			MovieType type = new MovieType();
			type.setName((String) movieMap.get("type"));
			type = typeRepository.save(type);
			movie.setType(type);

			String[] directorStrings = ((String) movieMap.get("director")).split(", ");
			List<MovieDirector> directors = new ArrayList<>();
			for (String directorString: directorStrings) {
				MovieDirector director = directorRepository.findByName(directorString);
				if (director == null) {
					director = new MovieDirector();
					director.setName(directorString);
				}
				directors.add(director);
			}
			directors = directorRepository.saveAll(directors);
			movie.setDirectors(directors);

			movies.add(movie);
		}

		movieRepository.saveAll(movies);
	}

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}
