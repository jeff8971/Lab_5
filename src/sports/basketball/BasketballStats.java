package sports.basketball;

import java.util.Objects;

/**
 * BasketballStats class.
 */
public class BasketballStats {
  private double pointsPerGame;
  private double reboundsPerGame;
  private double assistsPerGame;

  /**
   * Constructor of BasketballStats.
   *
   * @param pointsPerGame   pointsPerGame.
   * @param reboundsPerGame reboundsPerGame.
   * @param assistsPerGame  assistsPerGame.
   */
  public BasketballStats(double pointsPerGame, double reboundsPerGame,
                         double assistsPerGame) {
    this.pointsPerGame = pointsPerGame;
    this.reboundsPerGame = reboundsPerGame;
    this.assistsPerGame = assistsPerGame;
  }

  /**
   * Getter of pointsPerGame.
   *
   * @return pointsPerGame
   */
  public double getPointsPerGame() {
    return this.pointsPerGame;
  }

  /**
   * Getter of reboundsPerGame.
   *
   * @return reboundsPerGame.
   */
  public double getReboundsPerGame() {
    return this.reboundsPerGame;
  }

  /**
   * Getter of assistsPerGame.
   *
   * @return assistsPerGame.
   */
  public double getAssistsPerGame() {
    return this.assistsPerGame;
  }

  /**
   * Override equals method to compare BasketballStats.
   *
   * @param other BasketballStats.
   * @return true if the stats are the same, otherwise false.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (this.getClass() != other.getClass()) return false;
    BasketballStats o = (BasketballStats) other;
    return (this.assistsPerGame == o.assistsPerGame
            && this.reboundsPerGame == o.reboundsPerGame
            && this.pointsPerGame == o.pointsPerGame);
  }

  /**
   * Hashcode method.
   *
   * @return object
   */
  public int hashCode() {
    return Objects.hash(this.assistsPerGame, this.reboundsPerGame, this.pointsPerGame);
  }

  /**
   * ToString method print out the BasketballStat.
   *
   * @return String, printout the status.
   */
  @Override
  public String toString() {
    return String.format("Points: %.2f. Rebounds: %.2f. Assists: %.2f", this.pointsPerGame,
            this.reboundsPerGame, this.assistsPerGame);
  }
}