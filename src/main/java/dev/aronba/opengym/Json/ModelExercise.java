package dev.aronba.opengym.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ModelExercise  {
    static int workoutcount;



    @JsonProperty
    private String name;
    @JsonProperty
    private List<String> sets;



    public void setName(String name) {
        this.name = name;
    }

    public void setSets(List<String> sets) {
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public List<String> getSets() {
        return sets;
    }
}
