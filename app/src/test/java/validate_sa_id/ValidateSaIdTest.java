package validate_sa_id;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidateSaIdTest
{
    @Test
    void validIdReturnsTrue()
    {
        assertTrue(ValidateSaId.isIdNumberValid("8001015009087")); // Example valid ID
    }

    @Test
    void shortIdReturnsFalse()
    {
        assertFalse(ValidateSaId.isIdNumberValid("1234567890"));
    }

    @Test
    void nonNumericIdReturnsFalse()
    {
        assertFalse(ValidateSaId.isIdNumberValid("800101ABC9087"));
    }

    @Test
    void invalidChecksumReturnsFalse()
    {
        assertFalse(ValidateSaId.isIdNumberValid("8001015009086")); // Invalid checksum
    }

    @Test
    void testExtractDateOfBirth()
    {
        String id = "9001014800081"; // 01 Jan 1990
        String expectedDob = "1990-01-01";
        String actualDob = ValidateSaId.extractDateOfBirth(id);
        assertEquals(expectedDob, actualDob);
    }

    @Test
    void testGenderDetection()
    {
        assertEquals("Male", ValidateSaId.getGender("8001015009087"));
        assertEquals("Female", ValidateSaId.getGender("8001010009086"));
    }

    @Test
    void testCitizenshipDetection()
    {
        assertEquals("SA Citizen", ValidateSaId.getCitizenship("8001015009087"));  // 0 => SA Citizen
        assertEquals("Permanent Resident", ValidateSaId.getCitizenship("8001015009186"));  // 1 => PR
    }

    @Test
    void testLuhnChecksumCalculation()
    {
        String first12Digits = "800101500908"; // Valid example, check digit should be 7
        int expectedChecksum = 7;
        int actualChecksum = ValidateSaId.calculateLuhnChecksum(first12Digits);
        assertEquals(expectedChecksum, actualChecksum);
    }

    @Test
    void testInvalidDateExtraction()
    {
        String id = "9902304800082"; // Invalid date (Feb 30)
        String dob = ValidateSaId.extractDateOfBirth(id);
        assertNull(dob);
    }

    @Test
    void testNullIdReturnsFalse()
    {
        assertFalse(ValidateSaId.isIdNumberValid(null));
    }

    @Test
    void testEmptyIdReturnsFalse()
    {
        assertFalse(ValidateSaId.isIdNumberValid(""));
    }

    @Test
    void testInvalidCitizenshipDigit()
    {
        String id = "8001015009287"; // Digit 11 is 2 (invalid citizenship)
        String citizenship = ValidateSaId.getCitizenship(id);
        assertEquals("Permanent Resident", citizenship); // Still works as per current logic
    }
}