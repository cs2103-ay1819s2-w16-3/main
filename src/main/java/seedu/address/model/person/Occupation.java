package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's occupation in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidOccupation(String)}
 */
public class Occupation {

    public static final String MESSAGE_CONSTRAINTS =
            "Occupations should only contain alphanumeric characters, and it should not be blank";

    /*
     * The first character of the occupation must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs a {@code Occupation}.
     *
     * @param occupation A valid occupation.
     */
    public Occupation(String occupation) {
        requireNonNull(occupation);
        checkArgument(isValidOccupation(occupation), MESSAGE_CONSTRAINTS);
        value = occupation;
    }

    /**
     * Returns true if a given string is a valid occupation.
     */
    public static boolean isValidOccupation(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Occupation // instanceof handles nulls
                && value.equals(((Occupation) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
