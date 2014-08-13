package com.baldurtech.turnt.octo.adventure.domain;

public abstract class AbstractDomain {
    private Boolean persistent = false;

    public Boolean isPersistent() {
        return persistent;
    }

    public void setPersistent(Boolean persistent) {
        this.persistent = persistent;
    }
}
