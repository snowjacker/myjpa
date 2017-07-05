package myjpa.entity;

/**
 * @author guobaol
 * @description this class was used to build some infomation of a disk
 *@field
 *	diskName: the name of disk
 *  totalSize: the size of disk
 *  usedSize:the size has been used
 *  freeSize: the size of free to be used
 *  leftSize: the size of has not been used
 */

public class Disk {
	private String diskName;
	private Long totalSize;
	private Long usedSize;
	private Long freeSize;
	private Long leftSize;
	public Disk(){}
	public Disk(String diskName, Long totalSize, Long usedSize,
			Long freeSize, Long leftSize) {
		this.diskName = diskName;
		this.totalSize = totalSize;
		this.usedSize = usedSize;
		this.freeSize = freeSize;
		this.leftSize = leftSize;
	}
	public String getDiskName() {
		return diskName;
	}
	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public Long getUsedSize() {
		return usedSize;
	}
	public void setUsedSize(Long usedSize) {
		this.usedSize = usedSize;
	}
	public Long getFreeSize() {
		return freeSize;
	}
	public void setFreeSize(Long freeSize) {
		this.freeSize = freeSize;
	}
	public Long getLeftSize() {
		return leftSize;
	}
	public void setLeftSize(Long leftSize) {
		this.leftSize = leftSize;
	}
	@Override
	public String toString() {
		return "DiskUtil [diskName=" + diskName + ", totalSize=" + totalSize
				+ ", usedSize=" + usedSize + ", freeSize=" + freeSize
				+ ", leftSize=" + leftSize + "]";
	};
	
	
}
