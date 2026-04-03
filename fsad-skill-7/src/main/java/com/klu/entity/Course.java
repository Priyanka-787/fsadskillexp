package com.klu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_s5")
public class Course 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseid")
    private Long courseId;

    @Column(name = "coursetitle")
    private String title;

    @Column(name = "courseduration")
    private String duration;

    @Column(name = "coursefee")
    private double fee;

    public Long getCourseId() 
    {
        return courseId;
    }

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getDuration() 
    {
        return duration;
    }

    public void setDuration(String duration) 
    {
        this.duration = duration;
    }

    public double getFee() 
    {
        return fee;
    }

    public void setFee(double fee) 
    {
        this.fee = fee;
    }

    @Override
    public String toString() 
    {
        return "Course [courseId=" + courseId + ", title=" + title + ", duration=" + duration + ", fee=" + fee + "]";
    }
}