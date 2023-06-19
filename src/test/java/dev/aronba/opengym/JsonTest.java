package dev.aronba.opengym;

import com.fasterxml.jackson.databind.JsonNode;
import dev.aronba.opengym.Json.Json;
import dev.aronba.opengym.Json.ModelExercise;
import junit.framework.Test;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTest extends TestCase {

    public void testParse() throws IOException {
        String testcase = "{\"title\": \"TestCase\"}";
        JsonNode node = Json.parse(testcase);
        assertEquals(node.get("title").asText(),"TestCase");
    }
    public void testReadWorkoutFromJson(){
         List<ModelExercise> result = Json.readWorkoutFromJson(new File(""));
        assertTrue(result.isEmpty());
    }

}