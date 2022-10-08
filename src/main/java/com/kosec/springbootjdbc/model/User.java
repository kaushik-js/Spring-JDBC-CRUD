package com.kosec.springbootjdbc.model;

public class User {
    private int id;
    private String unm;
    private String email;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUnm() {
        return unm;
    }
    public void setUnm(String unm) {
        this.unm = unm;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", unm=" + unm + ", email=" + email + "]";
    }
    
    
}
