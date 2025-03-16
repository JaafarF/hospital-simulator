package com.jaafarfora.hospital_simulator;

import com.jaafarfora.hospital_simulator.enums.Drug;
import com.jaafarfora.hospital_simulator.enums.State;

import java.util.Arrays;
import java.util.List;

public class InputsValidator {
    static List<String> states = Arrays.stream(State.values()).map(Enum::toString).toList();
    static List<String> drugs = Arrays.stream(Drug.values()).map(Enum::toString).toList();

    public static void validate(List<String> statesInput, List<String> drugsInput) {

        for (String state : statesInput) {
            if (!states.contains(state)) {
                throw new RuntimeException("A health state is wrong");
            }
        }

        for (String drug : drugsInput) {
            if (!drugs.contains(drug)) {
                throw new RuntimeException("A drug is wrong");
            }
        }
    }
}
