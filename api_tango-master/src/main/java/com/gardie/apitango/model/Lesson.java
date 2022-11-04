package com.gardie.apitango.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name = "lessons")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="lesson_name")
    private String lessonName;

    private String description;

    @Column(name="lesson_date")
    private Date lessonDate;

    @Column(name="lesson_time")
    private String lessonTime;
    
    @Column(name="dance_level")
    private String danceLevel;
    
    private Integer price;

    @ManyToMany(mappedBy = "followedLessons")
    private List<Dancer> attendees = new ArrayList<>();


}
