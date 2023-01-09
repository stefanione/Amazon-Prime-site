package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public class GoingThroughPurchasedMovies {
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

    /** This method goes through the purchased movies presumably for each user */

    public ArrayNode goThroughPurchasedMovies(final ArrayList<InputforMovies> purchased) {
        ArrayNode purch = objectMapper.createArrayNode();
        if (purchased != null) {
            for (InputforMovies value : purchased) {
                ObjectNode spec;
                spec = print.
                        printSpecificationsForMovie(value);
                purch.add(spec);
            }
        }
        return purch;
    }
}
