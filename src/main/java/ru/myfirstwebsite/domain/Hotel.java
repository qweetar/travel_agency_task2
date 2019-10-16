package ru.myfirstwebsite.domain;

import ru.myfirstwebsite.domain.enums.Features;

import java.util.Objects;

public class Hotel {

    private Long hotelId;
    private String hotelName;
    private Integer hotelStars;
    private String hotelWebSite;
    private String hotelLatitude;
    private String hotelLongitude;
    private Features hotelFeatures;

    public Hotel() {
    }

    public Hotel(Long hotelId, String hotelName, Integer hotelStars, String hotelWebSite, String hotelLatitude, String hotelLongitude, Features hotelFeatures) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelWebSite = hotelWebSite;
        this.hotelLatitude = hotelLatitude;
        this.hotelLongitude = hotelLongitude;
        this.hotelFeatures = hotelFeatures;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(Integer hotelStars) {
        this.hotelStars = hotelStars;
    }

    public String getHotelWebSite() {
        return hotelWebSite;
    }

    public void setHotelWebSite(String hotelWebSite) {
        this.hotelWebSite = hotelWebSite;
    }

    public String getHotelLatitude() {
        return hotelLatitude;
    }

    public void setHotelLatitude(String hotelLatitude) {
        this.hotelLatitude = hotelLatitude;
    }

    public String getHotelLongitude() {
        return hotelLongitude;
    }

    public void setHotelLongitude(String hotelLongitude) {
        this.hotelLongitude = hotelLongitude;
    }

    public Features getHotelFeatures() {
        return hotelFeatures;
    }

    public void setHotelFeatures(Features hotelFeatures) {
        this.hotelFeatures = hotelFeatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(getHotelId(), hotel.getHotelId()) &&
                Objects.equals(getHotelName(), hotel.getHotelName()) &&
                Objects.equals(getHotelStars(), hotel.getHotelStars()) &&
                Objects.equals(getHotelWebSite(), hotel.getHotelWebSite()) &&
                Objects.equals(getHotelLatitude(), hotel.getHotelLatitude()) &&
                Objects.equals(getHotelLongitude(), hotel.getHotelLongitude()) &&
                getHotelFeatures() == hotel.getHotelFeatures();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHotelId(), getHotelName(), getHotelStars(), getHotelWebSite(), getHotelLatitude(), getHotelLongitude(), getHotelFeatures());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelStars=" + hotelStars +
                ", hotelWebSite='" + hotelWebSite + '\'' +
                ", hotelLatitude='" + hotelLatitude + '\'' +
                ", hotelLongitude='" + hotelLongitude + '\'' +
                ", hotelFeatures=" + hotelFeatures +
                '}';
    }
}
