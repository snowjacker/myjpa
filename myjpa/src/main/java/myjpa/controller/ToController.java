package myjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToController {
	@RequestMapping(value="tocpu")
	public String toCpu(){
		return "cpu";
	}
}
