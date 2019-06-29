package workouts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

  @Query("select new workouts.UserList(id, name) from User")
  List<UserList> findAllLazy();
}
