package emsi.WebCuaTui.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	//login page
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// home page
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
