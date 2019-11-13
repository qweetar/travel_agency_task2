package ru.myfirstwebsite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
//@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = :email")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"userName", "email"})
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

  @ManyToMany
  @JoinTable(name = "user_tour",
          joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "tour_id", referencedColumnName = "id")
  )
  private Set<Tour> tours;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private Set<Review> reviews;

}
