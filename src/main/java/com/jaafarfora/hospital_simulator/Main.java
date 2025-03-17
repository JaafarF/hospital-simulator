package com.jaafarfora.hospital_simulator;

import com.jaafarfora.hospital_simulator.enums.State;
import com.jaafarfora.hospital_simulator.exceptions.InvalidInputException;
import com.jaafarfora.hospital_simulator.utlis.LoggerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final short MINIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS = 1;
    private static final short MAXIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS = 2;
    private static List<String> statesInput = new ArrayList<>();
    private static List<String> drugsInput = new ArrayList<>();

    public static void main(String[] args) {
        try {
            extractStatesAndDrugs(args);
            InputsValidator validator = new InputsValidator();
            validator.validate(statesInput, drugsInput);
            HealthStateCalculator calculator = new HealthStateCalculator();
            Map<State, Integer> statesResult = calculator.calculateState(statesInput, drugsInput);
            displayResult(statesResult);
        } catch (InvalidInputException e) {
            LoggerUtil.logError(e.getMessage());
        }
    }

    public static void extractStatesAndDrugs(String[] args) throws InvalidInputException {
        if (args.length != MINIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS && args.length != MAXIMUM_EXPECTED_AMOUNT_OF_ARGUMENTS) {
            throw new InvalidInputException("You provided an invalid number of arguments, 1 or 2 parts are required");
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

