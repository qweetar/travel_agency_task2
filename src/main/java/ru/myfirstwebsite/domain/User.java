package ru.myfirstwebsite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
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

}
