package workouts;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserList{

  private @Id String id;
  private String name;

  public UserList(String id, String name) {
    this.name = name;
    this.id = id;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
}
