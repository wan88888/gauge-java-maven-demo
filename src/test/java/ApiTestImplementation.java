import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiTestImplementation {
    private Response response;
    private RequestSpecification request;

    @Step("Set base URI to <baseUri>")
    public void setBaseUri(String baseUri) {
        RestAssured.baseURI = baseUri;
        request = given();
    }

    @Step("Send GET request to <path> with parameters: <table>")
    public void sendGetRequest(String path, Table params) {
        for (TableRow row : params.getTableRows()) {
            request.queryParam(row.getCell("parameter"), row.getCell("value"));
        }
        response = request.get(path);
    }

    @Step("Send POST request to <path> with JSON body: <table>")
    public void sendPostRequest(String path, Table jsonData) {
        JSONObject jsonBody = new JSONObject();
        for (TableRow row : jsonData.getTableRows()) {
            jsonBody.put(row.getCell("key"), row.getCell("value"));
        }
        response = request.body(jsonBody.toString())
                .header("Content-Type", "application/json")
                .post(path);
    }

    @Step("Verify response status code is <expectedCode>")
    public void verifyStatusCode(String expectedCode) {
        assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(expectedCode));
    }

    @Step("Verify response contains parameter <parameter> with value <value>")
    public void verifyResponseParameter(String parameter, String value) {
        String actualValue = response.jsonPath().getString("args." + parameter);
        assertThat(actualValue).isEqualTo(value);
    }

    @Step("Verify response contains JSON field <field> with value <value>")
    public void verifyJsonField(String field, String value) {
        String actualValue = response.jsonPath().getString(field);
        assertThat(actualValue).isEqualTo(value);
    }
}