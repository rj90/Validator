package net.rafalj.validators;

import net.rafalj.validators.types.ValidatorType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegonValidatorTest {

    @Test
    public void shouldValidateProperRegon9() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.REGON).validate("232913726"), is(true));
    }

    @Test
    public void shouldValidateProperRegon14() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.REGON).validate("25400828116815"), is(true));
    }

    @Test
    public void shouldReturnFalseRegonToShort() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.REGON).validate("23291372"), is(false));
    }

    @Test
    public void shouldReturnFalseWrongCharacter() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.REGON).validate("23291A726"), is(false));
    }

    @Test
    public void shouldReturnFalseWrongChecksum() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.REGON).validate("232913722"), is(false));
    }
}
