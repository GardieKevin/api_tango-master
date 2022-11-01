package com.gardie.apitango.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "dancers")
public class Dancer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;
    
    @Column(name="dance_level")
    private String danceLevel;
    
    private String telephone;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "followed_lessons",
            joinColumns = @JoinColumn(name = "dancer_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private List<Lesson> followedLessons = new ArrayList<>();

}
