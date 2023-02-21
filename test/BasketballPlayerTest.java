import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;


import org.junit.Before;
import org.junit.Test;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;


/**
 * BasketballPlayer test.
 */
public class BasketballPlayerTest {

  private BasketballPlayer YaoMing;
  private BasketballPlayer MichealJordan;

  private BasketballStats YaoStat;
  private BasketballStats MichealStat;

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
   * Test getters of Basketball players.
   */
  @Test
  public void testGetters() {
    assertEquals("Yao Ming", YaoMing.getName());
    assertEquals("Micheal Jordan", MichealJordan.getName());

    assertEquals(30, YaoMing.getAge());
    assertEquals(42, MichealJordan.getAge());

    assertEquals(7.6, YaoMing.getHeight(), 0.01);
    assertEquals(6.6, MichealJordan.getHeight(), 0.01);
  }

  /**
   * Test getters for BasketballStat.
   */
  @Test
  public void testGetStats() {
    assertEquals(40.8, MichealStat.getPointsPerGame(), 0.01);
    assertEquals(40.8, MichealJordan.getStats().getPointsPerGame(), 0.01);

    assertEquals(6.8, YaoStat.getReboundsPerGame(), 0.01);
    assertEquals(4.2, YaoMing.getStats().getAssistsPerGame(), 0.01);
  }

  /**
   * Test copy constructor.
   */
  @Test
  public void testCopyConstructor() {
    BasketballPlayer YaoYao = new BasketballPlayer(YaoMing);
    assertNotSame(YaoMing, YaoYao); // test copied constructor.
    assertEquals(YaoMing.getName(), YaoYao.getName());
    assertEquals(YaoMing.getAge(), YaoYao.getAge());
    assertEquals(YaoMing.getHeight(), YaoYao.getHeight(), 0.01);
    assertEquals(YaoMing.getStats().getPointsPerGame(),
            YaoYao.getStats().getPointsPerGame(), 0.01);
    assertEquals(YaoMing.getStats().getReboundsPerGame(),
            YaoYao.getStats().getReboundsPerGame(), 0.01);
    assertEquals(YaoMing.getStats().getAssistsPerGame(),
            YaoYao.getStats().getAssistsPerGame(), 0.01);
  }

  /**
   * Test for equal method.
   */
  @Test
  public void testEquals() {
    BasketballPlayer YaoYao = new BasketballPlayer("Yao Ming", 30, 7.6,
            new BasketballStats(34.4, 6.8, 4.2));
    BasketballPlayer YaoYaoYao = new BasketballPlayer("YaoYaoYao", 25, 6.0,
            new BasketballStats(40.0, 4.0, 2.0));
    assertEquals(YaoMing, YaoYao);
    assertNotEquals(YaoMing, YaoYaoYao);
  }

  /**
   * Test HashCode method.
   */
  @Test
  public void testHashCode() {
	  BasketballPlayer YaoYao = new BasketballPlayer("Yao Ming", 30, 7.6,
					  new BasketballStats(34.4, 6.8, 4.2));
	  BasketballPlayer YaoYaoYao = new BasketballPlayer("YaoYaoYao", 25, 6.0,
					  new BasketballStats(40.0, 4.0, 2.0));
    assertEquals(YaoMing.hashCode(), YaoYao.hashCode());
    assertNotEquals(YaoYaoYao.hashCode(), YaoMing.hashCode());
  }
}