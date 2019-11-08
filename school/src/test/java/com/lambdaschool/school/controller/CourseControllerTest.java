package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class, secure = false)
public class CourseControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    List<Course> courseList;

    @Before
    public void setUp() throws Exception
    {
        courseList = new ArrayList<>();

        Instructor i1 = new Instructor("Jeff");
        i1.setInstructid(0);

        Instructor i2 = new Instructor("John Mitchell");
        i2.setInstructid(1);

        Course c1 = new Course("Java");
        Course c2 = new Course("Javascript");
        Course c3 = new Course("Python");

        c1.setCourseid(0);
        c2.setCourseid(1);
        c3.setCourseid(2);

        c1.setInstructor(i1);
        c2.setInstructor(i2);
        c3.setInstructor(i2);

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void listAllCourses() throws Exception
    {
        String apiUrl = "/courses/courses";

        Mockito.when(courseService.findAllPageable(Mockito.any(Pageable.class))).thenReturn(courseList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        // the following actually performs a real controller call
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(courseList);

        assertEquals("Rest API Returns List", er, tr);

    }

    @Test
    public void getCountStudentsInCourses()
    {
    }

    @Test
    public void deleteCourseById()
    {
    }
}