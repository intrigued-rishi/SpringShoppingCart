package SpringDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import SpringDB.model.UserCrud;
import SpringDB.schema.History;
import SpringDB.schema.Users;

@Service
public class Order {
	
	public void set(Users u) {
		History h=null;
		if(u.getH()==null) {
			h=new History();
			u.setH(h);
			h.setU(u);
		}
	}
	public Users seasonal(Users u) {
		set(u);
		History h=u.getH();
		h.incS();
		u.setH(h);
		return u;
	}
	public Users newArrival(Users u) {
		set(u);
		History h=u.getH();
		h.incN();
		u.setH(h);
		return u;
	}
}
