package com.jaafarfora.hospital_simulator;

import com.jaafarfora.hospital_simulator.enums.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final short MINIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS = 1;
    private static final short MAXIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS = 2;
    private static List<String> statesInput = new ArrayList<>();
    private static List<String> drugsInput = new ArrayList<>();

    public static void main(String[] args) {
        extractStatesAndDrugs(args);
        InputsValidator.validate(statesInput, drugsInput);
        Map<State, Integer> statesResult = HealthStateCalculator.calculateState(statesInput, drugsInput);
        displayResult(statesResult);
    }

    private static void extractStatesAndDrugs(String[] args) {
        if (args.length != MINIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS && args.length != MAXIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS) {
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

