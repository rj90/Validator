package net.rafalj.validators;

import net.rafalj.validators.types.ValidatorType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NipValidatorTest {

    @Test
    public void shouldValidateProperNip() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.NIP).validate("5413976264"), is(true));
    }

    @Test
    public void shouldReturnFalseNipToShort() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.NIP).validate("541397626"), is(false));
    }

    @Test
    public void shouldReturnFalseWrongCharacterInNip() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.NIP).validate("5413976A64"), is (false));
    }

    @Test
    public void shouldReturnFalseWrongChecksum() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.NIP).validate("5413976164"), is(false));
    }
}
