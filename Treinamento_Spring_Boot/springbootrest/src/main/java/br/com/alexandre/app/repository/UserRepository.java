package br.com.alexandre.app.repository;

import br.com.alexandre.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameIgnoreCaseContaining(String username);

    User findByUsername(String username);
}
