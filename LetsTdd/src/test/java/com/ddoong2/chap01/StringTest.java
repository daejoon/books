package com.ddoong2.chap01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    void substring() {
        String str = "adcdd";

        assertEquals("cd", str.substring(2, 4));
    }
}
