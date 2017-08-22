package net.rafalj.validators;

import java.util.regex.Pattern;

public class PeselValidator implements Validator {

    private static final int[] WEIGHTS = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    private static final Pattern PATTERN = Pattern.compile("\\d{11}");

    private static volatile PeselValidator INSTANCE = null;

    private PeselValidator() {
    }

    static PeselValidator getInstance() {
        if (INSTANCE == null) {
            synchronized (PeselValidator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PeselValidator();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean validate(CharSequence number) {
        if (!PATTERN.matcher(number).matches()) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < number.length() - 1; i++) {
            sum += Character.getNumericValue(number.charAt(i)) * WEIGHTS[i];
        }

        return (10 - sum % 10) % 10 == Character.getNumericValue(number.charAt(number.length() - 1));
    }
}
