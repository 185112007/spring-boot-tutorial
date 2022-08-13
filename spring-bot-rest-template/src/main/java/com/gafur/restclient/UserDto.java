package com.gafur.restclient;

import java.util.List;

public class UserDto {
    private Long id;
    private String name;
    private String surName;
    private List<String> userAddresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<String> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<String> userAddresses) {
        this.userAddresses = userAddresses;
    }
}
