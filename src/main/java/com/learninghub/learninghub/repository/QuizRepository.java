package com.learninghub.learninghub.repository;

import com.learninghub.learninghub.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Course, Long> {
}