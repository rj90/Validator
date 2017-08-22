package net.rafalj.validators;

import net.rafalj.validators.types.ValidatorType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidatorsFactoryTest {

    @Test
    public void shouldReturnPeselValidator() {
        assertThat(ValidatorsFactory.getValidator(ValidatorType.PESEL), instanceOf(PeselValidator.class));
    }

    @Test
    public void shouldReturnNullValidatorNullInput() {
        assertThat(ValidatorsFactory.getValidator(null), nullValue());
    }
}
