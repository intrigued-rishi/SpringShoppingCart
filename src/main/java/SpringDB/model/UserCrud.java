package SpringDB.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import SpringDB.schema.Users;


public interface UserCrud extends JpaRepository<Users,Integer>{
	Optional<Users> findByEmail(String email);
}
