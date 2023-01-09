package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public class GoingThroughRatedmovies {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Print print = new Print();

    /** this method gets the objectMapper variable used for
     * creating arraynodes, objectnodes. */

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /** this method sets the objectMapper variable used for
     * creating arraynodes, objectnodes. */

    public void setObjectMapper(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /** this method gets the print variable used for
     * displaying movie specifications or user specifications */

    public Print getPrint() {
        return print;
    }

    /** this method sets the print variable used for
     * displaying movie specifications or user specifications */

    public void setPrint(final Print print) {
        this.print = print;
    }

    /** This method goes through the rated movies presumably for each user */
    public ArrayNode goThroughRatedMovies(final ArrayList<InputforMovies> rated) {
        ArrayNode rate = objectMapper.createArrayNode();
        if (rated != null) {
            for (InputforMovies inputforMovies : rated) {
                ObjectNode spec;
                spec = print.
                        printSpecificationsForMovie(inputforMovies);
                rate.add(spec);
            }
        }
       return rate;
    }

}
