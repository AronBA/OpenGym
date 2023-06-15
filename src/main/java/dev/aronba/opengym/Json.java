package dev.aronba.opengym;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Json {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);


    }


    public static void saveWorkoutToJson(Workout workout){

        Instant timestamp = Instant.now();
        List<ModelExercise> exerciseList = new ArrayList<>();

        for (Exercise exercise : workout.exercises){

            ModelExercise m = new ModelExercise();
            m.setName(exercise.getExerciseName());
            m.setSets(exercise.getSetsAsList());
            exerciseList.add(m);
        }

        try {

            getObjectMapper().writeValue(new File("Workouts/wk-"+timestamp + ".json"),exerciseList);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
