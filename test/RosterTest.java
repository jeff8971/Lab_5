import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import sports.Roster;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;

import java.util.List;


/**
 * RosterTest class.
 */
public class RosterTest {
  public BasketballPlayer YaoMing;
  public BasketballPlayer MichealJordan;
  public BasketballPlayer YaoYao;
  public BasketballPlayer YaoYaoYao;

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

    YaoYao = new BasketballPlayer("Yao Ming", 30, 7.6,
            new BasketballStats(34.4, 6.8, 4.2));
    YaoYaoYao = new BasketballPlayer("YaoYaoYao", 25, 6.0,
            new BasketballStats(40.0, 4.0, 2.0));


    Roster<BasketballPlayer, String> roster = new Roster<>();
  }

  /**
   * Test Method AddPlayer.
   */
  @Test
  public void testAddPlayer() {
    Roster<BasketballPlayer, String> roster = new Roster<>();


    roster.addPlayer(YaoMing);
    roster.addPlayer(MichealJordan);
    roster.addPlayer(YaoYaoYao);
    roster.addPlayer(YaoYao);

    assertEquals(4, roster.getPlayers().size());
    assertTrue(roster.getPlayers().contains(YaoYao));
    assertTrue(roster.getPlayers().contains(MichealJordan));
  }

  /**
   * Test Sort players by Stats.
   */
  @Test
  public void testSortByStats() {
    Roster<BasketballPlayer, String> roster = new Roster<>();

    roster.addPlayer(YaoMing);
    roster.addPlayer(MichealJordan);
    roster.addPlayer(YaoYaoYao);
    roster.addPlayer(YaoYao);
    roster.sortByStats();
    List<BasketballPlayer> sortedPlayers = roster.getPlayers();
    assertEquals(sortedPlayers.get(0), YaoMing);
    assertEquals(sortedPlayers.get(1), YaoYao);

    assertEquals(sortedPlayers.get(3), MichealJordan);
  }

  /**
   * Test fold method.
   */
  @Test
  public void testFold() {
    Roster<BasketballPlayer, Double> roster = new Roster<>();

    roster.addPlayer(YaoMing);
    roster.addPlayer(YaoMing);
    roster.addPlayer(MichealJordan);
    Double totalPoints = roster.fold((player, acc) -> acc + player.getStats().getPointsPerGame(),
        0.0);
    assertEquals(109.6, totalPoints, 0.01);
  }
}