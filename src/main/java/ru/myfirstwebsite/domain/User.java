package ru.myfirstwebsite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "userName"})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username")
  private String userName;

  @Column(name = "email")
  private String email;

  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String pass;

  @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Review> reviews;

  @ManyToMany
  @JoinTable(
          name = "user_tour",
          joinColumns = {@JoinColumn(name = "usr_id")},
          inverseJoinColumns = {@JoinColumn(name = "tour_id")}
  )
  private Set<Tour> userTours = new HashSet<>();


}
