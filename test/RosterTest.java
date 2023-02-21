import org.junit.Test;
import sports.Roster;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RosterTest {

  @Test
  public void testAddPlayer() {
    Roster<BasketballPlayer, String> roster = new Roster<>();
    BasketballPlayer player = new BasketballPlayer("Luke", 25,
      5.8, new BasketballStats(50.0,
      5.0, 3.0));
    roster.addPlayer(player);
    assertEquals(1, roster.getPlayers().size());
    assertTrue(roster.getPlayers().contains(player));
  }

  @Test
  public void testSortByStats() {
    Roster<BasketballPlayer, String> roster = new Roster<>();
    BasketballPlayer player1 = new BasketballPlayer("Luke", 25, 5.8,
      new BasketballStats(50.0, 5.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("Dicky", 22, 6.0,
      new BasketballStats(10, 4.0, 2.0));
    BasketballPlayer player3 = new BasketballPlayer("Paul", 37, 6.2,
      new BasketballStats(17.0, 4.0, 1.0));
    roster.addPlayer(player1);
    roster.addPlayer(player2);
    roster.addPlayer(player3);
    roster.sortByStats();
    List<BasketballPlayer> sortedPlayers = roster.getPlayers();
    assertEquals(sortedPlayers.get(0), player2);
    assertEquals(sortedPlayers.get(1), player3);
    assertEquals(sortedPlayers.get(2), player1);
  }

  @Test
  public void testFold() {
    Roster<BasketballPlayer, Double> roster = new Roster<>();
    BasketballPlayer player1 = new BasketballPlayer("Luke", 25, 5.8,
      new BasketballStats(50.0, 5.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("Dicky", 22, 6.0,
      new BasketballStats(10, 4.0, 2.0));
    BasketballPlayer player3 = new BasketballPlayer("Paul", 37, 6.2,
      new BasketballStats(17.0, 4.0, 1.0));
    roster.addPlayer(player1);
    roster.addPlayer(player2);
    roster.addPlayer(player3);
    Double totalPoints = roster.fold((player, acc) -> acc + player.getStats().getPointsPerGame(),
      0.0);
    assertEquals(77.0, totalPoints, 0.01);
  }
}