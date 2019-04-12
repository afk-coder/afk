package com.fux.afk.support.vo;

import org.springframework.data.domain.Page;

import java.util.Collection;

/**
 * Created by fuxiaoj on 2018/12/24 0024.
 */
public class BootstrapTable {

    protected Collection<?> rows;

    private long total;

    private Collection<?> footer;

    public BootstrapTable() {
        this(null);
    }

    public BootstrapTable(Page page) {
        if(page.isEmpty()) {
            this.rows = null;
            total = 0;
            this.footer = null;
        } else {
            this.rows = page.getContent();
            this.total = page.getTotalElements();
            this.footer = null;
        }
    }

    public Collection<?> getRows() {
        return rows;
    }

    public void setRows(Collection<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Collection<?> getFooter() {
        return footer;
    }

    public void setFooter(Collection<?> footer) {
        this.footer = footer;
    }
}
