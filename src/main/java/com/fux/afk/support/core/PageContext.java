package com.fux.afk.support.core;

import java.util.List;

/**
 *	数据库分页查询上下文封装
 */
public class PageContext {
	/**
	 * 从1开始，显示第page页
	 */
	private int page;
	/**
	 * 每页显示的条数
	 */
	private int row;
	/**
	 * 显示数据
	 */
	private List<?> datas;
	/**
	 * 符合查询条件的总条数
	 */
	private int total;

	public PageContext(int page, int row, List<?> datas, int total) {
		this.page = page;
		this.row = row;
		this.datas = datas;
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> datas) {
		this.datas = datas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
