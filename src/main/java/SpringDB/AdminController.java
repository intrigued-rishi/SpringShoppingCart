package SpringDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringDB.model.ApparelCrud;
import SpringDB.schema.Apparel;

@Controller
public class AdminController {
	
	@Autowired
	ApparelCrud ac;
	
	@RequestMapping("/admin")
	public ModelAndView Add() {
		ModelAndView mv=new ModelAndView("/Add.jsp");
		List<Apparel> l=ac.findAll();
		mv.addObject("apparels", l);
		return mv;
	}
	
	@RequestMapping("/admin/hello")
	public void display() {
		System.out.println("whhy");
	}
	
	@RequestMapping(value="/admin/addApparel",method=RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView Submit(Apparel ap) {
		ac.save(ap);
		ModelAndView mv=new ModelAndView("/Add.jsp");
		List<Apparel> l=ac.findAll();
		mv.addObject("apparels", l);
		return mv;
	}
	@RequestMapping("/admin/deleteApparel")
	public ModelAndView delete(@RequestParam("id") int id) {
		//System.out.println(id);
		ac.deleteById(id);
		ModelAndView mv=new ModelAndView("/Add.jsp");
		List<Apparel> l=ac.findAll();
		mv.addObject("apparels", l);
		return mv;
	}
	
	@RequestMapping("/admin/Search")
	public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView mv=new ModelAndView("/Add.jsp");
		List<Apparel> l=ac.findBySearch(search);
		mv.addObject("apparels", l);
		return mv;
	}
	
}
