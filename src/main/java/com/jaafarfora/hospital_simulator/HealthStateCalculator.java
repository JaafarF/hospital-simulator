package com.jaafarfora.hospital_simulator;

import com.jaafarfora.hospital_simulator.enums.Drug;
import com.jaafarfora.hospital_simulator.enums.State;

import java.util.*;

public class HealthStateCalculator {

    Map<State, Integer> result;

    public HealthStateCalculator() {
        result = new LinkedHashMap<>();
        result.put(State.F, 0);
        result.put(State.H, 0);
        result.put(State.D, 0);
        result.put(State.T, 0);
        result.put(State.X, 0);
    }

    public Map<State, Integer> calculateState(List<String> statesInput, List<String> drugsInput) {
        if (drugsInput.contains(Drug.ASPIRIN.getId()) && drugsInput.contains(Drug.PARACETAMOL.getId())) {
            result.replace(State.X, statesInput.size());
            return result;
        }
        for (String state : statesInput) {
            if (state.equals(State.D.toString())) {
                if (!drugsInput.contains(Drug.INSULIN.getId())) {
                    result.replace(State.X, result.get(State.X) + 1);
                } else {
                    result.replace(State.D, result.get(State.D) + 1);
                }
            }
            if (state.equals(State.F.toString())) {
                if (drugsInput.contains(Drug.PARACETAMOL.getId()) || drugsInput.contains(Drug.ASPIRIN.getId())) {
                    result.replace(State.H, result.get(State.H) + 1);
                } else {
                    result.replace(State.F, result.get(State.F) + 1);
                }
            }
            if (state.equals(State.T.toString())) {
                if (drugsInput.contains(Drug.ANTIBIOTIC.getId())) {
                    result.replace(State.H, result.get(State.H) + 1);
                } else {
                    result.replace(State.T, result.get(State.T) + 1);
                }
            }
            if (state.equals(State.H.toString())) {
                if (drugsInput.contains(Drug.INSULIN.getId()) || drugsInput.contains(Drug.ANTIBIOTIC.getId())) {
                    result.replace(State.F, result.get(State.F) + 1);
                } else {
                    result.replace(State.H, result.get(State.H) + 1);
                }
            }

        }
        return result;
    }
}
