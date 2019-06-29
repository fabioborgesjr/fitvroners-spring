package workouts;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;


import java.util.List;

@Data
@Entity
public class User {

  private @Id String user_id;
  private String name;
  private String password;

  @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
  @JsonManagedReference
  private List<Workout> workouts;

  public User() {}

  /**
   * @return the id
   */
  public String getId() {
    return user_id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @return the workouts
   */
  public List<Workout> getWorkouts() {
    return workouts;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.user_id = id;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @param workouts the workouts to set
   */
  public void setWorkouts(List<Workout> workouts) {
    this.workouts = workouts;
  }
}
