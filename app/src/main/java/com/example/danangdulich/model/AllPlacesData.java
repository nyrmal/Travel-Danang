package com.example.danangdulich.model;

import java.util.ArrayList;
import java.util.List;

public class AllPlacesData {

    String placeName,areaName,openTime,desc,price;
    Integer imageUrl,pic1,pic2,pic3;
    Double rate;

//    public RecentsData(String placeName, String areaName, Integer imageUrl) {
//        this.placeName = placeName;
//        this.areaName = areaName;
//        this.imageUrl = imageUrl;
//    }

    public AllPlacesData(String placeName, String areaName, String openTime, Integer pic1, Integer pic2, Integer pic3, String desc, String price, Integer imageUrl, Double rate) {
        this.placeName = placeName;
        this.areaName = areaName;
        this.openTime = openTime;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.desc = desc;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rate = rate;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Integer getPic1() {
        return pic1;
    }

    public void setPic1(Integer pic1) {
        this.pic1 = pic1;
    }

    public Integer getPic2() {
        return pic2;
    }

    public void setPic2(Integer pic2) {
        this.pic2 = pic2;
    }

    public Integer getPic3() {
        return pic3;
    }

    public void setPic3(Integer pic3) {
        this.pic3 = pic3;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
