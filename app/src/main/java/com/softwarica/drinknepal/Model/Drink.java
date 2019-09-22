package com.softwarica.drinknepal.Model;

public class Drink {
    String _id,product_name,product_price,product_quantity,product_photo,product_description,type,createddate;

    public Drink(String _id, String product_name, String product_price, String product_quantity, String product_photo, String product_description, String type, String createddate) {
        this._id = _id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_photo = product_photo;
        this.product_description = product_description;
        this.type = type;
        this.createddate = createddate;
    }

    public Drink(String product_name, String product_price, String product_quantity, String product_photo, String product_description, String type, String createddate) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_photo = product_photo;
        this.product_description = product_description;
        this.type = type;
        this.createddate = createddate;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(String product_photo) {
        this.product_photo = product_photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }
}
