package boarduser;

import java.util.List;

import myjpa.entity.Cpu;
import myjpa.entity.Disk;
import myjpa.service.HardInfoService;

public class HardWareTest {
	public static void main(String[] args) {
		//cpuTest();
		testRate();
		// diskTest();
		// memTest();
		// swapTest();
		
	}

	private static void cpuTest() {
		List<Cpu> list = HardInfoService.CpuInfo();
		for (Cpu cpu : list) {
			System.err.println(cpu);
		}
	}

	private static void diskTest() {
		List<Disk> list = HardInfoService.diskInfo();
		for (Disk disk : list) {
			System.out.println(disk);
		}
	}

	private static void memTest() {
		List<Long> mem = HardInfoService.memInfo();
		for (Long long1 : mem) {
			System.err.println(long1);
		}
	}

	private static void swapTest() {
		List<Long> swap = HardInfoService.swapInfo();
		for (Long long1 : swap) {
			System.err.println(long1);
		}
	}
	private static void testRate(){
		double rate=HardInfoService.getAvangeRate();
		System.out.println(rate);
	}
}
