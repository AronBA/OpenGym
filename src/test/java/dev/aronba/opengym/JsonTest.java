package dev.aronba.opengym;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class JsonTest extends TestCase {

    public void testParse() throws IOException {
        String testcase = "{\"title\": \"TestCase\"}";
        JsonNode node = Json.parse(testcase);
        assertEquals(node.get("title").asText(),"TestCase");
    }
}