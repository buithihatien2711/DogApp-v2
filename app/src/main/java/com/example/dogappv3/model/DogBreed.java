package com.example.dogappv3.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DogBreed implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("life_span")
    private String lifeSpan;

    @SerializedName("origin")
    private String origin;

    @SerializedName("url")
    private String url;

    @SerializedName("bred_for")
    private String bredFor;

    @SerializedName("bred_group")
    private String bred_group;

    @SerializedName("temperament")
    private String temperament;

//    @SerializedName("height")
//    private Height height;
//
//    @SerializedName("weight")
//    private Weight weight;

//    public DogBreed(int id, String name, String lifeSpan, String origin, String url, String bredFor,
//                    String bred_group, String temperament, Height height, Weight weight) {
//        this.id = id;
//        this.name = name;
//        this.lifeSpan = lifeSpan;
//        this.origin = origin;
//        this.url = url;
//        this.bredFor = bredFor;
//        this.bred_group = bred_group;
//        this.temperament = temperament;
//        this.height = height;
//        this.weight = weight;
//    }

    public DogBreed(int id, String name, String lifeSpan, String origin, String url, String bredFor) {
        this.id = id;
        this.name = name;
        this.lifeSpan = lifeSpan;
        this.origin = origin;
        this.url = url;
        this.bredFor = bredFor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getBredFor() {
        return bredFor;
    }

    public void setBredFor(String bredFor) {
        this.bredFor = bredFor;
    }


    public String getBred_group() {
        return bred_group;
    }

    public void setBred_group(String bred_group) {
        this.bred_group = bred_group;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

//    public Height getHeight() {
//        return height;
//    }
//
//    public void setHeight(Height height) {
//        this.height = height;
//    }
//
//    public Weight getWeight() {
//        return weight;
//    }
//
//    public void setWeight(Weight weight) {
//        this.weight = weight;
//    }
}
