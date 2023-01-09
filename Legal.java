package fileio;

import java.util.ArrayList;

public class Legal {

    /** this method checks if the movies are legal */
    public ArrayList<InputforMovies> checkLegalMovies(final ArrayList<InputforMovies> movies,
                                                      final Inputforusers curruser) {
        ArrayList<InputforMovies> legalmovies = new ArrayList<>();
        for (InputforMovies movie : movies) {
            ArrayList<String> countriesbanned = movie.getCountriesBanned();
            for (int y = 0; y < countriesbanned.size(); y++) {
                if (curruser != null) {
                    if (!countriesbanned.get(y).
                            equals(curruser.getCredentials().getCountry())) {
                        if (y == countriesbanned.size() - 1) {
                            legalmovies.add(movie);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return legalmovies;
    }


}
