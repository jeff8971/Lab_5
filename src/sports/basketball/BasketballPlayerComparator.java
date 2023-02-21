package sports.basketball;

import java.util.Comparator;

/**
 * Class BasketballPlayerComparator to compare the data of BasketballPlayer.
 */
public class BasketballPlayerComparator implements Comparator<BasketballPlayer> {

  /**
   * Compare two basketballPlayer's Stats.
   *
   * @param player1 the first object to be compared.
   * @param player2 the second object to be compared.
   * @return 0, equal; -1, player2 > player1; 1, player1>player2.
   */
  @Override
  public int compare(BasketballPlayer player1, BasketballPlayer player2) {
    BasketballStats stats1;
    BasketballStats stats2;
    stats1 = player1.getStats();
    stats2 = player2.getStats();
    if (Double.compare(stats1.getPointsPerGame(), stats2.getPointsPerGame()) == 0)
      return 0;
    else if (stats1.getPointsPerGame() > stats2.getPointsPerGame())
      return 1;
    else
      return -1;
  }
}