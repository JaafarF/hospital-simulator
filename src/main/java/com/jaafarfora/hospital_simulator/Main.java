package com.jaafarfora.hospital_simulator;

import com.jaafarfora.hospital_simulator.enums.Drug;
import com.jaafarfora.hospital_simulator.enums.State;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Main {

    static List<String> statesInput = new ArrayList<>();
    static List<String> drugsInput = new ArrayList<>();
    static Map<State, Integer> statesResult = new LinkedHashMap<>();

    public static void main(String[] args) {

        extractStatesAndDrugs(args);
        InputsValidator.validate(statesInput, drugsInput);
        statesResult = HealthStateCalculator.calculateState(statesInput, drugsInput);
        displayResult(statesResult);
    }

    private static void extractStatesAndDrugs(String[] args) {
        if (args.length != 1 && args.length != 2) {
            throw new RuntimeException("You provided an invalid number of arguments, 1 or 2 parts are required");
        }
        statesInput = List.of(args[0].split(","));
        if (args.length == 2) {
            drugsInput = List.of(args[1].split(","));
        }
    }

    private static void displayResult(Map<State, Integer>  statesResult) {
        List<String> list = new ArrayList<>();
        statesResult.forEach((state, integer) -> list.add(state.toString() + ":" + integer));
        String result = String.join(",", list);
        System.out.println(result);
    }
}

