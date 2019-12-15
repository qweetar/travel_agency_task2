package ru.myfirstwebsite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
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

  @ManyToMany(mappedBy = "users",
          fetch = FetchType.EAGER,
          cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
  })
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Tour> tours;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Review> reviews;

}
