package dev.aronba.opengym.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aronba.opengym.History.HistoryPage;
import dev.aronba.opengym.Settings;
import dev.aronba.opengym.Window;
import dev.aronba.opengym.Workout.Exercise;
import dev.aronba.opengym.Workout.Workout;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Json {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static List<ModelExercise> readWorkoutFromJson(File file){

        try {
            return objectMapper.readValue(file, new TypeReference<List<ModelExercise>>() {});
        } catch (IOException ignored) {
            return new ArrayList<>();
        }
    }
    public static void saveWorkoutToJson(Workout workout){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
        String timestamp = now.format(formatter);

        List<ModelExercise> exerciseList = new ArrayList<>();

        for (dev.aronba.opengym.Workout.Exercise exercise : workout.getExercises()){

            ModelExercise m = new ModelExercise();
            m.setName(exercise.getExerciseName());
            m.setSets(exercise.getSetsAsList());
            exerciseList.add(m);
        }

        try {
            getObjectMapper().writeValue(new File(Settings.workoutFolder + "/" + timestamp + ".json"),exerciseList);
            HistoryPage.loadFiles();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
