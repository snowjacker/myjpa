package myjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToController {
	@RequestMapping(value="tocpu")
	public String toCpu(){
		return "cpu";
	}
	@RequestMapping(value="tocpus")
	public String toCpus(){
		return "cpus";
	}
	@RequestMapping(value="tpmem")
	public String toMem(){
		return "memory";
	}
	@RequestMapping(value="toswap")
	public String toSwap(){
		return "swap";
	}
	@RequestMapping(value="disk")
	public String toDisk(){
		return "disk";
	}
}
