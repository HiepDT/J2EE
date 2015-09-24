package com.osc.mc.me.listener;

import com.osc.mc.me.model.User;

import javax.persistence.*;

public class Listener {
    @PrePersist
    void onPrePersist(Object o) {
        ((User) o).setDescription(((User) o).getDescription()+"onPrePersist: from entity listener\n");
    }

    @PostPersist
    void onPostPersist(Object o) {
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
