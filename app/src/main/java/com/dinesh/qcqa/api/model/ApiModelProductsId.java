package com.dinesh.qcqa.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiModelProductsId {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("quantity")
    @Expose
    public Integer quantity;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("discountPercentage")
    @Expose
    public Double discountPercentage;
    @SerializedName("discountedPrice")
    @Expose
    public Integer discountedPrice;

    public ApiModelProductsId(Integer id, String title, Integer price, Integer quantity, Integer total, Double discountPercentage, Integer discountedPrice) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.discountPercentage = discountPercentage;
        this.discountedPrice = discountedPrice;
    }

    public ApiModelProductsId() {
    }

    @Override
    public String toString() {
        return "ApiModelProductsId{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                ", discountPercentage=" + discountPercentage +
                ", discountedPrice=" + discountedPrice +
                '}';
    }
}
