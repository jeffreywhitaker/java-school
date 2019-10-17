package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.view.CountStudentsInCourses;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService
{
    List<Course> findAll();

    Course findCourseById(long id);

    List<Course> findAllPageable(Pageable pageable);

    List<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

    Course save (Course course);
}
