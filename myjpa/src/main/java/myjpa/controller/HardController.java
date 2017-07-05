package myjpa.controller;

import java.util.List;

import myjpa.entity.Cpu;
import myjpa.entity.Disk;
import myjpa.service.HardInfoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hard")
public class HardController {
	
	@RequestMapping(value="/cpu")
	public ModelAndView Cpu(){
		List<Cpu> cpus=HardInfoService.CpuInfo();
		ModelAndView mav=new ModelAndView("cpu");
		mav.addObject("mav",cpus);
		return mav;
	}
	@RequestMapping(value = "/disk", method = RequestMethod.GET)
	public ModelAndView getDiskInfo() {
		List<Disk> disk = HardInfoService.diskInfo();
		ModelAndView mav=new ModelAndView("disk");
		mav.addObject("mav",disk);
		return mav;
	}

	@RequestMapping(value = "/memory", method = RequestMethod.GET)
	public ModelAndView getMemInfo() {
		Long[] memory = HardInfoService.memInfo();
		ModelAndView mav=new ModelAndView("memory");
		mav.addObject("mav",memory);
		return mav;
	}

	@RequestMapping(value = "/swap", method = RequestMethod.GET)
	public ModelAndView getSwap() {
		Long[] swap = HardInfoService.swapInfo();
		ModelAndView mav=new ModelAndView("swap");
		mav.addObject("mav",swap);
		return mav;
	}
}
