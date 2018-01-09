package com.qingshixun.model.page;

public class PageUser {
	
	private int pageNow;
	
	private int totalSize;
	
	private int totalPage;
	
	private int pageSize = 6;
	
	private boolean hasPre;
	
	private boolean hasNext;
	
	private boolean hasFirst;
	
	private boolean hasLast;

	public PageUser(int pageNow, int totalSize) {
		this.setPageNow(pageNow);
		this.setTotalSize(totalSize);
	}

	public PageUser(int pageNow, int totalSize, int pageSize) {
		this.setPageNow(pageNow);
		this.setTotalSize(totalSize);
		this.pageSize=pageSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPage() {
		totalPage = this.getTotalSize() / this.getPageSize();
		if (this.getTotalSize() % this.getPageSize() != 0) {
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isHasPre() {
		if (this.isHasFirst()) {
			return true;
		} else {
			return false;
		}

	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		if (this.isHasLast()){
			return true;
		} else {
			return false;
		}
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasFirst() {
		if (this.pageNow == 1) {
			return false;
		} else {
			return true;

		}
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasLast() {
		if (pageNow == this.getTotalPage()) {
			return false;
		} else {
			return true;
		}
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

	@Override
	public String toString() {
		return "PageUser [pageNow=" + pageNow + ", totalSize=" + totalSize + ", totalPage=" + totalPage + ", pageSize="
				+ pageSize + ", hasPre=" + hasPre + ", hasNext=" + hasNext + ", hasFirst=" + hasFirst + ", hasLast="
				+ hasLast + "]";
	}

}
