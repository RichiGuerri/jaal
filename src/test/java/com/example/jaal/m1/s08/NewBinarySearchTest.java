package com.example.jaal.m1.s08;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NewBinarySearchTest {
    private final int[] values = { -55, -44, -21, -8, 0, 12, 27, 51, 93, 115, 220 };

    @ParameterizedTest
    @CsvSource({ "12, 5", "93, 8", "115, 9" })
    void iterativePlain(int target, int expected) {
        assertThat(NewBinarySearch.iterative(values, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = { -56, -54, -1, 1, 219, 222 })
    void iterativeNotFound(int target) {
        assertThat(NewBinarySearch.iterative(values, target)).isEqualTo(-1);
    }

    @Test
    void iterativeEmpty() {
        assertThat(NewBinarySearch.iterative(new int[] {}, 42)).isEqualTo(-1);
    }

    @Test
    void iterativeNull() {
        assertThatNullPointerException().isThrownBy(() -> NewBinarySearch.iterative(null, 0));
    }
}
