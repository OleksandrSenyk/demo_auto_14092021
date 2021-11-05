package api.conditions;

import io.restassured.response.ResponseBody;
import org.hamcrest.Matcher;

public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static ResponseBodyCondition body(String path, Matcher matcher) {
        return new ResponseBodyCondition(path, matcher);
    }
}
