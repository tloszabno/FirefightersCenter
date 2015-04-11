package pl.agh.tomtom.firefighters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
 
 
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView welcome(@RequestParam("name") String name) {
 
 
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);
 
		return model;
 
	}
 
}