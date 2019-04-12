package com.fux.afk.support.vo;

import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by fuxiaoj on 2018/12/21 0021.
 */
public class SearchVo {

    private int page = 1;

    private int rows = 20;

    private String filed;

    private Direct direct;

    public Map<String, String> args;

    public SearchVo() {
    }

    public enum Direct {
        asc, desc
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public Direct getDirect() {
        return direct;
    }

    public void setDirect(Direct direct) {
        this.direct = direct;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }
}
