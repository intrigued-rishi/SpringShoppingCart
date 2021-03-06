package SpringDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import SpringDB.model.UserCrud;
import SpringDB.schema.Users;

@Controller
public class HomeController {
	
	@Autowired
	UserCrud u;
	
	@RequestMapping({"/home","/"})
	public String display() { 
		return "Home.jsp";
	}
	@RequestMapping("accessdenied")
	public String unauthenticated() { 
		return "Unauthenticated.jsp";
	}
	
}
