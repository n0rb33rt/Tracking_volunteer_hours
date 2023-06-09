package com.azn.tracking_volunteer_hours.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "email", length = 319,nullable = false,unique = true)
    private String email;

    @Column(name = "password", length = 70)
    @JsonIgnore
    private String password;

    @Column(name = "first_name", length = 20,nullable = false)
    private String firstname;

    @Column(name = "last_name", length = 20,nullable = false)
    private String lastname;
    @Column(name = "hours")
    private Integer hours;
    @Column(name = "scores")
    private Integer scores;
    @Column(name = "got_gold_heart")
    private boolean gotGoldHeart;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore

    @JoinTable(
            name = "user_projects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    List<Project> userProjects;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", hours=" + hours +
                '}';
    }
}
