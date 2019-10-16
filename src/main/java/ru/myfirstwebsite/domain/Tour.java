package ru.myfirstwebsite.domain;

import ru.myfirstwebsite.domain.enums.TourType;

import java.util.Date;
import java.util.Objects;

public class Tour {
    private Long tourId;
    private String tourPhoto;
    private Date tourDate;
    private Integer tourDuration;
    private String tourDescription;
    private Integer tourCost;
    private TourType tourType;
    private Long hotelId;
    private Integer countryId;

    public Tour() {
    }

    public Tour(Long tourId, String tourPhoto, Date tourDate, Integer tourDuration, String tourDescription, Integer tourCost, TourType tourType, Long hotelId, Integer countryId) {
        this.tourId = tourId;
        this.tourPhoto = tourPhoto;
        this.tourDate = tourDate;
        this.tourDuration = tourDuration;
        this.tourDescription = tourDescription;
        this.tourCost = tourCost;
        this.tourType = tourType;
        this.hotelId = hotelId;
        this.countryId = countryId;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public String getTourPhoto() {
        return tourPhoto;
    }

    public void setTourPhoto(String tourPhoto) {
        this.tourPhoto = tourPhoto;
    }

    public Date getTourDate() {
        return tourDate;
    }

    public void setTourDate(Date tourDate) {
        this.tourDate = tourDate;
    }

    public Integer getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(Integer tourDuration) {
        this.tourDuration = tourDuration;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public Integer getTourCost() {
        return tourCost;
    }

    public void setTourCost(Integer tourCost) {
        this.tourCost = tourCost;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(getTourId(), tour.getTourId()) &&
                Objects.equals(getTourPhoto(), tour.getTourPhoto()) &&
                Objects.equals(getTourDate(), tour.getTourDate()) &&
                Objects.equals(getTourDuration(), tour.getTourDuration()) &&
                Objects.equals(getTourDescription(), tour.getTourDescription()) &&
                Objects.equals(getTourCost(), tour.getTourCost()) &&
                getTourType() == tour.getTourType() &&
                Objects.equals(getHotelId(), tour.getHotelId()) &&
                Objects.equals(getCountryId(), tour.getCountryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourId(), getTourPhoto(), getTourDate(), getTourDuration(), getTourDescription(), getTourCost(), getTourType(), getHotelId(), getCountryId());
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", tourPhoto='" + tourPhoto + '\'' +
                ", tourDate=" + tourDate +
                ", tourDuration=" + tourDuration +
                ", tourDescription='" + tourDescription + '\'' +
                ", tourCost=" + tourCost +
                ", tourType=" + tourType +
                ", hotelId=" + hotelId +
                ", countryId=" + countryId +
                '}';
    }
}
