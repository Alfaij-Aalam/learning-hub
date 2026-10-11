package com.learninghub.learninghub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private String youtubePlaylistUrl;
    
    @Column(length = 2000)
    private String basicPrograms;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Subject() {}

    public Subject(String subjectName, String youtubePlaylistUrl, String basicPrograms, Course course) {
        this.subjectName = subjectName;
        this.youtubePlaylistUrl = youtubePlaylistUrl;
        this.basicPrograms = basicPrograms;
        this.course = course;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public String getYoutubePlaylistUrl() { return youtubePlaylistUrl; }
    public void setYoutubePlaylistUrl(String youtubePlaylistUrl) { this.youtubePlaylistUrl = youtubePlaylistUrl; }

    public String getBasicPrograms() { return basicPrograms; }
    public void setBasicPrograms(String basicPrograms) { this.basicPrograms = basicPrograms; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}