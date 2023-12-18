package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mock.MockItem;

public class TestItem {

    private MockItem testSubject;

    @BeforeEach
    void setup() {
        // Initial setup for each test, can be modified as per test requirement
    }

    @Test
    @DisplayName("Convert Uppercase Strings to Lowercase")
    void whenGivenUppercaseString_thenCorrectlyConvertToLowercase() {
        testSubject = new MockItem("HELLO");
        String expected = "hello";
        assertEquals(expected, testSubject.getId(), "Expected lowercase transformation of string");
    }
    
    @Test
    @DisplayName("Handle Empty String Scenarios")
    void givenEmptyString_whenRetrieved_thenRemainsEmpty() {
        testSubject = new MockItem("");
        String expected = "";
        assertEquals(expected, testSubject.getId(), "Empty string should remain unchanged");
    }
    
    @Test
    @DisplayName("Preserve Numeric String Integrity")
    void givenNumericString_whenRetrieved_thenRemainsNumeric() {
        testSubject = new MockItem("123");
        String expected = "123";
        assertEquals(expected, testSubject.getId(), "Numeric strings should remain unchanged");
    }

    @Test
    @DisplayName("Throw Exception for Null ID Creation")
    void whenNullIDProvided_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MockItem(null), "Null ID should trigger NullPointerException");
    }
    
    @Test
    @DisplayName("String Representation of Numeric Values")
    void givenNumericString_whenConvertedToString_thenCorrect() {
        testSubject = new MockItem("123");
        String expected = "123";
        assertEquals(expected, testSubject.toString(), "String representation should match numeric input");
    }
    
    @Test
    @DisplayName("Lowercase Conversion in String Representation")
    void givenMixedCaseString_whenConvertedToString_thenLowercased() {
        testSubject = new MockItem("HELLO BODY");
        String expected = "hello body";
        assertEquals(expected, testSubject.toString(), "String representation should be lowercased");
    }
    
    @Test
    @DisplayName("Empty String Conversion to String Type")
    void givenEmptyString_whenConvertedToString_thenEmptyStringReturned() {
        testSubject = new MockItem("");
        String expected = "";
        assertEquals(expected, testSubject.toString(), "String representation of empty string should remain empty");
    }
    
    @Test
    @DisplayName("Set and Retrieve Lowercase ID")
    void whenIDSetToLowercase_thenCorrectlyRetrieved() {
        testSubject = new MockItem("HAPPY");
        testSubject.setId("happy");
        String expected = "happy";
        assertEquals(expected, testSubject.getId(), "Setting lowercase ID should be reflected in retrieval");
    }
    
    @Test
    @DisplayName("Set and Retrieve Empty String ID")
    void whenIDSetToEmpty_thenEmptyStringRetrieved() {
        testSubject = new MockItem("FRIENDS");
        testSubject.setId("");
        String expected = "";
        assertEquals(expected, testSubject.getId(), "Setting empty string ID should be retrievable as such");
    }
    
    @Test
    @DisplayName("Set and Retrieve Numeric String ID")
    void whenIDSetToNumericString_thenNumericStringRetrieved() {
        testSubject = new MockItem("Swedan");
        testSubject.setId("1111");
        String expected = "1111";
        assertEquals(expected, testSubject.getId(), "Setting numeric string ID should be retrievable as such");
    }
    
    @Test
    @DisplayName("Exception Handling for Null ID Assignment")
    void whenNullIDSet_thenExpectNullPointerException() {
        testSubject = new MockItem("Test");
        assertThrows(NullPointerException.class, () -> testSubject.setId(null), "Assigning null ID should trigger NullPointerException");
    }
}
