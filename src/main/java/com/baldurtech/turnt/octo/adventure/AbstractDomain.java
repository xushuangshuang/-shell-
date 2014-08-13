package com.baldurtech.turnt.octo.adventure;

public abstract class AbstractDomain {
    private Boolean persistent = false;

    public Boolean isPersistent() {
        return persistent;
    }

    void setPersistent(Boolean persistent) {
        this.persistent = persistent;
    }
}
