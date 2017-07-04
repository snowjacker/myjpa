package myjpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HardController {
	@RequestMapping(value = "/cpu", method = RequestMethod.GET)
	public String getCpuInfo() {

		return "hard";
	}

	@RequestMapping(value = "/disk", method = RequestMethod.GET)
	public String getDiskInfo() {

		return "hard";
	}

	@RequestMapping(value = "/memory", method = RequestMethod.GET)
	public String getMemInfo() {

		return "hard";
	}
}
