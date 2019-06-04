package com.utilapi.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_bank")
public class UserEntity {

    @Id
    @Column(name = "id")
    private int identity;
    @Column(name = "user_name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "user_pwd")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "is_employee")
    private boolean isBankEmployee;

    protected UserEntity() {
    }

    public UserEntity(int identity, String name, String username, String password, String email, boolean isBankEmployee) {
        this.identity = identity;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isBankEmployee = isBankEmployee;
    }

    public int getIdentity() {
        return identity;
    }

    public UserEntity setIdentity(int identity) {
        this.identity = identity;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isBankEmployee() {
        return isBankEmployee;
    }

    public UserEntity setBankEmployee(boolean bankEmployee) {
        isBankEmployee = bankEmployee;
        return this;
    }
}
