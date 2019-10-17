package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import com.lambdaschool.school.exceptions.ResourceNotFoundException;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceImplTest
{
    @Autowired
    private CourseService courseService;

    @Before
    public void AsetUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void BtearDown() throws Exception
    {
    }

    @Test
    public void CfindAll()
    {
    }

    @Test
    public void DfindAllPageable()
    {
    }

    @Test
    public void EgetCountStudentsInCourse()
    {
    }

    @Test
    public void FfindCourseById()
    {
        assertEquals("T Data Science", courseService.findCourseById(1).getCoursename());
    }

    @Test (expected = ResourceNotFoundException.class)
    public void FdeleteNotFound()
    {
        courseService.delete(100);
        assertEquals(6, courseService.findAll().size());
    }


    @Test
    public void GdeleteFound()
    {
        courseService.delete(6);
        assertEquals(5, courseService.findAll().size());
    }

    @Test
    public void Gdelete()
    {
    }

    @Test
    public void save()
    {
        Course c1 = new Course("T Course");

        Course addCourse = courseService.save(c1);

        assertNotNull(addCourse);

        Course foundCourse = courseService.findCourseById(addCourse.getCourseid());

        assertEquals(addCourse.getCoursename(), foundCourse.getCoursename());
    }
}