package pl.jarofitrainer.jarofit_trainer_app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.jarofitrainer.jarofit_trainer_app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
