package dev.aronba.opengym;

import com.fasterxml.jackson.databind.JsonNode;
import dev.aronba.opengym.Json.Json;
import junit.framework.TestCase;

import java.io.IOException;

public class JsonTest extends TestCase {

    public void testParse() throws IOException {
        String testcase = "{\"title\": \"TestCase\"}";
        JsonNode node = Json.parse(testcase);
        assertEquals(node.get("title").asText(),"TestCase");
    }
}