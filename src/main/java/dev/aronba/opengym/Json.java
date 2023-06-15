package dev.aronba.opengym;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Json {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
    public static JsonNode parse(String src) throws IOException{
        return objectMapper.readTree(src);

    }
}
