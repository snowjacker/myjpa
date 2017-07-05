package boarduser;

import java.util.List;

import myjpa.entity.Cpu;
import myjpa.entity.Disk;
import myjpa.service.HardInfoService;


public class HardWareTest {
	public static void main(String[] args) {
		//cpuTest();
		//diskTest();
		//memTest();
		//swapTest();
	}

	private static void cpuTest() {
		List<Cpu> list=HardInfoService.CpuInfo();
		for (Cpu cpu : list) {
			System.err.println(cpu);
		}
	}
	private static void diskTest() {
		List<Disk> list=HardInfoService.diskInfo();
		for (Disk disk : list) {
			System.out.println(disk);
		}
	}
	private static void memTest(){
		Long [] mem=HardInfoService.memInfo();
		for (int i = 0; i < mem.length; i++) {
			System.err.println(mem[i]);
		}
	}
	private static void swapTest(){
		Long []swap=HardInfoService.swapInfo();
		for (int i = 0; i < swap.length; i++) {
			System.out.println(swap[i]);
		}
	}
}
