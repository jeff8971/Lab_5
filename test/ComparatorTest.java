import org.junit.Test;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballPlayerComparator;
import sports.basketball.BasketballStats;

import static org.junit.Assert.assertTrue;

public class ComparatorTest {

  @Test
  public void testCompare() {
    BasketballPlayerComparator comparator = new BasketballPlayerComparator();
    BasketballPlayer player1 = new BasketballPlayer("Luke", 25, 5.8,
      new BasketballStats(50.0, 5.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("Dicky", 22, 6.0,
      new BasketballStats(10, 4.0, 2.0));
    BasketballPlayer player3 = new BasketballPlayer("Paul", 37, 6.2,
      new BasketballStats(17.0, 4.0, 1.0));
    BasketballPlayer player4 = new BasketballPlayer("Kobe", 40, 6.5,
      new BasketballStats(17.0, 4.0, 1.0));
    assertTrue(comparator.compare(player1, player2) > 0);
    assertTrue(comparator.compare(player2, player1) < 0);
    assertTrue(comparator.compare(player3, player4) == 0);
    assertTrue(comparator.compare(player1, player3) > 0);
    assertTrue(comparator.compare(player2, player3) < 0);
  }

}