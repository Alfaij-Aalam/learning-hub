package com.learninghub.learninghub.service;

import com.learninghub.learninghub.dto.CourseDto;
import com.learninghub.learninghub.entity.Course;
import com.learninghub.learninghub.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // <-- YE ANNOTATION HONA ZAROORI HAI
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseDto createCourse(CourseDto dto) {
        Course course = new Course(dto.getTitle(), dto.getDescription(), dto.getPrice());
        Course saved = courseRepository.save(course);
        return new CourseDto(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getPrice());
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(c -> new CourseDto(c.getId(), c.getTitle(), c.getDescription(), c.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}