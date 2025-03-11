package com.jaafarfora;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void AspirinMixedWithParacetamolshouldKillPatient() {
        //Given
        List<String> stateInputs = new ArrayList<>(Arrays.asList("F","D"));
        List<String> drugInputs = new ArrayList<>(Arrays.asList("As","P"));

        // When
        var result = Main.calculateState(stateInputs, drugInputs);

        // Then
        assertThat(result).containsEntry(State.X, 2);
    }
}
