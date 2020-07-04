package com.ylht.cos.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cos 对象存储通用工具类
 * 
 * @author pete_zuo
 * @param <T>
 */
public class CosPage<T> {
	// 启始条数
	private int start;

	// 结束条数
	private int end;
	// 总页数
	private int totalPage;
	// 当前页
	private int cpage = 1;
	// 总信息数
	private long totalRow;
	// 分页单位
	private int pageSize = 10;
	// 查询条件
	private Map<String, String> link = new HashMap();
	// 当前页的数据
	private List<T> list;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
		this.end = this.start + this.pageSize;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
		this.totalPage = (int) (totalRow / pageSize);
		if (totalRow % pageSize > 0)
			this.totalPage = this.totalPage + 1;
		this.cpage = (cpage <= 0) ? 1 : cpage;

		if (this.cpage > this.totalPage)
			this.cpage = this.totalPage;
		if (totalPage == 0) {
			this.cpage = 1;
		}
		this.start = (this.cpage - 1) * pageSize;
		this.end = this.start + pageSize - 1;

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, String> getLink() {
		return link;
	}

	public void setLink(Map<String, String> link) {
		this.link = link;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
