package com.jaafarfora.hospital_simulator;

import com.jaafarfora.hospital_simulator.enums.State;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthStateCalculatorTest {

    @Test
    void AspirinMixedWithParacetamolshouldKillPatient() {
        //Given
        List<String> stateInputs = new ArrayList<>(Arrays.asList("F","D"));
        List<String> drugInputs = new ArrayList<>(Arrays.asList("As","P"));

        // When
        var result = HealthStateCalculator.calculateState(stateInputs, drugInputs);

        // Then
        assertThat(result).containsEntry(State.X, 2);
    }
}
