package ru.myfirstwebsite.domain;

import lombok.Data;
import ru.myfirstwebsite.domain.enums.TourType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tour")
@Data
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long tourId;

    @Column(name = "photo")
    private String tourPhoto;

    @Column(name = "date")
    private Date tourDate;

    @Column(name = "duration")
    private Integer tourDuration;

    @Column(name = "description")
    private String tourDescription;

    @Column(name = "cost")
    private Integer tourCost;

    @Column(name = "tour_type")
    private TourType tourType;

    @ManyToOne(targetEntity = Hotel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private Long hotelId;

    @ManyToOne(targetEntity = Country.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Integer countryId;

//    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Review> reviews;
//
//    @ManyToMany(mappedBy = "userTours")
//    private Set<User> travelers = new HashSet<>();



}
