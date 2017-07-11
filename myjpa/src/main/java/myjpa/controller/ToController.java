package myjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToController {
	@RequestMapping(value = "tocpu")
	public String toCpu() {
		return "cpu";
	}

	@RequestMapping(value = "tocpus")
	public String toCpus() {
		return "cpus";
	}

	@RequestMapping(value = "tomem")
	public String toMem() {
		return "memory";
	}

	@RequestMapping(value = "toswap")
	public String toSwap() {
		return "swap";
	}

	@RequestMapping(value = "todisk")
	public String toDisk() {
		return "disk";
	}
}
