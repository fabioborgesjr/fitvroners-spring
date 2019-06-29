package workouts;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class WorkoutList{

  private @Id String id;
  private String title;
  private int duration;
  private String treino;
  
  public WorkoutList(String id, String title, int duration, String treino) {
    this.title = title;
    this.duration = duration;
    this.id = id;
    this.treino = treino;
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
}
