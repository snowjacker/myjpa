package myjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping("/name")
public class TestController {
	@RequestMapping("/name")
	public String name() {
		return "names";
	}
}
