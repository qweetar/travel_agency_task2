package ru.myfirstwebsite.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "country")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer countryId;

    @Column(name = "name")
    private String countryName;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Tour> tours;


}
