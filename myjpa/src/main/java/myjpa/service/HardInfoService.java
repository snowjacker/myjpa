package myjpa.service;

import java.util.ArrayList;
import java.util.List;

import myjpa.entity.Cpu;
import myjpa.entity.Disk;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.springframework.stereotype.Service;

@Service
public class HardInfoService {
	/**
	 * @return the list of cpu
	 * @description: get the info of every cpu
	 * 
	 */
	public static List<Cpu> CpuInfo() {
		if (cpuList.size() > 0) {
			cpuList.clear();
		}
		try {
			CpuInfo infos[] = sigar.getCpuInfoList();
			CpuPerc cpuPercs[] = sigar.getCpuPercList();
			for (int i = 0; i < infos.length; i++) {
				CpuInfo info = infos[i];
				CpuPerc cpuperc = cpuPercs[i];
				Cpu cpu = new Cpu();
				cpu.setCacheSize(info.getCacheSize());
				cpu.setCpuModel(info.getModel());
				cpu.setTotalMhz(info.getMhz());
				cpu.setVender(info.getVendor());
				cpu.setUser(cpuperc.getUser());
				cpu.setSys(cpuperc.getSys());
				cpu.setWait(cpuperc.getWait());
				cpu.setNice(cpuperc.getNice());
				cpu.setIdle(cpuperc.getIdle());
				// 鍗曚釜cpu鐨勪娇鐢ㄧ巼
				cpu.setTotal(cpuperc.getCombined());

				cpuList.add(cpu);
			}
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpuList;
	}

	/**
	 * @return list of disk
	 * @description: get the info of a disk
	 */
	public static List<Disk> diskInfo() {
		try {
			if (list.size() > 0) {
				list.clear();
			}
			fslist = sigar.getFileSystemList();
			for (int i = 0; i < fslist.length; i++) {
				Disk disk = new Disk();
				FileSystem fs = fslist[i];
				disk.setDiskName(fs.getDevName());
				FileSystemUsage usage;

				try {
					usage = sigar.getFileSystemUsage(fs.getDirName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}

				switch (fs.getType()) {
				case 0: // TYPE_UNKNOWN 锛氭湭鐭�
					break;
				case 1: // TYPE_NONE
					break;
				case 2: // TYPE_LOCAL_DISK : 鏈湴纭洏
					disk.setTotalSize(usage.getTotal());
					disk.setFreeSize(usage.getFree());
					disk.setLeftSize(usage.getAvail());
					disk.setUsedSize(usage.getUsed());
					list.add(disk);
					break;
				case 3:// TYPE_NETWORK 锛氱綉缁�
					break;
				case 4:// TYPE_RAM_DISK 锛氶棯瀛�
					break;
				case 5:// TYPE_CDROM 锛氬厜椹�
					break;
				case 6:// TYPE_SWAP 锛氶〉闈氦鎹�
					break;
				}
			}
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return the array of memory
	 * @description used to get some infomation of a memory
	 */
	public static List<Long> memInfo() {
		if (memInfo.size() > 0) {
			memInfo.clear();
		}
		try {
			mem = sigar.getMem();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memInfo.add(mem.getTotal() / 1024L);
		memInfo.add(mem.getUsed() / 1024L);
		memInfo.add(mem.getFree() / 1024L);
		return memInfo;
	}

	/**
	 * @return the array of swap
	 * @description used to get some infomation of a swap
	 */
	public static List<Long> swapInfo() {
		if (swapInfo.size() > 0) {
			swapInfo.clear();
		}
		try {
			swap = sigar.getSwap();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		swapInfo.add(swap.getTotal());
		swapInfo.add(swap.getUsed());
		swapInfo.add(swap.getFree());
		return swapInfo;
	}
	/** 
	 * @return double
	 * calculate the  avange useage rate of the cpu 
	 */
	public static Double getAvangeRate(){
		List<Cpu> cpuList=CpuInfo();
		double total = 0;
		for (int i = 0; i < cpuList.size(); i++) {
			total+=cpuList.get(i).getTotal();
		}
		cpuRate=total/cpuList.size();
		return cpuRate;
	}

	private static Sigar sigar = new Sigar();
	// 铏氭嫙鍐呭瓨瀵硅薄
	private static Swap swap = null;
	// memory
	private static Mem mem = null;
	// memory info
	private static List<Long> memInfo = new ArrayList<Long>();
	// swap info
	private static List<Long> swapInfo = new ArrayList<Long>();
	// list of disk
	private static List<Disk> list = new ArrayList<Disk>();
	// list of the file in the disk
	private static FileSystem[] fslist;
	// the cpu list
	private static List<Cpu> cpuList = new ArrayList<Cpu>();
	//get the avange of the cpu
	private static double cpuRate;
}
