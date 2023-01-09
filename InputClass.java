package fileio;

import java.util.ArrayList;

public class InputClass {

    private ArrayList<InputforActions> actions;

    private ArrayList<InputforMovies> movies;

    private ArrayList<Inputforusers> users = new ArrayList<>();

    /** this method gets actions */
    public ArrayList<InputforActions> getActions() {
        return actions;
    }
    /** this method sets actions */
    public void setActions(final ArrayList<InputforActions> actions) {
        this.actions = actions;
    }
    /** this method gets movies */
    public ArrayList<InputforMovies> getMovies() {
        return movies;
    }
    /** this method sets movies */
    public void setMovies(final ArrayList<InputforMovies> movies) {
        this.movies = movies;
    }
    /** this method gets users */
    public ArrayList<Inputforusers> getUsers() {
        return users;
    }
    /** this method sets users */
    public void setUsers(final ArrayList<Inputforusers> users) {
        this.users = users;
    }
}
