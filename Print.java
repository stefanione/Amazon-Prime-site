package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Print {
    private final ObjectMapper objectMapper = new ObjectMapper();

    /** this method prints the credentials for the user */
    public ObjectNode printCredentialsForUser(final Inputforusers user) {
        ObjectNode credentials = objectMapper.createObjectNode();

        if (user != null) {
            if (user.getCredentials() != null) {
                credentials.put("name", user.getCredentials().getName());
                credentials.put("password", user.getCredentials().getPassword());
                credentials.put("accountType", user.getCredentials().getAccountType());
                credentials.put("country", user.getCredentials().getCountry());
                String balance = String.valueOf(user.getCredentials().getBalance());
                credentials.put("balance", balance);
            }
        }

        return credentials;
    }

    /** this method prints the specifications for a movie */
    public ObjectNode printSpecificationsForMovie(final InputforMovies movie) {
        ObjectNode specification = objectMapper.createObjectNode();
        ArrayNode actors = objectMapper.createArrayNode();
        ArrayNode genres = objectMapper.createArrayNode();
        ArrayNode countriesBanned = objectMapper.createArrayNode();

        specification.put("name", movie.getName());
        specification.put("year", movie.getYear());
        specification.put("duration", movie.getDuration());

        for (int z = 0; z < movie.getGenres().size(); z++) {
            genres.add(movie.getGenres().get(z));
        }
        specification.set("genres", genres);

        for (int k = 0; k < movie.getActors().size(); k++) {
            actors.add(movie.getActors().get(k));
        }
        specification.set("actors", actors);

        for (int b = 0; b < movie.getCountriesBanned().size(); b++) {
            countriesBanned.add(movie.getCountriesBanned().get(b));
        }
        specification.set("countriesBanned", countriesBanned);
        specification.put("numLikes", movie.getNumlikes());
        specification.put("rating", movie.getRating());
        specification.put("numRatings", movie.getNumRatings());

        return specification;
    }
}
