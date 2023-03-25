package net.codejava.usuario;

import net.codejava.usuario.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryImpl extends JpaRepository<User, Long> {

}
