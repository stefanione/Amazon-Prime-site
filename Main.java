import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import  java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.*;
import fileio.Print;
public class Main {
    /** This is main method */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputClass inputClass = objectMapper.readValue(new File(args[0]), InputClass.class);
        ArrayNode output = objectMapper.createArrayNode();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        // TODO start here
        String error;
        ArrayList<InputforActions> actions = inputClass.getActions();
        ArrayList<Inputforusers> users = inputClass.getUsers();
        ArrayList<InputforMovies> movies = inputClass.getMovies();
        Inputforusers curruser = null;
        Inputforusers newusr;
        String movieseedetails = null;
        Print print = new Print();
        int purchase = 0, watch = 0, like = 0;
        String page = "neautentificat";
        String previouspage = null;
        String currentpage = null;
        double numrate = 0;
        final int numpremiummovies = 15;
        final int limit = 5;
        final int spent = 10;
        int moneyproblem = 0;
        double newrate;
        double avg;
        int idx = -1;
        int filter = 0;
        int found = 0;
        double rating;
        int fail = 0;
        String olduser = "";
        SortForFilterIncreasingIncreasing sortIncreasingIncreasing;
        SortForFilterIncreasingDecreasing sorIncreasingDecreasing;
        SortingForfilterDecreasingDecreasing sortDecreasingDecreasing;
        SortForFilterDecreasingIncreasing sortDecreasingIncreasing;
        Legal legal = new Legal();
        ArrayList<InputforMovies> currentmovieslist = new ArrayList<>();
        ArrayList<InputforMovies> database = new ArrayList<>();
        ArrayList<InputforMovies> liked = new ArrayList<>();
        ArrayList<InputforMovies> purchased = new ArrayList<>();
        ArrayList<InputforMovies> watched = new ArrayList<>();
        ArrayList<InputforMovies> rated = new ArrayList<>();
        ArrayList<InputforMovies> allpurchased = new ArrayList<>();
        ArrayList<InputforMovies> allwatched = new ArrayList<>();
        ArrayList<InputforMovies> allrated = new ArrayList<>();
        ArrayList<InputforMovies> remainingmovies = new ArrayList<>();
        ArrayList<InputforMovies> purchaseduser;
        ArrayList<InputforMovies> watcheduser;
        ArrayList<InputforMovies> rateduser;
        ArrayList<String> genresforuser = new ArrayList<>();
        ArrayNode notifications = objectMapper.createArrayNode();
        GoingThroughLikedMovies goingThroughLikedMovies = new GoingThroughLikedMovies();
        GoingThroughWatchedMovies goingThroughWatchedMovies = new GoingThroughWatchedMovies();
        GoingThroughPurchasedMovies goingThroughPurchasedMovies = new GoingThroughPurchasedMovies();
        GoingThroughRatedmovies goingThroughRatedmovies = new GoingThroughRatedmovies();
        double oldrate = 0;
        int numlogins = 0;
        int numlikes = 0;
        boolean trueorfalse = false;
        int i;
        for (i = 0; i < actions.size(); i++) {
            ObjectNode node = objectMapper.createObjectNode();
            if (actions.get(i).getType().equals("database")) {
                if (actions.get(i).getFeature().equals("add")) {
                    InputforMovies movietoadd = actions.get(i).getaddedMovie();
                    if (curruser.getCredentials().getCountry() != null && movieseedetails != null) {
                        for (int h = 0; h < movietoadd.getCountriesBanned().size(); h++) {
                            if (curruser.getCredentials().getCountry().
                                    equals(movietoadd.getCountriesBanned().get(h))) {
                                break;
                            } else {
                                database.add(movietoadd);
                                movies.add(movietoadd);
                            }
                        }
                    }
                } else if (actions.get(i).getFeature().equals("delete")) {
                    String deletemovie = actions.get(i).getDeletedMovie();
                    for (int k = 0; k < movies.size(); k++) {
                        if (movies.get(k).getName().equals(deletemovie)) {
                            movies.remove(k);
                        }
                    }
                }
            }
            if (actions.get(i).getType().equals("back")) { // breakpoint
                if (currentpage != null && (currentpage.equals("login")
                        || currentpage.equals("register"))) {
                    error = "Error";
                    node.put("error", error);
                    ArrayNode a = objectMapper.createArrayNode();
                    node.set("currentMoviesList", a);
                    node.set("currentUser", null);
                    output.add(node);
                } else {
                    page = previouspage;
                    if (purchase == 0 && watch == 0 && like == 0) {
                        fail = 1;
                        ObjectNode n = objectMapper.createObjectNode();
                        error = "Error";
                        ArrayNode key = objectMapper.createArrayNode();
                        n.put("error", error);
                        n.set("currentMoviesList", key);
                        n.set("currentUser", null);
                        output.add(n);
                    } else if (purchase == 0) {
                        fail = 1;
                        ObjectNode n = objectMapper.createObjectNode();
                        error = "Error";
                        ArrayNode key = objectMapper.createArrayNode();
                        n.put("error", error);
                        n.set("currentMoviesList", key);
                        n.set("currentUser", null);
                        output.add(n);
                    } else if (purchase == 0 && watch == 0) {
                        fail = 1;
                        ObjectNode n = objectMapper.createObjectNode();
                        error = "Error";
                        ArrayNode key = objectMapper.createArrayNode();
                        n.put("error", error);
                        n.set("currentMoviesList", key);
                        n.set("currentUser", null);
                        output.add(n);
                    } else {
                        if (page.equals("see details")) {
                            ArrayList<InputforMovies> legalmovies;
                            legalmovies = legal.checkLegalMovies(movies, curruser);
                            ObjectNode all = objectMapper.createObjectNode();
                            ArrayNode currentMoviesList = objectMapper.createArrayNode();
                            if (legalmovies.size() != 0) {
                                all.set("error", null);
                                ArrayNode purchasedmovies = objectMapper.createArrayNode();
                                for (InputforMovies legalmovie : legalmovies) {

                                    if (actions.get(i).getMovie() == null) {
                                        if (legalmovie.getName().equals(movieseedetails)) {
                                            ObjectNode specification;
                                            specification =
                                                    print.printSpecificationsForMovie(legalmovie);
                                            currentMoviesList.add(specification);
                                        } else {
                                            ObjectNode specification;
                                            specification =
                                                    print.printSpecificationsForMovie(legalmovie);
                                            currentMoviesList.add(specification);
                                        }
                                    } else {
                                        if (legalmovie.getName().
                                                equals(actions.get(i).getMovie())) {
                                            ObjectNode specification;
                                            specification =
                                                    print.printSpecificationsForMovie(legalmovie);
                                            currentMoviesList.add(specification);
                                        }
                                    }
                                }
                                all.set("currentMoviesList", currentMoviesList);
                                ObjectNode currentUser = objectMapper.createObjectNode();
                                ObjectNode credentials;
                                credentials = print.printCredentialsForUser(curruser);
                                currentUser.set("credentials", credentials);
                                if (curruser.getCredentials().getAccountType().equals("premium")) {
                                    assert curruser != null;
                                    currentUser.put("tokensCount", curruser.getToken());
                                    //curruser.setNumFreeMovies(curruser.getNumFreeMovies() - 1);
                                    currentUser.put(
                                            "numFreePremiumMovies", curruser.getNumFreeMovies());
                                } else if (
                                        curruser.getCredentials().
                                                getAccountType().equals("standard")) {
                                    assert curruser != null;
                                    curruser.setToken(curruser.getToken() - 2);
                                    currentUser.put("tokensCount", curruser.getToken());
                                    curruser.setNumFreeMovies(numpremiummovies);
                                    currentUser.put("numFreePremiumMovies",
                                            curruser.getNumFreeMovies());
                                }
                                ArrayNode c = objectMapper.createArrayNode();
                                ArrayNode liked1 = objectMapper.createArrayNode();
                                liked1 = goingThroughLikedMovies.GoThroughLikedMovies(
                                        liked);
                                ArrayNode wat;
                                wat = goingThroughWatchedMovies.goThroughWatchedMovies(
                                        curruser.getPutinwatchedmovies());
                                ArrayNode purch;
                                purch = goingThroughPurchasedMovies.goThroughPurchasedMovies(
                                        curruser.getPutinpurchasedmovies());
                                ArrayNode rate;
                                rate = goingThroughRatedmovies.goThroughRatedMovies(
                                        curruser.getPutinratedmovies());
                                currentUser.set("purchasedMovies", purch);
                                currentUser.set("watchedMovies", wat);
                                currentUser.set("likedMovies", liked1);
                                currentUser.set("notifications", c);
                                currentUser.set("ratedMovies", rate);
                                all.set("currentUser", currentUser);
                                output.add(all);
                            } else {
                                ObjectNode n = objectMapper.createObjectNode();
                                error = "Error";
                                ArrayNode key = objectMapper.createArrayNode();
                                n.put("error", error);
                                n.set("currentMoviesList", key);
                                n.set("currentUser", null);
                                output.add(n);
                            }

                        }
                    }
                }
            }
            if (actions.get(i).getType().equals("change page")) {
                if (((page.equals("neautentificat")
                        || (page.equals("see details")))
                        && (actions.get(i).getPage().equals("login")
                        || actions.get(i).getPage().equals("register")
                        || actions.get(i).getPage().equals("logout"))
                        || actions.get(i).getPage().equals("see details")
                        || actions.get(i).getPage().equals("movies"))) {
                    page = actions.get(i).getPage();
                    currentpage = actions.get(i).getPage();
                } else {
                    if ((page.equals("autentificat")
                            || page.equals("movies"))
                            && (actions.get(i).getPage().equals("movies")
                            || actions.get(i).getPage().equals("upgrades")
                            || actions.get(i).getPage().equals("logout"))) {
                        page = actions.get(i).getPage();
                        currentpage = actions.get(i).getPage();
                    } else {
                        node = objectMapper.createObjectNode();
                        page = "neautentificat";
                        error = "Error";
                        node.put("error", error);
                        ArrayNode a = objectMapper.createArrayNode();
                        node.set("currentMoviesList", a);
                        node.set("currentUser", null);
                        output.add(node);
                    }
                }
                if (page.equals("logout")) {
                    if (curruser != null) {
                        olduser = curruser.getCredentials().getName();
                        page = "neautentificat";
                        curruser = null;
                        liked = new ArrayList<>();
                        purchased = new ArrayList<>();
                        watched = new ArrayList<>();
                        rated = new ArrayList<>();
                    } else {
                        node = objectMapper.createObjectNode();
                        page = "neautentificat";
                        error = "Error";
                        node.put("error", error);
                        ArrayNode a = objectMapper.createArrayNode();
                        node.set("currentMoviesList", a);
                        node.set("currentUser", null);
                        output.add(node);
                    }
                }
                if (page.equals("movies")) {
                    ArrayList<InputforMovies> moviesuser = new ArrayList<>();
                    for (InputforMovies movie : movies) {
                        ArrayList<String> forbidden = movie.getCountriesBanned();
                        if (forbidden != null) {
                            for (int p = 0; p < forbidden.size(); p++) {
                                if (curruser != null) {
                                    String countryuser = curruser.getCredentials().getCountry();
                                    if (!countryuser.equals(forbidden.get(p))) {
                                        if (p == forbidden.size() - 1) {
                                            moviesuser.add(movie);
                                        }

                                    } else {
                                        break;
                                    }
                                }

                            }
                        }
                    }
                    ObjectNode total = objectMapper.createObjectNode();
                    ArrayNode currentMoviesList = objectMapper.createArrayNode();
                    if (curruser != null) {
                        for (InputforMovies inputforMovies : moviesuser) {
                            ObjectNode specification;
                            specification = print.printSpecificationsForMovie(inputforMovies);
                            currentMoviesList.add(specification);
                        }
                        total.set("error", null);
                        total.set("currentMoviesList", currentMoviesList);
                        ObjectNode currentUser = objectMapper.createObjectNode();
                        ObjectNode credentials;
                        credentials = print.printCredentialsForUser(curruser);
                        currentUser.set("credentials", credentials);
                        if (curruser != null) {
                            currentUser.put("tokensCount", curruser.getToken());
                        }
                        if (curruser != null) {
                            currentUser.put("numFreePremiumMovies", curruser.getNumFreeMovies());
                        }
                        ArrayNode purch = objectMapper.createArrayNode();
                        ArrayNode wat = objectMapper.createArrayNode();
                        ArrayNode liked1 = objectMapper.createArrayNode();
                        ArrayNode rat = objectMapper.createArrayNode();
                        ArrayNode arrayNode = objectMapper.createArrayNode();
                        if (curruser.getNumlogins() == 1 || curruser.getNumlogins() == 0) {
                            if (purchased != null) {
                                for (InputforMovies inputforMovies : purchased) {
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    purch.add(specification);
                                }
                                currentUser.set("purchasedMovies", purch);
                            }
                            if (watched != null) {
                                for (InputforMovies inputforMovies : watched) {
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    wat.add(specification);
                                }
                                currentUser.set("watchedMovies", wat);
                            }
                            if (liked != null) {
                                for (InputforMovies inputforMovies : liked) {
                                    ObjectNode specification;

                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    liked1.add(specification);
                                }
                                currentUser.set("likedMovies", liked1);
                            }
                            if (database.size() != 0) {
                                ArrayNode notification = objectMapper.createArrayNode();
                                ObjectNode message = objectMapper.createObjectNode();
                                ObjectNode movieName = objectMapper.createObjectNode();
                                message.put("message", "ADD");
                                for (int l = 0; l < database.size(); l++) {
                                    message.put("movieName", database.get(l).getName());
                                }
                                notification.add(message);
                                currentUser.set("notifications", notification);
                            } else {
                                currentUser.set("notifications", arrayNode);
                            }
                            if (rated != null) {
                                for (InputforMovies inputforMovies : rated) {
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    rat.add(specification);
                                }
                                currentUser.set("ratedMovies", rat);
                            }
                            total.set("currentUser", currentUser);
                            output.add(total);
                        } else if (curruser.getNumlogins() > 1) {

                            purchased = curruser.getPutinpurchasedmovies();
                            if (purchased != null) {
                                for (InputforMovies inputforMovies : purchased) {
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    purch.add(specification);
                                }
                                currentUser.set("purchasedMovies", purch);
                            }
                            watched = curruser.getPutinwatchedmovies();
                            if (watched != null) {
                                for (InputforMovies inputforMovies : watched) {
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    wat.add(specification);
                                }
                                currentUser.set("watchedMovies", wat);
                            }
                            if (liked != null) {
                                for (InputforMovies inputforMovies : liked) {
                                    ObjectNode specification;

                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    liked1.add(specification);
                                }
                                currentUser.set("likedMovies", liked1);
                            }
                            if (database.size() != 0) {
                                ArrayNode notification = objectMapper.createArrayNode();
                                ObjectNode message = objectMapper.createObjectNode();
                                message.put("message", "ADD");
                                for (int l = 0; l < database.size(); l++) {
                                    message.put("movieName", database.get(l).getName());
                                }
                                notification.add(message);
                                currentUser.set("notifications", notification);
                            } else {
                                currentUser.set("notifications", arrayNode);
                            }
                            rated = curruser.getPutinratedmovies();
                            if (rated != null) {
                                for (InputforMovies inputforMovies : rated) {
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(inputforMovies);
                                    rat.add(specification);
                                }
                                currentUser.set("ratedMovies", rat);
                            }
                            total.set("currentUser", currentUser);
                            output.add(total);
                        }
                    } else if (curruser == null) {
                        error = "Error";
                        total.set("currentMoviesList", currentMoviesList);
                        total.set("currentUser", null);
                        total.put("error", error);
                        output.add(total);
                    }
                }
                if (page.equals("see details")) { // breakpoint
                    ArrayList<InputforMovies> legalmovies;
                    legalmovies = legal.checkLegalMovies(movies, curruser);
                    if (remainingmovies.size() != 0) {
                        for (int h = 0; h < remainingmovies.size(); h++) {
                            if (remainingmovies.get(h).getName() != null) {
                                ObjectNode all = objectMapper.createObjectNode();
                                ArrayNode currentMoviesList = objectMapper.createArrayNode();
                                if (remainingmovies.get(h).getName().
                                        equals(actions.get(i).getMovie())) {
                                    movieseedetails = actions.get(i).getMovie();
                                    all.set("error", null);
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(remainingmovies.
                                                    get(h));
                                    currentMoviesList.add(specification);
                                    all.set("currentMoviesList", currentMoviesList);
                                    ObjectNode currentUser = objectMapper.createObjectNode();
                                    ObjectNode credentials;
                                    credentials =
                                            print.printCredentialsForUser(curruser);
                                    currentUser.set("credentials", credentials);
                                    assert curruser != null;
                                    currentUser.put("tokensCount",
                                            curruser.getToken());
                                    currentUser.put("numFreePremiumMovies",
                                            curruser.getNumFreeMovies());
                                    ArrayNode liked1 = objectMapper.createArrayNode();
                                    if (liked != null) {
                                        for (InputforMovies inputforMovies : liked) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(inputforMovies);
                                            liked1.add(spec);
                                        }
                                    }
                                    ArrayNode wat = objectMapper.createArrayNode();
                                    if (allwatched != null) {
                                        for (InputforMovies item : allwatched) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(item);
                                            wat.add(spec);
                                        }
                                    }
                                    ArrayNode purch = objectMapper.createArrayNode();
                                    if (purch != null) {
                                        for (InputforMovies value : allpurchased) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(value);
                                            purch.add(spec);
                                        }
                                    }
                                    ArrayNode rate = objectMapper.createArrayNode();
                                    if (rate != null) {
                                        for (InputforMovies inputforMovies : allrated) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(inputforMovies);
                                            rate.add(spec);
                                        }
                                    }
                                    ArrayNode b = objectMapper.createArrayNode();
                                    currentUser.set("purchasedMovies", purch);
                                    currentUser.set("watchedMovies", wat);
                                    currentUser.set("likedMovies", liked1);
                                    if (database.size() != 0) {
                                        ArrayNode notification = objectMapper.createArrayNode();
                                        ObjectNode message = objectMapper.createObjectNode();
                                        ObjectNode movieName = objectMapper.createObjectNode();
                                        message.put("message", "ADD");
                                        for (int l = 0; l < database.size(); l++) {
                                            message.put("movieName", database.get(l).getName());
                                        }
                                        notification.add(message);
                                        currentUser.set("notifications", notification);
                                    } else {
                                        currentUser.set("notifications", b);
                                    }
                                    currentUser.set("ratedMovies", rate);
                                    all.set("currentUser", currentUser);
                                    if (fail == 1) {
                                        ObjectNode n = objectMapper.createObjectNode();
                                        error = "Error";
                                        ArrayNode key = objectMapper.createArrayNode();
                                        n.put("error", error);
                                        n.set("currentMoviesList", key);
                                        n.set("currentUser", null);
                                        output.add(n);
                                    } else {
                                        output.add(all);
                                    }
                                } else {
                                    if (h == (remainingmovies.size() - 1)) {
                                        ObjectNode n = objectMapper.createObjectNode();
                                        error = "Error";
                                        ArrayNode key = objectMapper.createArrayNode();
                                        n.put("error", error);
                                        n.set("currentMoviesList", key);
                                        n.set("currentUser", null);
                                        output.add(n);
                                    }
                                }
                            }
                        }
                    } else {
                        if (filter == 1) {
                            ObjectNode n = objectMapper.createObjectNode();
                            error = "Error";
                            ArrayNode key = objectMapper.createArrayNode();
                            n.put("error", error);
                            n.set("currentMoviesList", key);
                            n.set("currentUser", null);
                            output.add(n);
                        } else {
                            if (legalmovies.size() != 0) {
                                ObjectNode all = objectMapper.createObjectNode();
                                ArrayNode currentMoviesList =
                                        objectMapper.createArrayNode();
                                for (int h = 0; h < legalmovies.size(); h++) {
                                    if (legalmovies.get(h).getName() != null) {
                                        if (legalmovies.get(h).getName().
                                                equals(actions.get(i).getMovie())) {
                                            found = 1;
                                            movieseedetails = actions.get(i).getMovie();
                                            ObjectNode specification;
                                            specification =
                                                    print.printSpecificationsForMovie(legalmovies.
                                                            get(h));
                                            currentMoviesList.add(specification);
                                        } else {
                                            if (found == 0 && (h == (legalmovies.size() - 1))) {
                                                ObjectNode n = objectMapper.createObjectNode();
                                                error = "Error";
                                                ArrayNode key = objectMapper.createArrayNode();
                                                n.put("error", error);
                                                n.set("currentMoviesList", key);
                                                n.set("currentUser", null);
                                                output.add(n);
                                            }
                                        }
                                    }
                                }
                                if (found != 0) {
                                    all.set("error", null);
                                    all.set("currentMoviesList", currentMoviesList);
                                    ObjectNode currentUser =
                                            objectMapper.createObjectNode();
                                    ObjectNode credentials;
                                    credentials =
                                            print.printCredentialsForUser(curruser);
                                    currentUser.set("credentials", credentials);
                                    assert curruser != null;
                                    currentUser.put("tokensCount",
                                            curruser.getToken());
                                    currentUser.put("numFreePremiumMovies",
                                            curruser.getNumFreeMovies());
                                    ArrayNode arrayNode1 = objectMapper.createArrayNode();
                                    ArrayNode liked1 = objectMapper.createArrayNode();
                                    if (liked != null) {
                                        for (InputforMovies inputforMovies : liked) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(inputforMovies);
                                            liked1.add(spec);
                                        }
                                    }
                                    ArrayNode wat = objectMapper.createArrayNode();
                                    if (allwatched != null) {
                                        for (InputforMovies item : watched) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(item);
                                            wat.add(spec);
                                        }
                                    }
                                    ArrayNode purch = objectMapper.createArrayNode();
                                    if (purch != null) {
                                        for (InputforMovies value : purchased) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(value);
                                            purch.add(spec);
                                        }
                                    }
                                    ArrayNode rate = objectMapper.createArrayNode();
                                    if (rate != null) {
                                        for (InputforMovies inputforMovies : rated) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(inputforMovies);
                                            rate.add(spec);
                                        }
                                    }
                                    ArrayNode a = objectMapper.createArrayNode();
                                    currentUser.set("purchasedMovies", purch);
                                    currentUser.set("watchedMovies", wat);
                                    currentUser.set("likedMovies", liked1);
                                    currentUser.set("notifications", a);
                                    currentUser.set("ratedMovies", rate);
                                    all.set("currentUser", currentUser);
                                    output.add(all);
                                }
                            } else {
                                ObjectNode n = objectMapper.createObjectNode();
                                error = "Error";
                                ArrayNode key = objectMapper.createArrayNode();
                                n.put("error", error);
                                n.set("currentMoviesList", key);
                                n.set("currentUser", null);
                                output.add(n);
                            }
                        }
                    }
                }
            }
            if (actions.get(i).getType().equals("on page")) {
                node = objectMapper.createObjectNode();
                if (actions.get(i).getFeature().equals("subscribe")) {
                    if (page.equals("see details")) {
                        if (movieseedetails != null) {
                            curruser.genresforuser(actions.get(i).getSubscribedGenre());
                            genresforuser.add(actions.get(i).getSubscribedGenre());
                        }
                    } else {
                        error = "Error";
                        node.put("error", error);
                        ArrayNode a = objectMapper.createArrayNode();
                        node.set("currentMoviesList", a);
                        node.set("currentUser", null);
                        output.add(node);
                    }
                }
                if (actions.get(i).getFeature().equals("login")) {
                    if (page.equals("login")) {
                        ArrayNode currentmovies = objectMapper.createArrayNode();
                        idx = -1;
                        for (int j = 0; j < users.size(); j++) {
                            assert curruser != null;
                            if (actions.get(i).getCredentials().getName().
                                    equals(users.get(j).getCredentials().getName())
                                    && actions.get(i).getCredentials().getPassword().
                                    equals(users.get(j).getCredentials().getPassword())) {
                                idx = j;
                                trueorfalse = true;
                                break;
                            }
                        }
                        if (trueorfalse) {
                            curruser = users.get(idx);
                            numlogins = curruser.getNumlogins();
                            numlogins++;
                            curruser.setNumlogins(numlogins);
                            if (numlogins == 1) {
                                ObjectNode currentUser = objectMapper.createObjectNode();
                                ObjectNode credentials;
                                page = "autentificat";
                                error = null;
                                node.put("error", error);
                                node.set("currentMoviesList", currentmovies);
                                credentials = print.printCredentialsForUser(curruser);
                                currentUser.set("credentials", credentials);
                                int tokencount = 0;
                                currentUser.put("tokensCount", tokencount);
                                currentUser.put("numFreePremiumMovies",
                                        curruser.getNumFreeMovies());
                                ArrayNode arrayNode1 = objectMapper.createArrayNode();
                                currentUser.set("purchasedMovies", arrayNode1);
                                currentUser.set("watchedMovies", arrayNode1);
                                currentUser.set("likedMovies", arrayNode1);
                                currentUser.set("notifications", arrayNode1);
                                currentUser.set("ratedMovies", arrayNode1);
                                node.set("currentUser", currentUser);
                            } else if (numlogins > 1) {
                                ObjectNode currentUser = objectMapper.createObjectNode();
                                ObjectNode credentials;
                                page = "autentificat";
                                error = null;
                                node.put("error", error);
                                node.set("currentMoviesList", currentmovies);
                                credentials = print.printCredentialsForUser(curruser);
                                currentUser.set("credentials", credentials);
                                int tokencount = 0;
                                currentUser.put("tokensCount", tokencount);
                                currentUser.put("numFreePremiumMovies",
                                        curruser.getNumFreeMovies());
                                ArrayNode arrayNode1 = objectMapper.createArrayNode();
                                ArrayNode purch = objectMapper.createArrayNode();
                                ArrayList<InputforMovies> userpurch = new ArrayList<>();
                                userpurch = curruser.getPutinpurchasedmovies();
                                if (userpurch != null) {
                                    for (int t = 0; t < userpurch.size(); t++) {
                                        ObjectNode spec;
                                        spec = print.printSpecificationsForMovie(userpurch.get(t));
                                        purch.add(spec);
                                    }
                                }
                                currentUser.set("purchasedMovies", purch);
                                ArrayNode wat = objectMapper.createArrayNode();
                                ArrayList<InputforMovies> userwat = new ArrayList<>();
                                userwat = curruser.getPutinwatchedmovies();
                                if (userwat != null) {
                                    for (int t = 0; t < userwat.size(); t++) {
                                        ObjectNode spec = objectMapper.createObjectNode();
                                        spec = print.printSpecificationsForMovie(userwat.get(t));
                                        wat.add(spec);
                                    }
                                }
                                currentUser.set("watchedMovies", wat);
                                ArrayNode lik = objectMapper.createArrayNode();
                                ArrayList<InputforMovies> userlik = new ArrayList<>();
                                userlik = curruser.getLikedmovies();
                                if (userlik != null) {
                                    for (int t = userlik.size() - 1; t >= 0; t--) {
                                        ObjectNode spec;
                                        spec = print.printSpecificationsForMovie(userlik.get(t));
                                        lik.add(spec);
                                    }
                                }
                                currentUser.set("likedMovies", arrayNode1);
                                currentUser.set("notifications", arrayNode1);
                                ArrayNode rat = objectMapper.createArrayNode();
                                ArrayList<InputforMovies> userrat = new ArrayList<>();
                                userrat = curruser.getPutinratedmovies();
                                if (userrat != null) {
                                    for (int t = 0; t < userrat.size(); t++) {
                                        ObjectNode spec;
                                        spec = print.printSpecificationsForMovie(userrat.get(t));
                                        rat.add(spec);
                                    }
                                }
                                currentUser.set("ratedMovies", rat);
                                node.set("currentUser", currentUser);
                            }
                        } else {
                            page = "neautentificat";
                            error = "Error";
                            node.put("error", error);
                            ArrayNode a = objectMapper.createArrayNode();
                            node.set("currentMoviesList", a);
                            node.set("currentUser", null);
                        }
                    } else {
                        error = "Error";
                        node.put("error", error);
                        ArrayNode a = objectMapper.createArrayNode();
                        node.set("currentMoviesList", a);
                        node.set("currentUser", null);
                    }
                    output.add(node);
                }
                if (actions.get(i).getFeature().equals("register")) {
                    if (page.equals("register")) {
                        ArrayNode currentmovies = objectMapper.createArrayNode();
                        idx = -1;

                        for (int j = 0; j < users.size(); j++) {
                            assert curruser != null;
                            if (actions.get(i).getCredentials().getName().
                                    equals(users.get(j).getCredentials().getName())
                                    && actions.get(i).getCredentials().getPassword().
                                    equals(users.get(j).getCredentials().getPassword())) {
                                idx = j;
                                trueorfalse = true;
                                break;
                            }
                        }
                        if (!trueorfalse) {
                            newusr = Inputforusers.getInstance();
                            newusr.setCredentials(actions.get(i).getCredentials());
                            users.add(newusr);
                            curruser = newusr;
                            page = "autentificat";
                            ObjectNode currentUser = objectMapper.createObjectNode();
                            ObjectNode credentials;
                            error = null;
                            node.put("error", error);
                            node.set("currentMoviesList", currentmovies);
                            credentials = print.printCredentialsForUser(curruser);
                            currentUser.set("credentials", credentials);
                            int tokencount = 0;
                            currentUser.put("tokensCount", tokencount);
                            currentUser.put("numFreePremiumMovies", numpremiummovies);
                            ArrayNode arrayNode1 = objectMapper.createArrayNode();
                            currentUser.set("purchasedMovies", arrayNode1);
                            currentUser.set("watchedMovies", arrayNode1);
                            currentUser.set("likedMovies", arrayNode1);
                            currentUser.set("notifications", arrayNode1);
                            currentUser.set("ratedMovies", arrayNode1);
                            node.set("currentUser", currentUser);
                        } else {
                            page = "neautentificat";
                            error = "Error";
                            node.put("error", error);
                            ArrayNode a = objectMapper.createArrayNode();
                            node.set("currentMoviesList", a);
                            node.set("currentUser", null);
                        }
                    } else {
                        error = "Error";
                        node.put("error", error);
                        ArrayNode a = objectMapper.createArrayNode();
                        node.set("currentMoviesList", a);
                        node.set("currentUser", null);
                    }
                    output.add(node);
                }
                if (actions.get(i).getFeature().equals("search")) {
                    if (page.equals("movies")) {
                        ArrayList<InputforMovies> moviesuser = new ArrayList<>();
                        ObjectNode total = objectMapper.createObjectNode();
                        if (idx != -1) {
                            curruser = users.get(idx);
                            for (InputforMovies movie : movies) {
                                if ((movie.getName().
                                        startsWith(actions.get(i).getStartsWith()))) {
                                    ArrayList<String> forbidden =
                                            movie.getCountriesBanned();
                                    for (int p = 0; p < forbidden.size(); p++) {
                                        assert curruser != null;
                                        String countryuser = curruser.getCredentials().getCountry();
                                        if (!countryuser.equals(forbidden.get(p))) {
                                            if (p == forbidden.size() - 1) {
                                                moviesuser.add(movie);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        ArrayNode currentMoviesList = objectMapper.createArrayNode();
                        total.set("error", null);
                        for (InputforMovies inputforMovies : moviesuser) {
                            ObjectNode specification;
                            specification = print.printSpecificationsForMovie(inputforMovies);
                            currentMoviesList.add(specification);
                        }
                        total.set("currentMoviesList", currentMoviesList);
                        ObjectNode currentUser = objectMapper.createObjectNode();
                        ObjectNode credentials;
                        credentials = print.printCredentialsForUser(curruser);
                        currentUser.set("credentials", credentials);
                        int tokencount = 0;
                        currentUser.put("tokensCount", tokencount);
                        currentUser.put("numFreePremiumMovies", numpremiummovies);
                        if (actions.get(i).getMovie() == null) {
                            ArrayNode arrayNode1 = objectMapper.createArrayNode();
                            currentUser.set("purchasedMovies", arrayNode1);
                            currentUser.set("watchedMovies", arrayNode1);
                            currentUser.set("likedMovies", arrayNode1);
                            currentUser.set("notifications", arrayNode1);
                            currentUser.set("ratedMovies", arrayNode1);
                        } else if (actions.get(i).getMovie() != null) {
                            ArrayNode arrayNode1 = objectMapper.createArrayNode();
                            for (int h = 0; h < moviesuser.size(); h++) {
                                if (moviesuser.get(h).getName().equals(actions.get(h).getMovie())) {
                                    ObjectNode specification;
                                    specification =
                                            print.printSpecificationsForMovie(moviesuser.get(h));
                                    arrayNode1.add(specification);
                                }
                            }
                            ArrayNode arrayNode2 = objectMapper.createArrayNode();
                            currentUser.set("purchasedMovies", arrayNode1);
                            currentUser.set("watchedMovies", arrayNode1);
                            currentUser.set("likedMovies", arrayNode1);
                            currentUser.set("notifications", arrayNode1);
                            currentUser.set("ratedMovies", arrayNode2);

                        }
                        total.set("currentUser", currentUser);
                        output.add(total);
                    } else {
                        error = "Error";
                        node.put("error", error);
                        ArrayNode arrayNode1 = objectMapper.createArrayNode();
                        node.set("currentMoviesList", arrayNode1);
                        node.set("currentUser", null);
                        output.add(node);
                    }
                }
                if (actions.get(i).getFeature().equals("filter")) { // breakpoint
                    remainingmovies = new ArrayList<>();
                    if (page.equals("movies")) {
                        ArrayList<InputforMovies> legalmovies;
                        if (curruser != null) {
                            legalmovies = legal.checkLegalMovies(movies, curruser);
                            AtomicReference<ArrayList<InputforMovies>> keptmovies =
                                    new AtomicReference<>(new ArrayList<>());
                            for (int r = 0; r < legalmovies.size(); r++) {
                                if (actions.get(i).getFilters().getContains().getActors()
                                        != null) {
                                    for (int k = 0; k < actions.get(i).getFilters().
                                            getContains().getActors().size(); k++) {
                                        for (int j = 0; j < legalmovies.get(r).
                                                getActors().size(); j++) {
                                            String actormovie =
                                                    legalmovies.get(r).getActors().get(j);
                                            String actorcontains =
                                                    actions.get(i).getFilters().
                                                            getContains().getActors().get(k);
                                            if (actormovie.equals(actorcontains)) {
                                                if (k == actions.get(i).getFilters().
                                                        getContains().getActors().size() - 1) {
                                                    remainingmovies.add(legalmovies.get(r));
                                                }
                                            } else {
                                                if (k == actions.get(i).getFilters().
                                                        getContains().getActors().size() - 1) {
                                                    keptmovies.get().add(legalmovies.get(r));
                                                }
                                            }
                                        }
                                    }
                                } else if (actions.get(i).getFilters().
                                        getContains().getActors() == null) {
                                    if (actions.get(i).getFilters().
                                            getContains().getGenre() == null) {
                                        remainingmovies.addAll(legalmovies);
                                        break;
                                    } else if (actions.get(i).getFilters().
                                            getContains().getGenre() != null) {
                                        if (curruser != null) {
                                            legalmovies = legal.checkLegalMovies(movies, curruser);
                                            for (int p = 0; p < legalmovies.size(); p++) {
                                                if (actions.get(i).getFilters().
                                                        getContains().getGenre() != null) {
                                                    for (int k = 0; k < actions.get(i).getFilters().
                                                            getContains().getGenre().size(); k++) {
                                                        for (int j = 0; j < legalmovies.get(r).
                                                                getGenres().size(); j++) {
                                                            String genremovie =
                                                                    legalmovies.get(p).
                                                                            getGenres().get(j);
                                                            String genrecontains =
                                                                    actions.get(i).getFilters().
                                                                            getContains().
                                                                            getGenre().get(k);
                                                            if (actions.get(i).getFilters().
                                                                    getContains().getGenre()
                                                                    != null) {
                                                                if (genremovie.
                                                                        equals(genrecontains)) {
                                                                    if (k == actions.get(i).
                                                                            getFilters().
                                                                            getContains().
                                                                            getGenre().
                                                                            size() - 1) {
                                                                        remainingmovies.
                                                                                add(legalmovies.
                                                                                        get(p));
                                                                    }
                                                                } else {
                                                                    if (k == actions.get(i).
                                                                            getFilters().
                                                                            getContains().
                                                                            getGenre().
                                                                            size() - 1) {
                                                                        keptmovies.get().
                                                                                add(legalmovies.
                                                                                        get(p));
                                                                    }
                                                                }
                                                            } else {
                                                                if (genremovie.
                                                                        equals(genrecontains)) {
                                                                    if (k == actions.get(i).
                                                                            getFilters().
                                                                            getContains().
                                                                            getGenre().
                                                                            size() - 1) {
                                                                        remainingmovies.
                                                                                add(legalmovies.
                                                                                        get(r));
                                                                    }
                                                                } else {
                                                                    if (k == actions.get(i).
                                                                            getFilters().
                                                                            getContains().
                                                                            getGenre().
                                                                            size() - 1) {
                                                                        keptmovies.get().add(
                                                                                legalmovies.
                                                                                        get(r));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (actions.get(i).getFilters().
                                                        getContains().getGenre() == null) {
                                                    remainingmovies.addAll(legalmovies);
                                                    break;
                                                }
                                            }
                                            if (actions.get(i).getFilters().getSort().
                                                    getDuration() != null
                                                    && actions.get(i).
                                                    getFilters().getSort().
                                                    getRating() != null) {
                                                if (actions.get(i).getFilters().
                                                        getSort().getRating().
                                                        equals("increasing")
                                                        && actions.get(i).getFilters().
                                                        getSort().getDuration().
                                                        equals("increasing")) {
                                                    sortIncreasingIncreasing =
                                                            new SortForFilterIncreasingIncreasing();
                                                    sortIncreasingIncreasing.
                                                            sortIncreasingIncreasing(
                                                                    remainingmovies);
                                                } else if (actions.get(i).getFilters().
                                                        getSort().getRating().
                                                        equals("increasing")
                                                        && actions.get(i).getFilters().
                                                        getSort().getDuration().
                                                        equals("decreasing")) {
                                                    sorIncreasingDecreasing =
                                                            new SortForFilterIncreasingDecreasing();
                                                    sorIncreasingDecreasing.
                                                            sortFilterIncreasingDecreasing(
                                                                    remainingmovies);
                                                } else if (actions.get(i).getFilters().
                                                        getSort().getRating().
                                                        equals("decreasing")
                                                        && actions.get(i).getFilters().
                                                        getSort().getDuration().
                                                        equals("decreasing")) {
                                                    sortDecreasingDecreasing =
                                                            new SortingForfilterDecreasingDecreasing();
                                                    sortDecreasingDecreasing.
                                                            sortForFilterDecreasingDecreasing(
                                                                    remainingmovies);
                                                } else if (actions.get(i).getFilters().
                                                        getSort().getRating().
                                                        equals("decreasing")
                                                        && actions.get(i).getFilters().
                                                        getSort().getDuration().
                                                        equals("increasing")) {
                                                    sortDecreasingIncreasing =
                                                            new SortForFilterDecreasingIncreasing();
                                                    sortDecreasingIncreasing.
                                                            sortingForFilterDecreasingIncreasing(
                                                                    remainingmovies);
                                                }
                                            }
                                        }
                                        break;
                                    }

                                }
                            }
                            if (actions.get(i).getFilters().getSort().getDuration()
                                    != null && actions.get(i).getFilters().
                                    getSort().getRating() != null) {
                                if (actions.get(i).getFilters().getSort().getRating().
                                        equals("increasing")
                                        && actions.get(i).getFilters().getSort().
                                        getDuration().equals("increasing")) {
                                    sortIncreasingIncreasing =
                                            new SortForFilterIncreasingIncreasing();
                                    sortIncreasingIncreasing.
                                            sortIncreasingIncreasing(remainingmovies);
                                } else if (actions.get(i).getFilters().getSort().getRating().
                                        equals("increasing")
                                        && actions.get(i).getFilters().getSort().getDuration().
                                        equals("decreasing")) {
                                    sorIncreasingDecreasing =
                                            new SortForFilterIncreasingDecreasing();
                                    sorIncreasingDecreasing.
                                            sortFilterIncreasingDecreasing(remainingmovies);
                                } else if (actions.get(i).getFilters().getSort().getRating().
                                        equals("decreasing")
                                        && actions.get(i).getFilters().getSort().getDuration().
                                        equals("decreasing")) {
                                    sortDecreasingDecreasing =
                                            new SortingForfilterDecreasingDecreasing();
                                    sortDecreasingDecreasing.
                                            sortForFilterDecreasingDecreasing(remainingmovies);
                                } else if (actions.get(i).getFilters().getSort().getRating().
                                        equals("decreasing")
                                        && actions.get(i).getFilters().getSort().getDuration().
                                        equals("increasing")) {
                                    sortDecreasingIncreasing =
                                            new SortForFilterDecreasingIncreasing();
                                    sortDecreasingIncreasing.
                                            sortingForFilterDecreasingIncreasing(remainingmovies);
                                }
                            }
                        }
                        ObjectNode node1 = objectMapper.createObjectNode();
                        ArrayNode movieslist = objectMapper.createArrayNode();
                        node1.set("error", null);
                        for (InputforMovies remainingmovie : remainingmovies) {
                            ObjectNode specification;
                            specification =
                                    print.printSpecificationsForMovie(remainingmovie);
                            movieslist.add(specification);
                        }
                        node1.set("currentMoviesList", movieslist);
                        ObjectNode credentials;
                        ObjectNode currentUser = objectMapper.createObjectNode();
                        credentials = print.printCredentialsForUser(curruser);
                        currentUser.set("credentials", credentials);
                        int tokencount = 0;
                        currentUser.put("tokensCount", tokencount);
                        currentUser.put("numFreePremiumMovies", numpremiummovies);
                        ArrayNode arrayNode1 = objectMapper.createArrayNode();
                        currentUser.set("purchasedMovies", arrayNode1);
                        currentUser.set("watchedMovies", arrayNode1);
                        currentUser.set("likedMovies", arrayNode1);
                        currentUser.set("notifications", arrayNode1);
                        currentUser.set("ratedMovies", arrayNode1);
                        node1.set("currentUser", currentUser);
                        output.add(node1);
                    } else if (page.equals("see details")) {
                        filter = 1;
                            ArrayList<InputforMovies> legalmovies;
                            if (curruser != null) {
                                legalmovies = legal.checkLegalMovies(movies, curruser);
                                AtomicReference<ArrayList<InputforMovies>> keptmovies =
                                        new AtomicReference<>(new ArrayList<>());
                                for (int r = 0; r < legalmovies.size(); r++) {
                                    if (actions.get(i).getFilters().
                                            getContains().getGenre() != null) {
                                        for (int k = 0; k < actions.get(i).getFilters().
                                                getContains().getGenre().size(); k++) {
                                            for (int j = 0; j < legalmovies.get(r).
                                                    getGenres().size(); j++) {
                                                String genremovie =
                                                        legalmovies.get(r).getGenres().get(j);
                                                String genrecontains =
                                                        actions.get(i).getFilters().
                                                                getContains().getGenre().get(k);
                                                String actormovie =
                                                        legalmovies.get(r).getActors().get(j);
                                                if (actions.get(i).getFilters().getContains().
                                                        getActors() != null) {
                                                    String actorcontains =
                                                            actions.get(i).getFilters().
                                                                    getContains().getActors().
                                                                    get(k);
                                                    if (genremovie.equals(genrecontains)) {
                                                        if (actormovie.equals(actorcontains)) {
                                                            if (k == actions.get(i).getFilters().
                                                                    getContains().getGenre().
                                                                    size() - 1) {
                                                                remainingmovies.
                                                                        add(legalmovies.get(r));
                                                            }
                                                        }
                                                    } else {
                                                        if (k == actions.get(i).getFilters().
                                                                getContains().getGenre().
                                                                size() - 1) {
                                                            keptmovies.get().add(legalmovies.
                                                                    get(r));
                                                        }
                                                    }
                                                } else {
                                                    if (genremovie.equals(genrecontains)) {
                                                        if (k == actions.get(i).getFilters().
                                                                getContains().getGenre().
                                                                size() - 1) {
                                                            remainingmovies.add(legalmovies.
                                                                    get(r));
                                                        }
                                                    } else {
                                                        if (k == actions.get(i).getFilters().
                                                                getContains().getGenre().
                                                                size() - 1) {
                                                            keptmovies.get().add(legalmovies.
                                                                    get(r));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (actions.get(i).getFilters().
                                            getContains().getGenre() == null
                                            && actions.get(i).getFilters().getSort() != null) {
                                        if (r + 1 < legalmovies.size()) {
                                            if (legalmovies.get(r + 1).getRating()
                                                    > legalmovies.get(r).getRating()) {
                                                Collections.swap(legalmovies, r + 1, r);
                                            }
                                        }
                                        remainingmovies.add(legalmovies.get(r));
                                    }
                                }
                                if (actions.get(i).getFilters().getSort().getDuration()
                                        != null && actions.get(i).getFilters().getSort().getRating()
                                        != null) {
                                    if (actions.get(i).getFilters().getSort().getRating().
                                            equals("increasing")
                                            && actions.get(i).getFilters().getSort().getDuration().
                                            equals("increasing")) {
                                        sortIncreasingIncreasing =
                                                new SortForFilterIncreasingIncreasing();
                                        sortIncreasingIncreasing.
                                                sortIncreasingIncreasing(remainingmovies);
                                    } else if (actions.get(i).getFilters().getSort().getRating().
                                            equals("increasing")
                                            && actions.get(i).getFilters().getSort().getDuration().
                                            equals("decreasing")) {
                                        sorIncreasingDecreasing =
                                                new SortForFilterIncreasingDecreasing();
                                        sorIncreasingDecreasing.
                                                sortFilterIncreasingDecreasing(remainingmovies);
                                    } else if (actions.get(i).getFilters().getSort().getRating().
                                            equals("decreasing")
                                            && actions.get(i).getFilters().getSort().getDuration().
                                            equals("decreasing")) {
                                        sortDecreasingDecreasing =
                                                new SortingForfilterDecreasingDecreasing();
                                        sortDecreasingDecreasing.
                                                sortForFilterDecreasingDecreasing(remainingmovies);
                                    } else if (actions.get(i).getFilters().getSort().getRating().
                                            equals("decreasing")
                                            && actions.get(i).getFilters().getSort().getDuration().
                                            equals("increasing")) {
                                        sortDecreasingIncreasing =
                                                new SortForFilterDecreasingIncreasing();
                                        sortDecreasingIncreasing.
                                                sortingForFilterDecreasingIncreasing(
                                                        remainingmovies);
                                    }
                                }
                            }
                            ObjectNode node1 = objectMapper.createObjectNode();
                            ArrayNode movieslist = objectMapper.createArrayNode();
                            node1.set("error", null);
                            for (InputforMovies remainingmovie : remainingmovies) {
                                ObjectNode specification;
                                specification =
                                        print.printSpecificationsForMovie(remainingmovie);
                                movieslist.add(specification);
                            }
                            node1.set("currentMoviesList", movieslist);
                            ObjectNode credentials;
                            ObjectNode currentUser = objectMapper.createObjectNode();
                            credentials = print.printCredentialsForUser(curruser);
                            currentUser.set("credentials", credentials);
                            int tokencount = 0;
                            currentUser.put("tokensCount", tokencount);
                            currentUser.put("numFreePremiumMovies", curruser.getNumFreeMovies());
                            ArrayNode arrayNode1 = objectMapper.createArrayNode();
                            ArrayNode purch;
                            ArrayNode wat;
                            ArrayNode rat;
                            purch = goingThroughPurchasedMovies.
                                goThroughPurchasedMovies(curruser.getPutinpurchasedmovies());
                            currentUser.set("purchasedMovies", purch);
                            wat = goingThroughWatchedMovies.
                                goThroughWatchedMovies(curruser.getPutinwatchedmovies());
                            currentUser.set("watchedMovies", wat);
                            currentUser.set("likedMovies", arrayNode1);
                            currentUser.set("notifications", arrayNode1);
                            rat = goingThroughRatedmovies.
                                goThroughRatedMovies(curruser.getPutinratedmovies());
                            currentUser.set("ratedMovies", rat);
                            node1.set("currentUser", currentUser);
                            if (fail == 1) {
                                error = "Error";
                                ArrayNode a2 = objectMapper.createArrayNode();
                                ObjectNode node2 = objectMapper.createObjectNode();
                                node2.put("error", error);
                                node2.set("currentMoviesList", a2);
                                node2.set("currentUser", null);
                                output.add(node2);
                            } else {
                                output.add(node1);
                            }
                    } else {
                        error = "Error";
                        ArrayNode a2 = objectMapper.createArrayNode();
                        ObjectNode node2 = objectMapper.createObjectNode();
                        node2.put("error", error);
                        node2.set("currentMoviesList", a2);
                        node2.set("currentUser", null);
                        output.add(node2);
                    }
                }
                if (actions.get(i).getFeature().equals("buy tokens")) {
                    if (page.equals("upgrades")) {
                        assert curruser != null;
                        int balance = curruser.getCredentials().getBalance();
                        int tokens = curruser.getToken();
                        int count = actions.get(i).getCount();
                        tokens += count;
                        curruser.setToken(tokens);
                        balance -= count;
                        curruser.getCredentials().setBalance(balance);
                    }
                }
                if (actions.get(i).getFeature().equals("buy premium account")) {
                    if (page.equals("upgrades")) {
                        assert curruser != null;
                        int spend = curruser.getToken();
                        spend -= spent;
                        curruser.setToken(spend);
                        curruser.getCredentials().setAccountType("premium");
                    }
                }
                if (actions.get(i).getFeature().equals("purchase")) { // breakpoint
                    purchase = 1;
                    if (page.equals("see details")) {
                        ArrayList<InputforMovies> legalmovies;
                        legalmovies = legal.checkLegalMovies(movies, curruser);
                        ObjectNode all = objectMapper.createObjectNode();
                        ArrayNode currentMoviesList = objectMapper.createArrayNode();
                        if (legalmovies.size() != 0) {
                            all.set("error", null);
                            ArrayNode purchasedmovies = objectMapper.createArrayNode();
                            for (InputforMovies legalmovie : legalmovies) {
                                if (actions.get(i).getMovie() == null) {
                                    if (legalmovie.getName().equals(movieseedetails)) {
                                        ObjectNode specification;
                                        specification =
                                                print.printSpecificationsForMovie(legalmovie);
                                        currentMoviesList.add(specification);
                                    }
                                } else {
                                    if (legalmovie.getName().
                                            equals(actions.get(i).getMovie())) {
                                        ObjectNode specification;
                                        specification =
                                                print.printSpecificationsForMovie(legalmovie);
                                        currentMoviesList.add(specification);
                                    }
                                }
                            }
                            all.set("currentMoviesList", currentMoviesList);
                            ObjectNode currentUser = objectMapper.createObjectNode();
                            ObjectNode credentials;
                            credentials = print.printCredentialsForUser(curruser);
                            currentUser.set("credentials", credentials);
                            if (curruser.getCredentials().getAccountType().equals("premium")
                                    && curruser.getNumlogins() == 1) {
                                assert curruser != null;
                                currentUser.put("tokensCount", curruser.getToken());
                                curruser.setNumFreeMovies(curruser.getNumFreeMovies() - 1);
                                currentUser.put("numFreePremiumMovies",
                                        curruser.getNumFreeMovies());
                            } else if (curruser.getCredentials().getAccountType().
                                    equals("standard")) {
                                assert curruser != null;
                                curruser.setToken(curruser.getToken() - 2);
                                currentUser.put("tokensCount", curruser.getToken());
                                if (curruser.getToken() < 0) {
                                    moneyproblem = 1;
                                }
                                curruser.setNumFreeMovies(numpremiummovies);
                                currentUser.put("numFreePremiumMovies",
                                        curruser.getNumFreeMovies());
                            }
                            int err = 0;
                            for (InputforMovies legalmovie : legalmovies) {
                                int waspurchased = 0;
                                if (actions.get(i).getMovie() == null) {
                                    if (legalmovie.getName().equals(movieseedetails)) {
                                        for (InputforMovies inputforMovies : allpurchased) {
                                            if (inputforMovies.getName().equals(movieseedetails)
                                                    && (curruser.getNumlogins() > 1)) {
                                                waspurchased = 1;
                                                break;
                                            }
                                        }
                                        if (waspurchased == 0) {
                                            ObjectNode spec;
                                            purchased.add(legalmovie);
                                            allpurchased.add(legalmovie);
                                            currentmovieslist.add(legalmovie);
                                            curruser.putinpurchasedmovies(legalmovie);
                                            spec = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            purchasedmovies.add(spec);
                                        } else {
                                            err = 1;
                                        }
                                    }
                                } else {
                                    if (legalmovie.getName().
                                            equals(actions.get(i).getMovie())) {
                                        for (InputforMovies inputforMovies : allpurchased) {
                                            if (inputforMovies.getName().
                                                    equals(actions.get(i).getMovie())) {
                                                waspurchased = 1;
                                                break;
                                            }
                                        }
                                        if (waspurchased == 0) {
                                            ObjectNode spec;
                                            purchased.add(legalmovie);
                                            allpurchased.add(legalmovie);
                                            currentmovieslist.add(legalmovie);
                                            spec = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            purchasedmovies.add(spec);
                                        } else {
                                            err = 1;
                                        }
                                    }
                                }
                            }
                            if (err == 1) {
                                ObjectNode n = objectMapper.createObjectNode();
                                error = "Error";
                                ArrayNode key = objectMapper.createArrayNode();
                                n.put("error", error);
                                n.set("currentMoviesList", key);
                                n.set("currentUser", null);
                                output.add(n);
                            } else {
                                ArrayNode c = objectMapper.createArrayNode();
                                ArrayNode liked1;
                                liked1 = goingThroughLikedMovies.GoThroughLikedMovies(
                                        liked);
                                ArrayNode wat;
                                wat = goingThroughWatchedMovies.goThroughWatchedMovies(
                                        curruser.getPutinwatchedmovies());
                                ArrayNode purch;
                                purch = goingThroughPurchasedMovies.goThroughPurchasedMovies(
                                        curruser.getPutinpurchasedmovies());
                                ArrayNode rate;
                                rate = goingThroughRatedmovies.goThroughRatedMovies(
                                        curruser.getPutinratedmovies());
                                currentUser.set("purchasedMovies", purch);
                                currentUser.set("watchedMovies", wat);
                                currentUser.set("likedMovies", liked1);
                                currentUser.set("notifications", c);
                                currentUser.set("ratedMovies", rate);
                                all.set("currentUser", currentUser);
                                if (moneyproblem == 1) {
                                    ObjectNode n = objectMapper.createObjectNode();
                                    error = "Error";
                                    ArrayNode key = objectMapper.createArrayNode();
                                    n.put("error", error);
                                    n.set("currentMoviesList", key);
                                    n.set("currentUser", null);
                                    output.add(n);
                                } else {
                                    output.add(all);
                                }
                            }
                        } else {
                            ObjectNode n = objectMapper.createObjectNode();
                            error = "Error";
                            ArrayNode key = objectMapper.createArrayNode();
                            n.put("error", error);
                            n.set("currentMoviesList", key);
                            n.set("currentUser", null);
                            output.add(n);
                        }
                    }
                }
                if (actions.get(i).getFeature().equals("watch")) {
                    if (purchase == 0) {
                        ObjectNode n = objectMapper.createObjectNode();
                        error = "Error";
                        ArrayNode key = objectMapper.createArrayNode();
                        n.put("error", error);
                        n.set("currentMoviesList", key);
                        n.set("currentUser", null);
                        output.add(n);
                    } else {
                        watch = 1;
                        if (page.equals("see details")) {
                            ArrayNode d = objectMapper.createArrayNode();
                            ArrayList<InputforMovies> legalmovies;
                            legalmovies = legal.checkLegalMovies(movies, curruser);
                            ObjectNode all = objectMapper.createObjectNode();
                            ArrayNode currentMoviesList = objectMapper.createArrayNode();
                            all.set("error", null);
                            ArrayNode watchedmovies = objectMapper.createArrayNode();
                            int err = 0;
                            if (legalmovies.size() != 0) {
                                for (InputforMovies legalmovie : legalmovies) {
                                    if (actions.get(i).getMovie() == null) {
                                        if (legalmovie.getName().equals(movieseedetails)) {
                                            ObjectNode specification;
                                            specification = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            currentMoviesList.add(specification);
                                        }
                                    } else {
                                        if (legalmovie.getName().
                                                equals(actions.get(i).getMovie())) {
                                            ObjectNode specification;
                                            specification = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            currentMoviesList.add(specification);
                                        }
                                    }
                                }
                                all.set("currentMoviesList", currentMoviesList);
                                ObjectNode currentUser = objectMapper.createObjectNode();
                                ObjectNode credentials;
                                credentials = print.printCredentialsForUser(curruser);
                                currentUser.set("credentials", credentials);
                                assert curruser != null;
                                currentUser.put("tokensCount", curruser.getToken());
                                currentUser.put("numFreePremiumMovies",
                                        curruser.getNumFreeMovies());
                                ArrayNode arrayNode1 = objectMapper.createArrayNode();
                                for (InputforMovies legalmovie : legalmovies) {
                                    int waswatched = 0;
                                    if (actions.get(i).getMovie() == null) {
                                        if (legalmovie.getName().equals(movieseedetails)) {
                                            for (InputforMovies inputforMovies : allwatched) {
                                                if (olduser != null) {
                                                    if (inputforMovies.getName().
                                                            equals(movieseedetails)
                                                            && (curruser.getNumlogins() > 1)) {
                                                        break;
                                                    }
                                                }
                                            }
                                            if (waswatched == 0) {
                                                ObjectNode spec;
                                                if (curruser.getNumlogins() == 1) {
                                                    watched.add(legalmovie);
                                                    curruser.putinwatchedmoviesmovies(legalmovie);
                                                }
                                                allwatched.add(legalmovie);
                                                spec = print.
                                                        printSpecificationsForMovie(legalmovie);
                                                watchedmovies.add(spec);
                                            } else {
                                                err = 1;
                                            }
                                        }
                                    } else {
                                        if (legalmovie.getName().
                                                equals(actions.get(i).getMovie())) {
                                            for (InputforMovies inputforMovies : allwatched) {
                                                if (inputforMovies.
                                                        getName().
                                                        equals(actions.get(i).getMovie())) {
                                                    waswatched = 1;
                                                    break;
                                                }
                                            }
                                            if (waswatched == 0) {
                                                ObjectNode spec;
                                                if (curruser.getNumlogins() == 1) {
                                                    watched.add(legalmovie);
                                                }
                                                allwatched.add(legalmovie);
                                                spec = print.
                                                        printSpecificationsForMovie(legalmovie);
                                                watchedmovies.add(spec);
                                            } else {
                                                err = 1;
                                            }
                                        }
                                    }
                                }
                                if (err == 1) {
                                    ObjectNode n = objectMapper.createObjectNode();
                                    error = "Error";
                                    ArrayNode key = objectMapper.createArrayNode();
                                    n.put("error", error);
                                    n.set("currentMoviesList", key);
                                    n.set("currentUser", null);
                                    output.add(n);
                                } else {
                                    ArrayNode liked1;
                                    liked1 = goingThroughLikedMovies.GoThroughLikedMovies(
                                            liked);
                                    ArrayNode wat;
                                    wat = goingThroughWatchedMovies.goThroughWatchedMovies(
                                            curruser.getPutinwatchedmovies());
                                    ArrayNode purch;
                                    purch = goingThroughPurchasedMovies.goThroughPurchasedMovies(
                                            curruser.getPutinpurchasedmovies());
                                    ArrayNode rate;
                                    rate = goingThroughRatedmovies.goThroughRatedMovies(
                                            curruser.getPutinratedmovies());
                                    currentUser.set("purchasedMovies", purch);
                                    currentUser.set("watchedMovies", wat);
                                    currentUser.set("likedMovies", liked1);
                                    currentUser.set("notifications", d);
                                    currentUser.set("ratedMovies", rate);
                                    all.set("currentUser", currentUser);
                                    if (moneyproblem == 1) {
                                        ObjectNode n = objectMapper.createObjectNode();
                                        error = "Error";
                                        ArrayNode key = objectMapper.createArrayNode();
                                        n.put("error", error);
                                        n.set("currentMoviesList", key);
                                        n.set("currentUser", null);
                                        output.add(n);
                                    } else {
                                        output.add(all);
                                    }
                                }
                            } else {
                                ObjectNode n = objectMapper.createObjectNode();
                                error = "Error";
                                ArrayNode key = objectMapper.createArrayNode();
                                n.put("error", error);
                                n.set("currentMoviesList", key);
                                n.set("currentUser", null);
                                output.add(n);
                            }
                        }
                    }
                }
                if (actions.get(i).getFeature().equals("like")) {
                    if (purchase == 0 && watch == 0) {
                        ObjectNode n = objectMapper.createObjectNode();
                        error = "Error";
                        ArrayNode key = objectMapper.createArrayNode();
                        n.put("error", error);
                        n.set("currentMoviesList", key);
                        n.set("currentUser", null);
                        output.add(n);
                    } else {
                        if (page.equals("see details")) {
                            ArrayNode e = objectMapper.createArrayNode();
                            ArrayList<InputforMovies> legalmovies;
                            legalmovies = legal.checkLegalMovies(movies, curruser);
                            if (legalmovies.size() != 0) {
                                ObjectNode all = objectMapper.createObjectNode();
                                ArrayNode currentMoviesList = objectMapper.createArrayNode();
                                all.set("error", null);
                                ArrayNode purchasedmovies = objectMapper.createArrayNode();
                                for (InputforMovies legalmovie : legalmovies) {
                                    if (actions.get(i).getMovie() == null) {
                                        if (legalmovie.getName().equals(movieseedetails)) {

                                            liked.add(legalmovie);
                                            numlikes++;
                                            legalmovie.setNumlikes(numlikes);
                                            curruser.setLikedmovies(legalmovies);
                                            ObjectNode specification;
                                            specification = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            currentMoviesList.add(specification);
                                        }
                                    } else {
                                        if (legalmovie.getName().
                                                equals(actions.get(i).getMovie())) {
                                            liked.add(legalmovie);
                                            numlikes++;
                                            legalmovie.setNumlikes(numlikes);
                                            ObjectNode specification;
                                            specification = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            currentMoviesList.add(specification);
                                        }
                                    }
                                }
                                all.set("currentMoviesList", currentMoviesList);
                                ObjectNode currentUser = objectMapper.createObjectNode();
                                ObjectNode credentials;
                                credentials = print.printCredentialsForUser(curruser);
                                currentUser.set("credentials", credentials);
                                assert curruser != null;
                                currentUser.put("tokensCount", curruser.getToken());
                                currentUser.put("numFreePremiumMovies",
                                        curruser.getNumFreeMovies());
                                ArrayNode arrayNode1 = objectMapper.createArrayNode();
                                for (InputforMovies legalmovie : legalmovies) {
                                    if (actions.get(i).getMovie() == null) {
                                        if (legalmovie.getName().equals(movieseedetails)) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            purchasedmovies.add(spec);
                                        }
                                    } else {
                                        if (legalmovie.getName().
                                                equals(actions.get(i).getMovie())) {
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(legalmovie);
                                            purchasedmovies.add(spec);
                                        }
                                    }
                                }
                                ArrayNode purch;
                                purch = goingThroughPurchasedMovies.goThroughPurchasedMovies(
                                        curruser.getPutinpurchasedmovies());
                                ArrayNode wat;
                                wat = goingThroughWatchedMovies.goThroughWatchedMovies(
                                        curruser.getPutinwatchedmovies());
                                ArrayNode liked1;
                                liked1 = goingThroughRatedmovies.goThroughRatedMovies(
                                        liked);
                                currentUser.set("purchasedMovies", purch);
                                currentUser.set("watchedMovies", wat);
                                currentUser.set("likedMovies", liked1);
                                currentUser.set("notifications", e);
                                currentUser.set("ratedMovies", arrayNode1);
                                all.set("currentUser", currentUser);
                                if (moneyproblem == 1) {
                                    ObjectNode n = objectMapper.createObjectNode();
                                    error = "Error";
                                    ArrayNode key = objectMapper.createArrayNode();
                                    n.put("error", error);
                                    n.set("currentMoviesList", key);
                                    n.set("currentUser", null);
                                    output.add(n);
                                } else {
                                    output.add(all);
                                }
                            } else {
                                ObjectNode n = objectMapper.createObjectNode();
                                error = "Error";
                                ArrayNode key = objectMapper.createArrayNode();
                                n.put("error", error);
                                n.set("currentMoviesList", key);
                                n.set("currentUser", null);
                                output.add(n);
                            }

                        }
                    }
                    purchase = 0;
                    watch = 0;
                    like = 0;
                }
                if (actions.get(i).getFeature().equals("rate")) { // breakpoint
                    if (purchase == 0 && watch == 0 && like == 0) {
                        ObjectNode n = objectMapper.createObjectNode();
                        error = "Error";
                        ArrayNode key = objectMapper.createArrayNode();
                        n.put("error", error);
                        n.set("currentMoviesList", key);
                        n.set("currentUser", null);
                        output.add(n);
                    } else {
                        if (page.equals("see details")) {
                            ArrayNode f = objectMapper.createArrayNode();
                            ArrayList<InputforMovies> legalmovies;
                            legalmovies = legal.checkLegalMovies(movies, curruser);
                            ObjectNode all = objectMapper.createObjectNode();
                            ArrayNode currentMoviesList = objectMapper.createArrayNode();
                            all.set("error", null);
                            ArrayNode ratedmovies = objectMapper.createArrayNode();
                            for (InputforMovies legalmovie : legalmovies) {
                                if (actions.get(i).getMovie() == null) {
                                    if (legalmovie.getName().equals(movieseedetails)) {
                                        double r = legalmovie.getRating();
                                        newrate = legalmovie.getRating();
                                        rating = actions.get(i).getRate();
                                        newrate += rating;
                                        numrate = legalmovie.getNumRatings();
                                        if (curruser.getNumlogins() == 1) {
                                            numrate++;
                                            oldrate = rating;
                                        } else {
                                            newrate = newrate - oldrate;
                                            newrate += r;
                                            avg = newrate / numrate;
                                        }
                                        avg = newrate / numrate;
                                        if (avg > limit) {
                                            avg = limit;
                                        }
                                        ObjectNode specification;
                                        legalmovie.setRating(avg);
                                        legalmovie.setNumRatings((int) numrate);
                                        specification = print.
                                                printSpecificationsForMovie(legalmovie);
                                        currentMoviesList.add(specification);
                                    }
                                } else {
                                    if (legalmovie.getName().
                                            equals(actions.get(i).getMovie())) {
                                        newrate = legalmovie.getRating();
                                        rating = actions.get(i).getRate();
                                        newrate = newrate * rating;
                                        newrate += rating;
                                        numrate++;
                                        avg = newrate / numrate;
                                        if (avg > limit) {
                                            avg = limit;
                                        }
                                        ObjectNode specification;
                                        legalmovie.setRating(avg);
                                        legalmovie.setNumRatings((int) numrate);
                                        specification = print.
                                                printSpecificationsForMovie(legalmovie);
                                        currentMoviesList.add(specification);
                                    }
                                }
                            }
                            all.set("currentMoviesList", currentMoviesList);
                            ObjectNode currentUser = objectMapper.createObjectNode();
                            ObjectNode credentials;
                            numrate = 0;
                            credentials = print.
                                    printCredentialsForUser(curruser);
                            currentUser.set("credentials", credentials);
                            assert curruser != null;
                            currentUser.put("tokensCount", curruser.getToken());
                            currentUser.put("numFreePremiumMovies",
                                    curruser.getNumFreeMovies());
                            int err = 0;
                            newrate = 0;
                            for (InputforMovies inputforMovies : legalmovies) {
                                int wasrated = 0;
                                if (actions.get(i).getMovie() == null) {
                                    if (inputforMovies.getName().
                                            equals(movieseedetails)) {
                                        for (InputforMovies value : allrated) {
                                            if (olduser != null) {
                                                if (value.getName().
                                                        equals(movieseedetails)
                                                        && (curruser.getNumlogins() > 1)) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (wasrated == 0) {
                                            numrate++;
                                            rating = actions.get(i).getRate();
                                            newrate += rating;
                                            avg = newrate / numrate;
                                            if (curruser.getNumlogins() == 1) {
                                                rated.add(inputforMovies);
                                                curruser.putinratedmovies(inputforMovies);
                                            }

                                            allrated.add(inputforMovies);
                                            ObjectNode spec;
                                            spec = print.
                                                    printSpecificationsForMovie(inputforMovies);
                                            ratedmovies.add(spec);
                                        } else {
                                            err = 1;
                                        }
                                    }
                                } else {
                                    if (inputforMovies.getName().
                                            equals(actions.get(i).getMovie())) {
                                        for (InputforMovies value : allrated) {
                                            if (value.getName().
                                                    equals(actions.get(i).getMovie())) {
                                                wasrated = 1;
                                                break;
                                            }
                                        }
                                        if (wasrated == 0) {
                                            numrate++;
                                            rating = actions.get(i).getRate();
                                            newrate += rating;
                                            avg = newrate / numrate;
                                            rated.add(inputforMovies);
                                            allrated.add(inputforMovies);
                                            ObjectNode spec;
                                            inputforMovies.setRating((int) avg);
                                            spec = print.
                                                    printSpecificationsForMovie(inputforMovies);
                                            ratedmovies.add(spec);
                                        } else {
                                            err = 1;
                                        }
                                    }
                                }
                            }
                            if (err == 1) {
                                ObjectNode n = objectMapper.createObjectNode();
                                error = "Error";
                                ArrayNode key = objectMapper.createArrayNode();
                                n.put("error", error);
                                n.set("currentMoviesList", key);
                                n.set("currentUser", null);
                                output.add(n);
                            } else {
                                ArrayNode liked1;
                                liked1 = goingThroughLikedMovies.GoThroughLikedMovies(
                                        liked);
                                ArrayNode wat;
                                wat = goingThroughWatchedMovies.goThroughWatchedMovies(
                                        curruser.getPutinwatchedmovies());
                                ArrayNode purch;
                                purch = goingThroughPurchasedMovies.goThroughPurchasedMovies(
                                        curruser.getPutinpurchasedmovies());
                                ArrayNode rate;
                                rate = goingThroughRatedmovies.goThroughRatedMovies(
                                        curruser.getPutinratedmovies());
                                currentUser.set("purchasedMovies", purch);
                                currentUser.set("watchedMovies", wat);
                                currentUser.set("likedMovies", liked1);
                                currentUser.set("notifications", f);
                                currentUser.set("ratedMovies", rate);
                                all.set("currentUser", currentUser);
                                output.add(all);
                            }
                            numrate = 0;
                        }
                    }
                }
            }
            previouspage = currentpage;
        }
        if (curruser != null
                && curruser.getCredentials().getAccountType().equals("premium")
                && i == actions.size()) {
            ObjectNode node = objectMapper.createObjectNode();
            ObjectNode currentUser = objectMapper.createObjectNode();
            ObjectNode credentials;
            error = null;
            node.put("error", error);
            node.set("currentMoviesList", null);
            credentials = print.printCredentialsForUser(curruser);
            currentUser.set("credentials", credentials);
            currentUser.put("tokensCount", curruser.getToken());
            currentUser.put("numFreePremiumMovies",
                    curruser.getNumFreeMovies());
            ArrayNode wat;
            wat = goingThroughWatchedMovies.goThroughWatchedMovies(
                    curruser.getPutinwatchedmovies());
            ArrayNode purch;
            purch = goingThroughPurchasedMovies.goThroughPurchasedMovies(
                    curruser.getPutinpurchasedmovies());
            ArrayNode rate;
            rate = goingThroughRatedmovies.goThroughRatedMovies(
                    curruser.getPutinratedmovies());
            currentUser.set("purchasedMovies", purch);
            currentUser.set("watchedMovies", wat);
            currentUser.set("likedMovies", wat);
            if ((database.size() == 0) || genresforuser.size() == 0) {
                ObjectNode note = objectMapper.createObjectNode();
                note.put("message", "Recommendation");
                note.put("movieName", "No recommendation");
                notifications.add(note);
            } else if (database.size() != 0) {
                ObjectNode note = objectMapper.createObjectNode();
                ObjectNode note1 = objectMapper.createObjectNode();
                ArrayNode wrap = objectMapper.createArrayNode();
                note.put("message", "ADD");
                ArrayList<String> databasenames = new ArrayList<>();
                for (int u = 0; u < database.size(); u++) {
                    databasenames.add(database.get(u).getName());
                    note.put("movieName", databasenames.get(u));
                }
                note1.put("message", "Recommendation");
                note1.put("movieName", movieseedetails);
                notifications.add(note);
                notifications.add(note1);
            }
            currentUser.set("notifications", notifications);
            currentUser.set("ratedMovies", rate);
            node.set("currentUser", currentUser);
            output.add(node);
        }
        objectWriter.writeValue(new File(args[1]), output);
    }
}