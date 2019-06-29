package workouts;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController{
  private final WorkoutRepository repository;

  WorkoutController(WorkoutRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/workouts")
  List<WorkoutList> all() {
    return repository.findAllLazy();
  }

  @PostMapping("/workouts")
  Workout addWorkout(@RequestBody Workout w) {
    return repository.save(w);
  }

  @GetMapping("/workouts/{id}")
  Workout getWorkoutById(@PathVariable String id) {
    return repository.findById(id)
      .orElseThrow(() -> new WorkoutNotFoundException(id));
  }

  @PutMapping("/workouts/{id}")
  Workout addOrUpdateWorkoutById(@RequestBody Workout w, @PathVariable String id) {

    return repository.findById(id)
      .map(workout -> {
        workout.setTitle(w.getTitle());
        workout.setDuration(w.getDuration());
        workout.setCalories(w.getCalories());
        workout.setTitle(w.getTreino());
        return repository.save(workout);
      })
      .orElseGet(() -> {
        w.setId(id);
        return repository.save(w);
      });
  }

  @DeleteMapping("/workouts/{id}")
  void removeWorkoutById(@PathVariable String id) {
    repository.deleteById(id);
  }
}
