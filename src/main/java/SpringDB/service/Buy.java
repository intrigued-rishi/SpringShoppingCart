package SpringDB.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import SpringDB.model.UserCrud;
import SpringDB.schema.Apparel;
import SpringDB.schema.Users;

@Service
public class Buy {
	
	
	public Users buy(Apparel a,Users u) {
		Order o=new Order();
		Set<Apparel> ap = u.getAp();
		ap.add(a);
		u.setAp(ap);
		if(a.getType().equals("Seasonal"))
			o.seasonal(u);
		else
			o.newArrival(u);
		return u;
	}
}
