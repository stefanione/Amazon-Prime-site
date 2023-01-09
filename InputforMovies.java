package fileio;
import java.util.ArrayList;
public class InputforMovies {

    private String name;
    private ArrayList<String> genres;
    private String year; //anu aparitiei
    private int duration;
    private ArrayList<String> countriesBanned;
    private ArrayList<String> actors;

    private double rate;

    private int numlikes;

    private int numRatings;

    private double rating;
    /** this method gets rating*/
    public double getRating() {
        return rating;
    }
    /** this method sets rating*/
    public void setRating(final double rating) {
        this.rating = rating;
    }
    /** this method gets name */
    public String getName() {
        return name;
    }
    /** this method sets name */
    public void setName(final String name) {
        this.name = name;
    }
    /** this method gets the genres */
    public ArrayList<String> getGenres() {
        return genres;
    }
    /** this method sets the genres of the movie */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }
    /** this method getsyear */
    public String getYear() {
        return year;
    }
    /** this method setsyear */
    public void setYear(final String year) {
        this.year = year;
    }
    /** this method gets duration */
    public int getDuration() {
        return duration;
    }
    /** this method sets duration */
    public void setDuration(final int duration) {
        this.duration = duration;
    }
    /** this method gets the countriesbanned */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    /** this method sets the countriesbanned */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
    /** this method gets the actors */
    public ArrayList<String> getActors() {
        return actors;
    }
    /** this method sets the actors */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }
    /** this method gets the number of likes */
    public int getNumlikes() {
        return numlikes;
    }
    /** this method sets the number of likes */
    public void setNumlikes(final int numlikes) {
        this.numlikes = numlikes;
    }
    /** this method gets the number of ratings */
    public int getNumRatings() {
        return numRatings;
    }
    /** this method sets the number of ratings */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }
    /** this method gets the rate */
    public double getRate() {
        return rate;
    }
    /** this method sets the rate */
    public void setRate(final double rate) {
        this.rate = rate;
    }
}
