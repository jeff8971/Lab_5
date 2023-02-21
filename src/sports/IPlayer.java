package sports;

import sports.basketball.BasketballStats;

/**
 * Interface of BasketballPlayer.
 */
public interface IPlayer<T> {

  /**
   * Getter of names.
   *
   * @return name.
   */
  String getName();

  /**
   * Getter of ages.
   *
   * @return ages.
   */
  int getAge();

  /**
   * Getter of height.
   *
   * @return height.
   */
  double getHeight();

  /**
   * Getter of the BasketballStats of BasketballPlayers.
   *
   * @return the BasketballStats.
   */
  <T> BasketballStats getStats(); // generic method returns status type T

}