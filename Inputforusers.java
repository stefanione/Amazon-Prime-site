package fileio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Inputforusers {

    private static Inputforusers curruser = null;

    private static final int NUMBER = 15;
    private Inputforuser credentials;
    private int token;
    private int numFreeMovies = NUMBER;
    private ArrayList<InputforMovies> purchasedmovies;
    private ArrayList<InputforMovies> watchedmovies;
    private ArrayList<InputforMovies> ratedmovies;
    private ArrayList<InputforMovies> likedmovies;
    private int numlogins;

    public static Inputforusers getInstance() {
        if (curruser == null) {
            curruser = new Inputforusers();
        }

        return curruser;
    }

    /** this method gets the credentials */
    public Inputforuser getCredentials() {
        return credentials;
    }
    /** this method sets the credentials */
    public void setCredentials(final Inputforuser credentials) {
        this.credentials = credentials;
    }
    /** this method gets token */
    public int getToken() {
        return token;
    }
    /** this method sets the token */
    public void setToken(final int token) {
        this.token = token;
    }
    /** this method gets the number of free movies */
    public int getNumFreeMovies() {
        return numFreeMovies;
    }
    /** this method sets the number of free movies */
    public void setNumFreeMovies(final int numFreeMovies) {
        this.numFreeMovies = numFreeMovies;
    }

    /** this method is a getter for the purchased movies for the user */
    public ArrayList<InputforMovies> getPurchasedmovies() {
        return purchasedmovies;
    }

    /** this method is a setter for the purchased movies for the user */
    public void setPurchasedmovies(final ArrayList<InputforMovies> purchasedmovies) {
        this.purchasedmovies = purchasedmovies;
    }

    /** this method is a getter for the watched movies for the user */
    public ArrayList<InputforMovies> getWatchedmovies() {
        return watchedmovies;
    }

    /** this method is a setter for the watched movies for the user */
    public void setWatchedmovies(final ArrayList<InputforMovies> watchedmovies) {
        this.watchedmovies = watchedmovies;
    }

    /** this method is a getter for the rated movies for the user */
    public ArrayList<InputforMovies> getRatedmovies() {
        return ratedmovies;
    }

    /** this method is a setter for the rateed movies for the user */
    public void setRatedmovies(final ArrayList<InputforMovies> ratedmovies) {
        this.ratedmovies = ratedmovies;
    }

    /** this method gets the number of log-ins for the user,
     * used so that every time the user log-ins for a secod time or even
     * log-ins multiple times, gets his progress back,
     * meaning purchased movies, watched movies, liked movies, rated movies */
    public int getNumlogins() {
        return numlogins;
    }

    /** this method sets the number of log-ins,
     * each time the user log-ins the variable numlogins is updated
     * through this setter */
    public void setNumlogins(final int numlogins) {
        this.numlogins = numlogins;
    }

    /** this method gets the liked movies of the user */
    public ArrayList<InputforMovies> getLikedmovies() {
        return likedmovies;
    }

    /** this method is a setter for the likedmovies */
    public void setLikedmovies(final ArrayList<InputforMovies> likedmovies) {
        this.likedmovies = likedmovies;
    }

    /** like putinwatchedmovies, putinratedmovies,
     * these arraylist remembers all the movies that a user has either purchased,
     * watched or rated. */
    private ArrayList<InputforMovies> putinpurchasedmovies = new ArrayList<>();

    /** this method sets the putinpurchasedmovies arraylist */
    public void setPutinpurchasedmovies(final ArrayList<InputforMovies> putinpurchasedmovies) {
        this.putinpurchasedmovies = putinpurchasedmovies;
    }

    /** this method sets the putinwatchedmovies arraylist */
    public void setPutinwatchedmovies(final ArrayList<InputforMovies> putinwatchedmovies) {
        this.putinwatchedmovies = putinwatchedmovies;
    }

    /** this method stores purchasedmovies of a user, in an arraylist */
    public void putinpurchasedmovies(final InputforMovies movie) {
        putinpurchasedmovies.add(movie);
    }

    private ArrayList<InputforMovies> putinwatchedmovies = new ArrayList<>();


    /** this method stores watchedmovies of a user, in an arraylist */
    public void putinwatchedmoviesmovies(final InputforMovies movie) {
        putinwatchedmovies.add(movie);
    }

    private ArrayList<InputforMovies> putinratedmovies = new ArrayList<>();

    /** this method sets the putinpurchasedmovies. */
    public void setPutinratedmovies(final ArrayList<InputforMovies> putinratedmovies) {
        this.putinratedmovies = putinratedmovies;
    }

    /** this method stores rateedmovies of a user, in an arraylist */
    public void putinratedmovies(final InputforMovies movie) {
        putinratedmovies.add(movie);
    }

    /** this method gets the arraylist in which the purchasedmovies of the user are */
    public ArrayList<InputforMovies> getPutinpurchasedmovies() {
        return putinpurchasedmovies;
    }

    /** this method gets the arraylist in which the watchedmovies of the user are */
    public ArrayList<InputforMovies> getPutinwatchedmovies() {
        return putinwatchedmovies;
    }

    /** this method gets the arraylist in which the ratedmovies of the user are */
    public ArrayList<InputforMovies> getPutinratedmovies() {
        return putinratedmovies;
    }

    /** this is an arraylist containing all the genres that the user has subscribed to */
    private ArrayList<String> usergenres;

    /** thsi method gets the usergenres arraylist */
    public ArrayList<String> getUsergenres() {
        return usergenres;
    }

    /** this method sets the usergenres arraylist with an arraylist */
    public void setUsergenres(final ArrayList<String> usergenres) {
        this.usergenres = usergenres;
    }

    /** this method is used to put a genre that a user has subscribed to, one at a time */
    public void genresforuser(final String genre) {
        if (usergenres != null) {
            usergenres.add(genre);
        }
    }

    /** this method returns the arraylist conatining the subscribed genres of the user */
    public ArrayList<String> getgenresforuser() {
        return  usergenres;
    }


}
