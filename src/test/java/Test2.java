import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.Users;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Test2 {


/*
    private static String body =(" {\n" +
            "        \"id\": 11,\n" +
            "        \"name\": \"Leandro Mancini\",\n" +
            "        \"username\": \"Bretting\",\n" +
            "        \"email\": \"Sionkathy@april.biz\",\n" +
            "        \"address\": {\n" +
            "            \"street\": \"via montevalderoa\",\n" +
            "            \"suite\": \"Apt. 556\",\n" +
            "            \"city\": \"milagro\",\n" +
            "            \"zipcode\": \"92998-3874\",\n" +
            "            \"geo\": {\n" +
            "                \"lat\": \"-37.3159\",\n" +
            "                \"lng\": \"81.1496\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"phone\": \"3395397763\",\n" +
            "        \"website\": \"hildegard.org\",\n" +
            "        \"company\": {\n" +
            "            \"name\": \"Romaguera-Crona\",\n" +
            "            \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
            "            \"bs\": \"harness real-time e-markets\"\n" +
            "        }\n" +
            "    }");

 */

public JSONObject createJson () {
    JSONObject data=new JSONObject();
    data.put("id",11);
    data.put("name","Leandro");
    data.put("surname","mancini");
    data.put("email","Sionkathy@april.biz");
    data.put("address.street","Via MonteValderoa");
    data.put("address.suite","Apt. 556");
    data.put("address.city","Milagro");
    data.put("address.zipcode",92998-3874);
    data.put("address.geo.lat",-37.3159);
    data.put("address.geo.lng",81.1496);
    data.put("phone","3395397763");
    data.put("website","hildegard.org");
    data.put("company.name","Barreto-Annabel");
    data.put("bs","e-commerce pharmaceutical products");

return data;

}




    @Test
    public void test2() {

            List<Users> persons2 =
                    Arrays.asList(given()
                            .contentType(ContentType.JSON)
                            .when()
                            .get("https://jsonplaceholder.typicode.com/users")
                            .as(Users[].class));
           for (Users pers:persons2
            ) {
                System.out.println(pers.username);
                System.out.println(pers.name);
            }
            Assertions.assertEquals("Leanne Graham",persons2.get(0).name);



        Response response =
                given()
                  .header("Content-type", "application/json")
                  .body(createJson().toString())
                .when()
                  .post("https://jsonplaceholder.typicode.com/users")
                .then()
                  .extract()
                  .response();
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        System.out.println(createJson().toString());
        Assertions.assertEquals(11, response.jsonPath().getInt("id"));
        Assertions.assertEquals("Leandro", response.jsonPath().getString("name"));
        Assertions.assertEquals("hildegard.org", response.jsonPath().getString("website"));


    }
}


