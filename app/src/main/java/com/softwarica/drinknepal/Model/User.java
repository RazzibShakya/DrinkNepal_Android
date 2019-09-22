package com.softwarica.drinknepal.Model;

public class User {
    String _id,name,phone,email,dob,address,password;

    public User(String _id,String name, String phone, String email, String dob, String address, String password) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.password = password;
    }

    public User(String name, String phone, String email, String dob, String address, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.password = password;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
