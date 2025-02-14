# Amazon Prime Site
Amazon Prime Site

321CD - Ionescu Stefan

								README AMAZON PRIME SITE


Auxiliary Classes Description:
Print Class:
This class contains two methods. One of the methods prints the credentials of the current user (name, country, account type, password, and account balance), while the other method prints the movie characteristics (release year, title, duration, genres, actors, countries where the movie is banned, rating, number of reviews, and number of ratings).

Legal Class:
This class contains a method that checks the legality of movies based on the current user's country. It works by taking the list of countries where the movie is banned and verifying if any of those countries match the user’s country.

Classes for Navigating Lists of Movies:

 - GoingThroughLikedMovies, GoingThroughPurchasedMovies, GoingThroughWatchedMovies, GoingThroughRatedMovies:
   Each of these classes follows the same principle: they navigate through an ArrayList passed as a parameter to the method. The class names were chosen to help organize the movies by category—liked, 
   purchased, watched, and rated. The methods inside these classes include a Print object (explained above), which prints the movie specifications and returns an ObjectNode.

Sorting Classes:

 - SortForFilterIncreasingIncreasing, SortingForFilterDecreasingDecreasing, SortForFilterIncreasingDecreasing, SortForFilterDecreasingIncreasing:
   Each of these classes contains two methods: one prints how the ArrayList was sorted based on Duration and Rating, and the other uses Bubble Sort to sort the ArrayList according to Rating and Duration.
   It’s important to note that these two methods employ two design patterns: Command and Strategy. The method that prints how the ArrayList was sorted follows the Command pattern, while the method that 
   actually sorts the ArrayList adheres to the Strategy pattern.
   For these two design patterns, I created four interfaces for each:
 - For the Strategy pattern, the interfaces are: SortForFilterDecreasingDecreasing, SortingForFilterDecreasingIncreasing, SortingForFilterIncreasingDecreasing, SortingForFilterIncreasingIncreasing, each 
   with a method header that accepts an ArrayList as input and returns void.
 - For the Command pattern, I created four additional interfaces: InterfaceForfilterDecreasingDecreasing, InterfaceForfilterDecreasingIncreasing, InterfaceForfilterIncreasingDecreasing, 
   InterfaceForfilterIncreasingIncreasing, each with a method header, but without input parameters and returning void.
These sorting classes are invoked for the filter action and are called based on the sorting case provided by the input. Additionally, the Singleton design pattern is used for the current user in the Inputforusers class, where the getInstance method implements the Singleton pattern.

Input Classes and Filters:
The input classes follow the specifications provided for the project, but additional methods were added to the Inputforusers class for this stage. Specifically, for each user, I included a method to store movies in separate ArrayLists for purchased, watched, liked, and rated movies. Additionally, the numlogins variable tracks the number of times a user logs in.

Main Class:
In the login and register actions, the process is similar: for login, the username and password are checked against the existing users, and for registration, the new user is added if they don't already exist. For the filter command, the legality of movies is checked based on the user's country before sorting them as requested.
For the buytokens command, the current user's balance is decreased to purchase tokens, and for buypremiumaccount, tokens are deducted to purchase a premium account. These actions modify values and account type, but no output is displayed.
In contrast, during the login and register actions, all of the user’s movies and credentials are displayed.
For commands like purchase, rate, watch, like, I display the user’s credentials and movies, considering the order of these actions: purchase should be first, followed by watch, like, and rate.

 - For purchase, all purchased movies are displayed, including newly purchased ones.
 - For watch, the user’s purchased and watched movies are displayed, ensuring that a movie is not purchased more than once.
 - For rate, all purchased, watched, and rated movies are shown, along with the user’s credentials.
 - Similarly, for like, all movies from the other categories are displayed.
   For the see details action, the movie given in the input is shown in the CurrentMoviesList section. If no movie is provided, the movie name is stored in a String and used for the see details command.
   The back action retains the previous page and displays its contents. If the user is not on the correct page, an error is shown using a fail variable set to 1.
   In the database, the movie is added or removed based on the input, depending on whether it is a movie to be added or deleted.
   For the subscribe action, the genre to subscribe to is obtained from the input and added to the current user’s list of subscribed genres.
   In the notifications action, if a movie is present in the database, its name is added to the recommendation with the message "ADD"; otherwise, the message is "No Recommendation." Notifications are 
   displayed at the end of the command sequence, but only if the current user's account is premium.
Note: In some classes, warnings were left in place to avoid breaking the checkstyle or because certain variables were necessary for input handling. I was advised to leave them as they were.
