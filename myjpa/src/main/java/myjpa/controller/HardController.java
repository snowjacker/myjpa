package myjpa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import myjpa.entity.Cpu;
import myjpa.entity.Disk;
import myjpa.service.BoardUserService;
import myjpa.service.HardInfoService;
import myjpa.util.IntegerEditer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hard")
public class HardController {
	
	@RequestMapping(value = "/percpu", method = RequestMethod.GET)
	public String findAll(ModelMap map) {
		List<Cpu> cpus = HardInfoService.CpuInfo();
		map.put("cpus", cpus);
		return "cpu";
	}
	
	@RequestMapping(value="/cpu")
	public ModelAndView Cpu(){
		List<Cpu> cpus=HardInfoService.CpuInfo();
		ModelAndView mav=new ModelAndView("cpu");
		mav.addObject("mav",cpus);
		return mav;
	}
	@RequestMapping(value = "/disk", method = RequestMethod.GET)
	public String getDiskInfo(ModelMap map) {
		List<Disk> disk = HardInfoService.diskInfo();
		map.put("disk", disk);
		return "hard";
	}

	@RequestMapping(value = "/memory", method = RequestMethod.GET)
	public String getMemInfo(ModelMap map) {
		Long[] memory = HardInfoService.memInfo();
		map.put("memory", memory);
		return "hard";
	}

	@RequestMapping(value = "/swap", method = RequestMethod.GET)
	public String getSwap(ModelMap map) {
		Long[] swap = HardInfoService.swapInfo();
		map.put("swap", swap);
		return "hard";
	}
	@Autowired
	private BoardUserService userService;
	@Autowired
	private HardInfoService hardInfoService;
}
