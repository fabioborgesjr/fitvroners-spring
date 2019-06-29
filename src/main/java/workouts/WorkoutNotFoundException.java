package workouts;

class WorkoutNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  WorkoutNotFoundException(String id) {
    super("Could not find workout " + id);
  }
}
