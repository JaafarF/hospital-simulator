package com.jaafarfora;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MainTest {

    @Test
    void inputShouldNotBeEmpty() {
        //Given
        String[] inputs = new String[] {};

        //When-Then
        assertThatThrownBy(() -> Main.validateInput(inputs))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Inputs number is wrong");
    }

    @Test
    void inputsShouldNotExceedTwoInputs() {
        //Given
        String[] inputs = new String[] {"F,D", "P", "P" };

        //When-Then
        assertThatThrownBy(() -> Main.validateInput(inputs))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Inputs number is wrong");
    }

    @Test
    void healthStatesShouldBeValid() {
        //Given
        String[] inputs = new String[] {"F,S", "P" };

        //When-Then
        assertThatThrownBy(() -> Main.validateInput(inputs))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("A health state is wrong");
    }

    @Test
    void allDrugsShouldBeValid() {
        //Given
        String[] inputs = new String[] {"F,D", "W" };

        //When-Then
        assertThatThrownBy(() -> Main.validateInput(inputs))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("A drug is wrong");
    }
}
