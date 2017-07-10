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
	
	@RequestMapping(value="/cpus")
	public List<Cpu> getCpus(){
		List<Cpu> cpus=HardInfoService.CpuInfo();
		return cpus;
	}
	@RequestMapping(value = "/disk", method = RequestMethod.GET)
	public List<Disk> getDiskInfo() {
		List<Disk> disk = HardInfoService.diskInfo();
		return disk;
	}

	@RequestMapping(value = "/memory", method = RequestMethod.GET)
	public List<Long> getMemInfo() {
		List<Long> memory = HardInfoService.memInfo();
		return memory;
	}

	@RequestMapping(value = "/swap", method = RequestMethod.GET)
	public List<Long> getSwap() {
		List<Long> swap = HardInfoService.swapInfo();
		return swap;
	}
	@RequestMapping(value = "/cpu", method = RequestMethod.GET)
	public double  getCpu() {
		double rate=HardInfoService.getAvangeRate();
		return rate;
	}
}
