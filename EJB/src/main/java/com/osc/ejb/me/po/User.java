package com.osc.ejb.me.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable{
    @GeneratedValue
    @Id
    private String id;
    private String username;
    private String password;
    @Basic(fetch = FetchType.LAZY)
    private String company;
    private String description;

    // Init method
    public void init() {
        this.description = "";
        this.company = "OSC";
    }

    @PostPersist
    void onPostPersist() {
        this.company+= " (postPersist)not very smart.";
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @PrePersist
    void onPrePersist() {
        this.description+="onPrePersist: from within the entity\n";
    }
}