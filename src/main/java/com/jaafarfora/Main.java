package com.jaafarfora;

import java.util.*;

public class Main {

    static List<String> statesInput = new ArrayList<>();
    static List<String> drugsInput = new ArrayList<>();
    static Map<State, Integer> statesResult = new LinkedHashMap<>();
    static List<String> states = Arrays.stream(State.values()).map(Enum::toString).toList();
    static List<String> drugs = Arrays.stream(Drug.values()).map(Enum::toString).toList();

    public static void main(String[] args) {
        validateInput(args);
        statesResult = calculateState(statesInput, drugsInput);
        displayResult(statesResult);
    }

    public static void validateInput(String[] inputs) {
        if (inputs.length == 0 || inputs.length > 2) {
            throw new RuntimeException("Inputs number is wrong");
        }
        statesInput = List.of(inputs[0].split(","));

        if (inputs.length == 2) {
            drugsInput = List.of(inputs[1].split(","));
        }

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

    public static Map<State, Integer> calculateState(List<String> statesInput, List<String> drugsInput) {
        Map<State, Integer> result = new LinkedHashMap<>();
        result.put(State.F, 0);
        result.put(State.H, 0);
        result.put(State.D, 0);
        result.put(State.T, 0);
        result.put(State.X, 0);

        if (drugsInput.contains(Drug.As.toString()) && drugsInput.contains(Drug.P.toString())) {
            result.replace(State.X, statesInput.size());
            return result;
        }
        for (String state : statesInput) {
            if (state.equals(State.D.toString())) {
                if (!drugsInput.contains(Drug.I.toString())) {
                    result.replace(State.X, result.get(State.X) + 1);
                } else {
                    result.replace(State.D, result.get(State.D) + 1);
                }
            }
            if (state.equals(State.F.toString())) {
                if (drugsInput.contains(Drug.P.toString()) || drugsInput.contains(Drug.As.toString())) {
                    result.replace(State.H, result.get(State.H) + 1);
                } else {
                    result.replace(State.F, result.get(State.F) + 1);
                }
            }
            if (state.equals(State.T.toString())) {
                if (drugsInput.contains(Drug.An.toString())) {
                    result.replace(State.H, result.get(State.H) + 1);
                } else {
                    result.replace(State.T, result.get(State.T) + 1);
                }
            }
            if (state.equals(State.H.toString())) {
                if (drugsInput.contains(Drug.I.toString()) || drugsInput.contains(Drug.An.toString())) {
                    result.replace(State.F, result.get(State.F) + 1);
                } else {
                    result.replace(State.H, result.get(State.H) + 1);
                }
            }

        }
        return result;
    }

    public static void displayResult(Map<State, Integer>  statesResult) {
        List<String> list = new ArrayList<>();
        statesResult.forEach((state, integer) -> list.add(state.toString() + ":" + integer));
        String result = String.join(",", list);
        System.out.println(result);
    }
}

enum State {
    F, H, D, T, X
}
enum Drug {
    As, An, I, P
}