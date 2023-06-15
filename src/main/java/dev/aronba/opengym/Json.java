package dev.aronba.opengym;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Json {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);


    }

    //Todo: "Save Workout to Json"
    public static void saveWorkoutToJson(Workout workout){
        for (Exercise e: workout.exercises){
            // save shit to json
            // e.getName = name of exercise
            // e.sets = list of exercies
            return;

        }
    }
}
