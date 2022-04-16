package SpringDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringDB.model.UserCrud;
import SpringDB.schema.Users;

@Controller
public class HomeController {
	
	@Autowired
	UserCrud u;
	
	@RequestMapping("home")
	public String display() { 
		for(Users u:u.findAll()) {
			System.out.println(u.getEmail());
		}
		for(Users u:u.findByPawd("123")) {
			System.out.println(u.getEmail());
		}
		return "yo";
	}
}
