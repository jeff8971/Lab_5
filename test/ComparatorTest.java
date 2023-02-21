import org.junit.Before;
import org.junit.Test;

import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballPlayerComparator;
import sports.basketball.BasketballStats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Comparator Test.
 */
public class ComparatorTest {

  public BasketballPlayer YaoMing;
  public BasketballPlayer MichealJordan;

  public BasketballStats YaoStat;
  public BasketballStats MichealStat;

  /**
   * Set up two basketball players to test.
   */
  @Before
  public void setup() {
    MichealStat = new BasketballStats(40.8, 5.2, 5.6);
    YaoStat = new BasketballStats(34.4, 6.8, 4.2);

    YaoMing = new BasketballPlayer("Yao Ming", 30, 7.6,
            YaoStat);
    MichealJordan = new BasketballPlayer("Micheal Jordan", 42, 6.6,
            MichealStat);
  }

  /**
   * Test Compare method.
   */
  @Test
  public void testCompare() {
    BasketballPlayerComparator comparator = new BasketballPlayerComparator();

    BasketballPlayer YaoYao = new BasketballPlayer("Yao Ming", 30, 7.6,
            new BasketballStats(34.4, 6.8, 4.2));
    BasketballPlayer YaoYaoYao = new BasketballPlayer("YaoYaoYao", 25, 6.0,
            new BasketballStats(40.0, 4.0, 2.0));

    assertTrue(comparator.compare(YaoMing, MichealJordan) < 0);
    assertTrue(comparator.compare(YaoMing, MichealJordan) < 0);
    assertEquals(0, comparator.compare(YaoMing, YaoYao));
    assertTrue(comparator.compare(YaoYaoYao, YaoYao) > 0);
    assertTrue(comparator.compare(YaoYaoYao, YaoMing) > 0);
    assertTrue(comparator.compare(YaoMing, MichealJordan) < 0);
  }

}