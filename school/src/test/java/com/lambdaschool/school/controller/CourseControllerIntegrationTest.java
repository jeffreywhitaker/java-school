package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.model.Student;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.number.OrderingComparison.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerIntegrationTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initialiseRestAssuredMockMvcWebApplicationContext()
    {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    //    GET /restaurants/restaurants
    @Test
    public void whenMeasuredReponseTime()
    {
        given().when().get("/courses/courses").then().time(lessThan(5000L));
    }

    @Test
    public void addNewCourse() throws Exception
    {
        Course c1 = new Course("Test Course");

        Instructor i1 = new Instructor();
        i1.setInstructid(0);
        i1.getCourses().add(c1);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(c1);

        given().contentType("application/json").body(s).when().post("/courses/course/add").then().statusCode(201);
    }
//    //    POST /restaurants/restaurant
//    @Test
//    public void givenPostARestaurant() throws Exception
//    {
//        ArrayList<RestaurantPayments> thisPay = new ArrayList<>();
//        String rest3Name = "Number 1 Test Eats";
//        Restaurant r3 = new Restaurant(rest3Name, "565 Side Test Avenue", "Village", "ST", "555-123-1555", thisPay);
//        r3.getMenus().add(new Menu("Pizza", 15.15, r3));
//
//        ObjectMapper mapper = new ObjectMapper();
//        String stringR3 = mapper.writeValueAsString(r3);
//
//        given().contentType("application/json").body(stringR3).when().post("/restaurants/restaurant").then().statusCode(201);
//    }
//
//
//    //    GET /restaurants/restaurant/{restaurantId}
//    @Test
//    public void givenFoundRestaurantId() throws Exception
//    {
//        long aRestaurant = 10L;
//
//        given().when().get("/restaurants/restaurant/" + aRestaurant).then().statusCode(200).and().body(containsString("Bird"));
//    }
//
//
//    //    GET /restaurants/restaurant/name/{name}
//    @Test
//    public void givenFoundRestaurantName() throws Exception
//    {
//        String aRestaurant = "Apple";
//
//        given().when().get("/restaurants/restaurant/name/" + aRestaurant).then().statusCode(200).and().body(containsString("Apple"));
//    }
//
//
//    //    GET /restaurants/restaurants
//    @Test
//    public void givenFindAllRestaurants()
//    {
//        given().when().get("/restaurants/restaurants").then().statusCode(200).and().body(containsString("Apple"));
//    }
//
//
//    //    PUT /restaurants/restaurant/{restaurantid}
//    @Test
//    public void givenUpdateARestaurant() throws Exception
//    {
//        ArrayList<RestaurantPayments> thisPay = new ArrayList<>();
//        Restaurant r1 = new Restaurant(null,
//                null,
//                null, "ZZ", null,
//                thisPay);
//        r1.setRestaurantid(10);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String stringR1 = mapper.writeValueAsString(r1);
//
//        given().contentType("application/json").body(stringR1).when().put("/restaurants/restaurant/10").then().statusCode(200);
//    }
//
//
//    //    DELETE /restaurants/restaurant/{restaurantid}
//    //    at the end so I can use restaurant 10 in examples!
//    @Test
//    public void givenDeleteARestaurant()
//    {
//        long aRestaurant = 10L;
//        given().when().delete("/restaurants/restaurant/" + aRestaurant).then().statusCode(200);
//    }
}
