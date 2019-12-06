package com.izi.movies.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.DateTime;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.izi.movies.utils.Constants.DATE_FORMAT;

/**
 * Custom @{@link DateTime} deserializer for the format dd/MM/yyyy
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */
public class DateDeserializer extends StdDeserializer<DateTime> {

    private SimpleDateFormat formatter =
            new SimpleDateFormat(DATE_FORMAT);

    public DateDeserializer() {
        this(null);
    }

    public DateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DateTime deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException {
        String date = jsonparser.getText();
        try {
            return new DateTime(formatter.parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
