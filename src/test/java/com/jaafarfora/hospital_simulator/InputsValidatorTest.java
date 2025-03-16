package com.jaafarfora.hospital_simulator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputsValidatorTest {

    @Test
    void healthStatesShouldBeValid() {
        //Given
        List<String> stateInputs = List.of("F", "S");
        List<String> drugInputs = List.of("P");
        InputsValidator validator = new InputsValidator();

        //When-Then
        assertThatThrownBy(() -> validator.validate(stateInputs, drugInputs))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("A health state is wrong");
    }

    @Test
    void allDrugsShouldBeValid() {
        //Given
        List<String> stateInputs = List.of("F", "D");
        List<String> drugInputs = List.of("W");
        InputsValidator validator = new InputsValidator();

        //When-Then
        assertThatThrownBy(() -> validator.validate(stateInputs, drugInputs))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("A drug is wrong");
    }
}
