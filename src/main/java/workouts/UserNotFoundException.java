package workouts;

class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  UserNotFoundException(String id) {
    super("Could not find user " + id);
  }
}
