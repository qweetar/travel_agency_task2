package ru.myfirstwebsite.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long reviewId;

    @Column(name = "date")
    private Date reviewDate;

    @Column(name = "text")
    private String reviewText;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private Long userId;

    @ManyToOne(targetEntity = Tour.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    private Long tourId;


}
