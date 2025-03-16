package com.jaafarfora.hospital_simulator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputsValidatorTest {

    @Test
    void healthStatesShouldBeValid() {
        //Given
        List<String> stateInputs = List.of("F", "S");
        List<String> drugInputs = List.of("P");

        //When-Then
        assertThatThrownBy(() -> InputsValidator.validate(stateInputs, drugInputs))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("A health state is wrong");
    }

    @Test
    void allDrugsShouldBeValid() {
        //Given
        List<String> stateInputs = List.of("F", "D");
        List<String> drugInputs = List.of("W");

        //When-Then
        assertThatThrownBy(() -> InputsValidator.validate(stateInputs, drugInputs))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("A drug is wrong");
    }
}
