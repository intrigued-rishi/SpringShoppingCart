package SpringDB.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import SpringDB.schema.Users;

public interface UserCrud extends CrudRepository<Users,Integer>{
	
	
	@Query(value="SELECT * FROM users WHERE password='123'",nativeQuery=true)
	List<Users> findByPawd(String pwd);
}
