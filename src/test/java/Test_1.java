import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_1 {

    @Test
    public void test_1() {

        List<Users> persons =
                given()
                        .when()
                        .get("https://jsonplaceholder.typicode.com/users")
                        .then()
                        .extract()
                        .body()
                        .jsonPath().getList(".", Users.class);
        for (Users pers : persons
        ) {
            System.out.println(pers.name);
        }
    }
}


/*


    }


 */









