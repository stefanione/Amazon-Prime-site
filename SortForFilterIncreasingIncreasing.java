package fileio;

import java.util.ArrayList;
import java.util.Collections;

public class SortForFilterIncreasingIncreasing implements
        SortingForFilterIncreasingIncreasing, InterfaceForfilterIncreasingIncreasing {

    /** this method sorts the array correspondly */
    @Override
    public void sortIncreasingIncreasing(
            final ArrayList<InputforMovies> remainingmovies) {
        int sorted = 0;
        while (sorted == 0) {
            sorted = 1;
            for (int u = 0; u < remainingmovies.size() - 1; u++) {
                if (remainingmovies.get(u).getDuration()
                        > remainingmovies.get(u + 1).getDuration()) {
                    sorted = 0;
                    Collections.swap(remainingmovies, u, u + 1);

                } else if (remainingmovies.get(u).getDuration()
                        == remainingmovies.get(u + 1).getDuration()) {
                    if (remainingmovies.get(u).getRating()
                            > remainingmovies.get(u + 1).getRating()) {
                        sorted = 0;
                        Collections.swap(remainingmovies, u + 1, u);
                    }
                }
            }
        }
    }

    /** this method prints that the arraylist has been sorted the correspondent way */
    @Override
    public void sortIncreasingIncreasing() {
        System.out.println("sortedIncreasingIncreasing");
    }
}
