package ru.myfirstwebsite.domain;

import lombok.Data;
import ru.myfirstwebsite.domain.enums.Features;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long hotelId;

    @Column(name = "name")
    private String hotelName;

    @Column(name = "stars")
    private Integer hotelStars;

    @Column(name = "website")
    private String hotelWebSite;

    @Column(name = "latitude")
    private String hotelLatitude;

    @Column(name = "longitude")
    private String hotelLongitude;

    @Column(name = "features")
    private Features hotelFeatures;

//    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Tour> tours;

}
