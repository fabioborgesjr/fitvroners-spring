package workouts;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Data
@Entity
public class Workout {

  private @Id String id;
  private String title;
  private int duration;
  private double calories;
  private String treino;
  
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User user;

  public Workout() {}

  /**
   * @return the calories
   */
  public double getCalories() {
    return calories;
  }

  /**
   * @return the duration
   */
  public int getDuration() {
    return duration;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * @return the treino
   */
  public String getTreino() {
    return treino;
  }

  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * @param calories the calories to set
   */
  public void setCalories(double calories) {
    this.calories = calories;
  }

  /**
   * @param duration the duration to set
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @param treino the treino to set
   */
  public void setTreino(String treino) {
    this.treino = treino;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }
}
