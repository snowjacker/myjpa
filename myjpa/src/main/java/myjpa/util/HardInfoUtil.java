package myjpa.util;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class HardInfoUtil {
	@SuppressWarnings("unused")
	private static void cpu() throws SigarException {
		Sigar sigar = new Sigar();
		printCpuPerc(sigar.getCpuPerc());
	}

	@SuppressWarnings("unused")
	private static void memory() throws SigarException {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		// 内存总量
		System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
		// 当前内存使用量
		System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
		// 当前内存剩余量
		System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
		Swap swap = sigar.getSwap();
		// 交换区总量
		System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
		// 当前交换区使用量
		System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
		// 当前交换区剩余量
		System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
	}

	private static void printCpuPerc(CpuPerc cpu) {
		System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
		System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
		System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
		System.out.println("CPU优先使用率:    " + CpuPerc.format(cpu.getNice()));//
		System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
		System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
	}
	@SuppressWarnings("unused")
	private static void file() throws Exception {
		Sigar sigar = new Sigar();
		FileSystem fslist[] = sigar.getFileSystemList();
		for (int i = 0; i < fslist.length; i++) {
			System.out.println("分区的盘符名称" + i);
			FileSystem fs = fslist[i];
			// 分区的盘符名称
			System.out.println("盘符名称:    " + fs.getDevName());
			// 分区的盘符名称
			System.out.println("盘符路径:    " + fs.getDirName());
			System.out.println("盘符标志:    " + fs.getFlags());//
			// 文件系统类型，比如 FAT32、NTFS
			System.out.println("盘符类型:    " + fs.getSysTypeName());
			// 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
			System.out.println("盘符类型名:    " + fs.getTypeName());
			// 文件系统类型
			System.out.println("盘符文件系统类型:    " + fs.getType());
			FileSystemUsage usage = null;
			usage = sigar.getFileSystemUsage(fs.getDirName());
			switch (fs.getType()) {
			case 0: // TYPE_UNKNOWN ：未知
				break;
			case 1: // TYPE_NONE
				break;
			case 2: // TYPE_LOCAL_DISK : 本地硬盘
				// 文件系统总大小
				System.out.println(fs.getDevName() + "总大小:    "
						+ usage.getTotal() + "KB");
				// 文件系统剩余大小
				System.out.println(fs.getDevName() + "剩余大小:    "
						+ usage.getFree() + "KB");
				// 文件系统可用大小
				System.out.println(fs.getDevName() + "可用大小:    "
						+ usage.getAvail() + "KB");
				// 文件系统已经使用量
				System.out.println(fs.getDevName() + "已经使用量:    "
						+ usage.getUsed() + "KB");
				double usePercent = usage.getUsePercent() * 100D;
				// 文件系统资源的利用率
				System.out.println(fs.getDevName() + "资源的利用率:    " + usePercent
						+ "%");
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
			System.out.println(fs.getDevName() + "读出：    "
					+ usage.getDiskReads());
			System.out.println(fs.getDevName() + "写入：    "
					+ usage.getDiskWrites());
		}
		return;
	}
	public class Task3 {
	    public static void main(String[] args) {
	        Runnable runnable = new Runnable() {
	            public void run() {
	                // task to run goes here
	                System.out.println("Hello !!");
	            }
	        };
	        ScheduledExecutorService service = Executors
	                .newSingleThreadScheduledExecutor();
	        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
	        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
	    }
}
