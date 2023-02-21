package sports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import sports.basketball.BasketballPlayerComparator;

/**
 * A class that represents a roster of players of a specific sport.
 *
 * @param <T> The type of player that the roster contains.
 * @param <R> The type of result that is produced when folding the players' stats together.
 */
public class Roster<T, R> {
  private List<T> players;

  /**
   * Default constructor of Roster.
   */
  public Roster() {
    this.players = new ArrayList<>();
  }

  /**
   * Alternative constructor of Roster.
   *
   * @param players A series of players added to the Roster list.
   */
  public Roster(List<T> players) {
    this.players = players;
  }

  /**
   * Getter of the players.
   *
   * @return a collections of players.
   */
  public List<T> getPlayers() {
    return Collections.unmodifiableList(this.players);
  }

  /**
   * Method add players to the list.
   *
   * @param player the player need to be added to the list.
   */
  public void addPlayer(T player) {
    // add the new player to our list of players
    this.players.add(player);
  }

  /**
   * By using comparator, sort the list of the players.
   */
  public void sortByStats() {
    this.players.sort((Comparator<? super T>) new BasketballPlayerComparator());
    // use our comparator to sort
    // the previous generic is using a wildcard ?
    // basically stating the type can be any T or a super type of T
    // this is Turkish Delights from Java "deep magic"
    // - don't worry if you don't understand it - you can
    // use this method safely without editing it or knowing how it works under the hood. Asland.
  }

  /**
   * Combines the stats of all the players in the roster into a single result using a fold function.
   *
   * @param combiner  The function that combines the stats of two players into a single result.
   * @param seedValue The initial value of the result.
   * @return The result of combining the stats of all the players in the roster.
   */
  // Bi-Function to combine individual stats the dream team has, into one value
  public <R> R fold(BiFunction<T, R, R> combiner, R seedValue) {

    R total = seedValue;
    for (T player : this.players) {
      total = combiner.apply(player, total);
    }
    return total;
    // given a bi-function and a seed-value (initial value),
    // combine all the values from each player into a single value.
    // The value we're combining will be dependent on the bi-function passed in as a parameter
    // T and R are "formal" parameters that may be bound to 2 different concrete types
  }

}