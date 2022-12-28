package com.stefanpetcu.anagramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramFilterImplTest {

    private AnagramFilter testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new AnagramFilterImpl();
    }

    @Test
    public void filterAnagrams_willReturnAppealAndAppexl_givenInputsAppleAndAppealAndAppexl() {
        List<String> result = testSubject.filterAnagrams("Apple", "Appeal", "Appexl");

        assertEquals(2, result.size());
        assertTrue(result.contains("Appeal"));
        assertTrue(result.contains("Appexl"));
    }
}
