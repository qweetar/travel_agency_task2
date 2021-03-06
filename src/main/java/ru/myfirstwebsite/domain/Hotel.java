package ru.myfirstwebsite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.myfirstwebsite.domain.enums.Features;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private Features hotelFeatures;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Tour> tours;

}
