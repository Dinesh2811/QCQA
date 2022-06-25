package com.dinesh.qcqa.api.model;

import com.dinesh.qcqa.api.model.ApiModelProductsId;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiModel {

    @SerializedName("productsId")
    @Expose
    public List<ApiModelProductsId> apiModelProductsId = null;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("discountPercentage")
    @Expose
    public Double discountPercentage;
    @SerializedName("rating")
    @Expose
    public Double rating;
    @SerializedName("stock")
    @Expose
    public Integer stock;
    @SerializedName("brand")
    @Expose
    public String brand;
    @SerializedName("category")
    @Expose
    public String category;
    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
    @SerializedName("images")
    @Expose
    public List<String> images = null;

    public ApiModel(List<ApiModelProductsId> apiModelProductsId, String title, String description, Integer price, Double discountPercentage, Double rating, Integer stock, String brand, String category, String thumbnail, List<String> images) {
        this.apiModelProductsId = apiModelProductsId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
        this.images = images;
    }

    public ApiModel() {
    }

    @Override
    public String toString() {
        return "ApiModel{" +
                "apiModelProductsId=" + apiModelProductsId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", rating=" + rating +
                ", stock=" + stock +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", images=" + images +
                '}';
    }
}