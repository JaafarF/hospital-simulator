package com.jaafarfora.hospital_simulator;

import com.jaafarfora.hospital_simulator.enums.Drug;
import com.jaafarfora.hospital_simulator.enums.State;
import com.jaafarfora.hospital_simulator.exceptions.InvalidInputException;

import java.util.Arrays;
import java.util.List;

public class InputsValidator {
    private static final List<String> states = Arrays.stream(State.values()).map(Enum::toString).toList();
    private static final List<String> drugs = Arrays.stream(Drug.values()).map(Drug::getId).toList();

    public void validate(List<String> statesInput, List<String> drugsInput) throws InvalidInputException {
        for (String state : statesInput) {
            if (!states.contains(state)) {
                throw new InvalidInputException("One or more health state inputs are wrong");
            }
        }
        for (String drug : drugsInput) {
            if (!drugs.contains(drug)) {
                throw new InvalidInputException("One or more drug inputs are wrong");
            }
        }
    }
}
