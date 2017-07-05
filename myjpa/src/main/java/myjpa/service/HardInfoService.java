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
	 * @description: get the info of a cpu
	 * 
	 */
	public static List<Cpu> CpuInfo() {
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
				// 单个cpu的使用率
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
			fslist = sigar.getFileSystemList();
			for (int i = 0; i < fslist.length; i++) {
				Disk disk = new Disk();
				FileSystem fs = fslist[i];
				disk.setDiskName(fs.getDevName());
				FileSystemUsage usage = sigar.getFileSystemUsage(fs
						.getDirName());
				switch (fs.getType()) {
				case 0: // TYPE_UNKNOWN ：未知
					break;
				case 1: // TYPE_NONE
					break;
				case 2: // TYPE_LOCAL_DISK : 本地硬盘
					disk.setTotalSize(usage.getTotal());
					disk.setFreeSize(usage.getFree());
					disk.setLeftSize(usage.getAvail());
					disk.setUsedSize(usage.getUsed());
					break;
				case 3:// TYPE_NETWORK ：网络
					break;
				case 4:// TYPE_RAM_DISK ：闪存
					break;
				case 5:// TYPE_CDROM ：光驱
					break;
				case 6:// TYPE_SWAP ：页面交换
					break;
				}
				list.add(disk);
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
	public static Long[] memInfo() {
		try {
			mem = sigar.getMem();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memInfo[0] = mem.getTotal() / 1024L;
		memInfo[1] = mem.getUsed() / 1024L;
		memInfo[2] = mem.getFree() / 1024L;
		return memInfo;
	}

	/**
	 * @return the array of swap
	 * @description used to get some infomation of a swap
	 */
	public static Long[] swapInfo() {
		try {
			swap = sigar.getSwap();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		swapInfo[0] = swap.getTotal();
		swapInfo[1] = swap.getUsed();
		swapInfo[2] = swap.getFree();
		return swapInfo;
	}

	private static Sigar sigar = new Sigar();
	// 虚拟内存对象
	private static Swap swap = null;
	// memory
	private static Mem mem = null;
	// memory info
	private static Long[] memInfo = new Long[3];
	// swap info
	private static Long[] swapInfo = new Long[3];
	// list of disk
	private static List<Disk> list = new ArrayList<Disk>();
	//list of the file in the disk
	private static FileSystem[] fslist;
	//the cpu list
	private static List<Cpu> cpuList = new ArrayList<Cpu>();
}
