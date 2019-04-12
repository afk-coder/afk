package com.fux.afk.support.vo;

import java.util.List;

/**
 * Created by fuxj on 2019-3-19
 */
public class JsTreeJson {

    private String id;
    private String text;
    private List<JsTreeJson> children;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<JsTreeJson> getChildren() {
        return children;
    }

    public void setChildren(List<JsTreeJson> children) {
        this.children = children;
    }
}
