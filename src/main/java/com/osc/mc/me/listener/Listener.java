package com.osc.mc.me.listener;

import com.osc.mc.me.model.User;

import javax.persistence.*;

public class Listener {
    @PrePersist
    void onPrePersist(Object o) {
    }

    @PostPersist
    void onPostPersist(Object o) {
        ((User) o).setPassword(((User) o).getPassword() + " (xmod)");
    }

    @PostLoad
    void onPostLoad(Object o) {
    }

    @PreUpdate
    void onPreUpdate(Object o) {
    }

    @PostUpdate
    void onPostUpdate(Object o) {
    }

    @PreRemove
    void onPreRemove(Object o) {
    }

    @PostRemove
    void onPostRemove(Object o) {
    }
}
