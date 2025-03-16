package com.jaafarfora.hospital_simulator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MainTest {

    @Test
    void inputShouldNotBeEmpty() {
        //Given
        String[] inputs = new String[] {};

        //When-Then
        assertThatThrownBy(() -> Main.main(inputs))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("You provided an invalid number of arguments, 1 or 2 parts are required");
    }
}
