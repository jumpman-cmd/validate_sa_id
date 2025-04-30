package validate_sa_id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidateSaId
{
    /**
     * Validates a South African ID number.
     * Rules:
     * - Must be 13 digits
     * - Use Luhn algorithm to validate the checksum
     */

    public static boolean isIdNumberValid(String id)
    {
        if (id == null || !id.matches("\\d{13}"))
        {
            return false;
        }

        // Luhn algorithm
        int sum = 0;
        for (int i = 0; i < 13; i++)
        {
            int digit = Character.getNumericValue(id.charAt(i));

            if ((i % 2) == 1)
            {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }

            sum += digit;
        }

        return (sum % 10) == 0;
    }

    public static String extractDateOfBirth(String id)
    {
        if (id == null || !id.matches("\\d{13}")) return null;

        String year = id.substring(0, 2);
        String month = id.substring(2, 4);
        String day = id.substring(4, 6);

        int yearInt = Integer.parseInt(year);
        String fullYear = (yearInt <= 24) ? "20" + year : "19" + year;

        String dateString = String.format("%s-%s-%s", fullYear, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withResolverStyle(ResolverStyle.STRICT);

        try
        {
            LocalDate.parse(dateString, formatter);
            return dateString;
        }

        catch (DateTimeParseException e)
        {
            return null;
        }
    }

    public static String getGender(String id)
    {
        if (id.length() != 13 || !id.matches("\\d{13}"))
        {
            throw new IllegalArgumentException("Invalid ID number");
        }

        int genderCode = Integer.parseInt(id.substring(6, 10));
        return genderCode < 5000 ? "Female" : "Male";
    }

    public static String getCitizenship(String id)
    {
        char citizenshipDigit = id.charAt(10);
        return (citizenshipDigit == '0') ? "SA Citizen" : "Permanent Resident";
    }

    public static int calculateLuhnChecksum(String idWithoutLastDigit)
    {
        if (!idWithoutLastDigit.matches("\\d{12}"))
        {
            throw new IllegalArgumentException("ID must be 12 digits to calculate checksum");
        }

        int sum = 0;

        for (int i = 0; i < idWithoutLastDigit.length(); i++)
        {
            int digit = Character.getNumericValue(idWithoutLastDigit.charAt(i));

            if ((i % 2) == 1)
            {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }

            sum += digit;
        }

        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit;
    }
}