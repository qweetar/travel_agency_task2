package ru.myfirstwebsite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.myfirstwebsite.domain.enums.TourType;

import javax.persistence.*;
import java.util.Date;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Country country;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Review> reviews;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "user_tour",
            joinColumns = @JoinColumn(name = "tour_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<User> users;


}
