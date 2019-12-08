package ru.myfirstwebsite.domain;

import lombok.Data;
import org.omg.CORBA.INTERNAL;
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
    private Float tourCost;

    @Column(name = "tour_type")
    @Enumerated(EnumType.STRING)
    private TourType tourType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "tour", fetch = FetchType.LAZY)
    private Set<Review> reviews;




}
