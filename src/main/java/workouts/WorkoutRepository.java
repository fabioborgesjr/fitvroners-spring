package workouts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutRepository extends JpaRepository<Workout, String> {
  
  @Query("select new workouts.WorkoutList(id, title, duration, treino) from Workout")
  List<WorkoutList> findAllLazy();
}
