package fileio;
public class InputforActions {

private  int count;

private int rate;
private String type;

private String movie;

private String page;

private String feature;

private InputforMovies addedMovie;

    /** getter for addedmovie */
    public InputforMovies getaddedMovie() {
        return addedMovie;
    }

    /** setter for addedMovie */
    public void setaddedMovie(final InputforMovies addedMovie) {
        this.addedMovie = addedMovie;
    }

    private String subscribedGenre;

    /** getter for subscribedGenre */
    public String getSubscribedGenre() {
        return subscribedGenre;
    }

    /** setter for subscribed genre */
    public void setSubscribedGenre(final String subscribedGenre) {
        this.subscribedGenre = subscribedGenre;
    }

    private String deletedMovie;
private Filters filters;

    /** getter for DeletedMovie */
    public String getDeletedMovie() {
        return deletedMovie;
    }

    /** setter for DeletedMovie */
    public void setDeletedMovie(final String deletedMovie) {
        this.deletedMovie = deletedMovie;
    }

    private Inputforuser credentials = new Inputforuser();

private String startsWith;

    /** this method gets credentials */
    public Inputforuser getCredentials() {
        return credentials;
    }
    /** this method sets credentials */
    public void setCredentials(final Inputforuser credential) {
        this.credentials = credential;
    }
    /** this method sets type */
    public String getType() {
        return type;
    }
    /** this method gets type */
    public void setType(final String type) {
        this.type = type;
    }
    /** this method gets page */
    public String getPage() {
        return page;
    }
    /** this method sets page */
    public void setPage(final String page) {
        this.page = page;
    }
    /** this method gets feature */
    public String getFeature() {
        return feature;
    }
    /** this method sets feature */
    public void setFeature(final String feature) {
        this.feature = feature;
    }

    /** this method prints the elements of the class */
    @Override
    public String toString() {
        return "InputforActions{"
                +
                "count="
                + count
                +
                ", rate="
                +
                rate
                +
                ", type='"
                +
                type
                + '\''
                +
                ", movie='"
                +
                movie
                +
                '\''
                +
                ", page='"
                +
                page
                +
                '\''
                +
                ", feature='"
                +
                feature
                +
                '\''
                +
                ", addedMovie='"
                +
                addedMovie
                +
                '\''
                +
                ", subscribedGenre='"
                +
                subscribedGenre
                +
                '\''
                +
                ", deletedMovie='"
                +
                deletedMovie
                +
                '\''
                +
                ", filters="
                +
                filters
                +
                ", credentials="
                +
                credentials
                +
                ", startsWith='"
                +
                startsWith
                +
                '\''
                + '}';
    }

    /** this method gets filters */
    public Filters getFilters() {
        return filters;
    }
    /** this method sets filters */
    public void setFilters(final Filters filter) {
        this.filters = filter;
    }
    /** this method gets startswith string */
    public String getStartsWith() {
        return startsWith;
    }

    /** this method sets startswith string */
    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }
    /** this method gets movie */
    public String getMovie() {
        return movie;
    }
    /** this method sets movie */
    public void setMovie(final String movie) {
        this.movie = movie;
    }
    /** this method gets count */
    public int getCount() {
        return count;
    }
    /** this method sets count */
    public void setCount(final int count) {
        this.count = count;
    }
    /** this method getsrate */
    public int getRate() {
        return rate;
    }
    /** this method sets rate */
    public void setRate(final int rate) {
        this.rate = rate;
    }
}
