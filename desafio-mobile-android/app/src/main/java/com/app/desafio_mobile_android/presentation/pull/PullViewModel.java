package com.app.desafio_mobile_android.presentation.pull;

import com.app.desafio_mobile_android.service.model.pull.Pull;

import java.util.List;

public class PullViewModel {
    private List<Pull> pullList;
    private int opened;
    private int closed;

    public PullViewModel(List<Pull> pullList, int opened, int closed) {
        this.pullList = pullList;
        this.opened = opened;
        this.closed = closed;
    }

    public List<Pull> getPullList() {
        return pullList;
    }

    public void setPullList(List<Pull> pullList) {
        this.pullList = pullList;
    }

    public int getOpened() {
        return opened;
    }

    public void setOpened(int opened) {
        this.opened = opened;
    }

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }
}
