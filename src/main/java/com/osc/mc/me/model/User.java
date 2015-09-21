package com.osc.mc.me.model;

import com.osc.mc.me.listener.Listener;

import javax.persistence.*;

@Entity
@EntityListeners(Listener.class)
@Table(name = "user")
public class User {
    @GeneratedValue
    @Id
    private String id;
    private String username;
    private String password;

    @PrePersist
    void onPrePersist() {
        username = username + " (ppmod)";
    }

    @PostPersist
    void onPostPersist() {
    }

    @PostLoad
    void onPostLoad() {
    }

    @PreUpdate
    void onPreUpdate() {
    }

    @PostUpdate
    void onPostUpdate() {
    }

    @PreRemove
    void onPreRemove() {
    }

    @PostRemove
    void onPostRemove() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
