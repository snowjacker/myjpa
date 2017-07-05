package myjpa.entity;

/**
 * @author guobaol
 * @descriptin this class was used to describle the infomation of a cpu
 *
 */
public class Cpu {
	public Cpu() {
	}

	public Long getCacheSize() {
		return cacheSize;
	}

	public String getCpuModel() {
		return cpuModel;
	}

	public double getIdle() {
		return Idle;
	}

	public double getNice() {
		return nice;
	}

	public double getSys() {
		return Sys;
	}

	public double getTotal() {
		return total;
	}

	public int getTotalMhz() {
		return totalMhz;
	}

	public double getUser() {
		return user;
	}

	public String getVender() {
		return vender;
	}

	public double getWait() {
		return wait;
	}

	public void setCacheSize(Long cacheSize) {
		this.cacheSize = cacheSize;
	}

	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}

	public void setIdle(double idle) {
		Idle = idle;
	}

	public void setNice(double nice) {
		this.nice = nice;
	}

	public void setSys(double sys) {
		Sys = sys;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setTotalMhz(int totalMhz) {
		this.totalMhz = totalMhz;
	}

	public void setUser(double user) {
		this.user = user;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

	public void setWait(double wait) {
		this.wait = wait;
	}

	@Override
	public String toString() {
		return "Cpu [totalMhz=" + totalMhz + ", vender=" + vender
				+ ", cpuModel=" + cpuModel + ", cacheSize=" + cacheSize
				+ ", user=" + user + ", Sys=" + Sys + ", wait=" + wait
				+ ", nice=" + nice + ", Idle=" + Idle + ", total=" + total
				+ "]";
	}

	private int totalMhz;// 频率

	private String vender;// 生产商

	private String cpuModel;// 型号

	private Long cacheSize;// 缓存

	private double user;// 用户使用率

	private double Sys;// 系统使用率

	private double wait;// 等待率

	private double nice;// 优先运算使用率

	private double Idle;// 空闲率

	private double total;// 总得使用率;

}
