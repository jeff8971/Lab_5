package sports.basketball;

import sports.IPlayer;

import java.util.Objects;

/**
 * BasketballPlayer class.
 */
public class BasketballPlayer implements IPlayer<BasketballStats> {
  private String name;
  private int age;
  private double height;
  private BasketballStats stats;

  /**
   * BasketballPlayer constructor.
   *
   * @param name player's name.
   * @param age player's age.
   * @param height player's height.
   * @param stats player's stat. From class BasketballStats.
   */
  public BasketballPlayer(String name, int age, double height, BasketballStats stats) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.stats = stats;
  }

  /**
   * BasketballPlayer 2nd constructor. Compare others.
   *
   * @param other Other BasketballPlayer for comparing.
   */
  public BasketballPlayer(BasketballPlayer other) {
    this.name = other.name;
    this.age = other.age;
    this.height = other.height;
    this.stats = new BasketballStats(
      other.stats.getPointsPerGame(),
      other.stats.getReboundsPerGame(),
      other.stats.getAssistsPerGame());
  }

  /**
   * Getter of the names.
   *
   * @return names.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Getter of the age.
   *
   * @return age.
   */
  @Override
  public int getAge() {
    return this.age;
  }

  /**
   * Getter of the height.
   *
   * @return height.
   */
  @Override
  public double getHeight() {
    return this.height;
  }

  /**
   * Getter of the BasketballStats.
   *
   * @return stats.
   */
  @Override
  public BasketballStats getStats() {
    return this.stats;
  }

  /**
   * ToString BasketballPlayer info.
   *
   * @return String of basketballPlayer info.
   */
  @Override
  public String toString() {
    return String.format("Name: %s. Age: %d. Height: %.2f. Stats: %s",
            this.name, this.age, this.height, this.stats.toString());
  }

  /**
   * Compare two basketballPlayer's data.
   *
   * @param other basketballPlayer
   * @return true: equal to each other, otherwise false.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (this.getClass() != other.getClass()) return false;
    BasketballPlayer o = (BasketballPlayer) other;
    return Double.compare(o.height, height) == 0 && this.age == o.age
            && this.name.equals(o.name);
  }

  /**
   * Hashcode Method of BasketballPlayer's info.
   *
   * @return add BasketballPlayer's info to hashmap.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age, this.height);
  }

}
