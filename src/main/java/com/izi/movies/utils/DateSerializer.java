package com.izi.movies.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

import static com.izi.movies.utils.Constants.DATE_FORMAT;

/**
 * Custom @{@link DateTime} serializer for the format dd/MM/yyyy
 *
 * @author <a href="mailto:youssefizikitn@gmail.com">Youssef Izikitne</a>
 */
public class DateSerializer extends StdSerializer<DateTime> {

    private static DateTimeFormatter formatter =
            DateTimeFormat.forPattern(DATE_FORMAT);

    public DateSerializer() {
        this(null);
    }

    public DateSerializer(Class<DateTime> t) {
        super(t);
    }

    @Override
    public void serialize
            (DateTime value, JsonGenerator gen, SerializerProvider arg2)
            throws IOException {
        gen.writeString(formatter.print(value));
    }
}
