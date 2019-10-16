package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplicationTests;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplicationTests.class)
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

    @Test
    public void Gdelete()
    {
    }
}