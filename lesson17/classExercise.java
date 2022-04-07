package lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class classExercise {
    public RequestSpecification request;
    public Response response;
    public JSONObject parameters = new JSONObject();
    List<String> courses = new ArrayList<String>();

    String baseURL = "http://localhost:9000";

    @BeforeClass
    public void startSession() {
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");

    }

    @Test
    public void createNewStudent() {

        parameters.put("firstName", "Bar");
        parameters.put("lastName", "Gelman");
        parameters.put("email", "bar.gelman@gmail.com");
        parameters.put("programme", "Programmer");

        request.body(parameters.toJSONString());
        response = request.post("/student");
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201);
    }

    @Test
    public void createStudentWithCourses() {

        courses.add("Java Course");
        courses.add("CSharp Course");
        courses.add("Python Course");

        parameters.put("firstName", "Mila");
        parameters.put("lastName", "Gelman");
        parameters.put("email", "mila.gelman@gmail.com");
        parameters.put("programme", "UI Designer");
        parameters.put("courses", "Software Development");
        parameters.put("courses", "Human Behavior");
        parameters.put("courses", courses);
        request.body(parameters.toJSONString());
        response = request.post("/student");
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201);
    }

    @Test
    public void updateParameters() {
        parameters.put("firstName", "Bar");
        parameters.put("lastName", "Gelman");
        parameters.put("email", "bar.gelman@gmail.com");
        parameters.put("programme", "Automation Developer");

        request.body(parameters.toJSONString());
        response = request.put("/student/101");
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void deleteStudent() {
        response = request.delete("/student/101");
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 204);
    }
}
