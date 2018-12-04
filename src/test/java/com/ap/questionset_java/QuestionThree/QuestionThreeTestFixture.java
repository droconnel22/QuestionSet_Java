package com.ap.questionset_java.QuestionThree;


import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionThreeTestFixture {

    @Test
    public void Map_JsonSchema_To_JsonObject() throws Exception {
        // Arrange
        String input = JsonMapperTestUtility.GetExampleInput();
        String schema = JsonMapperTestUtility.GetExampleSchema();
        String expected = JsonMapperTestUtility.GetExpectedJson();

        // Act
        String actual = JsonMapper.Map(input, schema);

        // Assert
        assertEquals(expected, actual);
    }
}

class JsonMapperTestUtility {

    public static String GetExampleInput() throws JSONException {
        return new JSONObject()
                .put("Name", "Hello")
                .put("This", new JSONObject()
                        .put("That", new JSONObject()
                            .put("TheOther", "There"))
                ).toString();
    }

    public  static  String GetExampleSchema() throws JSONException {
        return new JSONObject()
                .put("Test_Name", "Name")
                .put("Test_Value", "This.That.TheOther")
                .toString();
    }

    public static String GetExpectedJson() throws  JSONException {
        return  new JSONObject()
                .put("Test_Name","Hello")
                .put("Test_Value", "There")
                .toString();
    }
}
