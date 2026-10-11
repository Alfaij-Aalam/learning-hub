package com.learninghub.learninghub.service;

import com.learninghub.learninghub.dto.CourseDto;
import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);
    List<CourseDto> getAllCourses();
    void deleteCourse(Long id);
}