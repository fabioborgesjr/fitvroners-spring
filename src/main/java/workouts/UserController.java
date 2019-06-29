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
public class UserController{
  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/users")
  List<UserList> all() {
    return repository.findAllLazy();
  }

  @PostMapping("/users")
  User addUser(@RequestBody User u) {
    return repository.save(u);
  }

  @GetMapping("/users/{id}")
  User getUserById(@PathVariable String id) {
    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/users/{id}")
  User addOrUpdateUserById(@RequestBody User u, @PathVariable String id) {

    return repository.findById(id)
      .map(user -> {
        user.setName(u.getName());
        user.setPassword(u.getPassword());
        
        return repository.save(user);
      })
      .orElseGet(() -> {
        u.setId(id);
        return repository.save(u);
      });
  }

  @DeleteMapping("/users/{id}")
  void removeUserById(@PathVariable String id) {
    repository.deleteById(id);
  }
}
