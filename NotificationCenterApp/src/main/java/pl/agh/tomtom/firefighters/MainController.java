package pl.agh.tomtom.firefighters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:newFireNotication.htm";
	}
}