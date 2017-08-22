package net.rafalj.validators;

import net.rafalj.validators.types.ValidatorType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PeselValidatorTest {

    @Test
    public void shouldValidateProperPesel() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.PESEL).validate("53082223982"), is(true));
    }

    @Test
    public void shouldReturnFalsePeselToShort() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.PESEL).validate("5308222398"), is(false));
    }

    @Test
    public void shouldReturnFalseWrongCharacter() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.PESEL).validate("53082223A82"), is(false));
    }

    @Test
    public void shouldReturnFalseWrongChecksum() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.PESEL).validate("53082223782"), is(false));
    }
}
