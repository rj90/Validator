package net.rafalj.validators;

import java.util.regex.Pattern;

public class RegonValidator implements Validator {

    private static final int[] WEIGHTS_9 = {8, 9, 2, 3, 4, 5, 6, 7};

    private static final int[] WEIGHTS_14 = {2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8};

    private static final Pattern PATTERN_9 = Pattern.compile("\\d{9}");

    private static final Pattern PATTERN_14 = Pattern.compile("\\d{14}");

    private static volatile RegonValidator INSTANCE = null;

    private RegonValidator() {
    }

    static RegonValidator getInstance() {
        if (INSTANCE == null) {
            synchronized (RegonValidator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RegonValidator();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean validate(CharSequence number) {
        if (PATTERN_9.matcher(number).matches()) {
            return validateRegon(number, WEIGHTS_9);
        } else if (PATTERN_14.matcher(number).matches()) {
            return validateRegon(number, WEIGHTS_14);
        }

        return false;
    }

    private boolean validateRegon(CharSequence number, int[] weights) {
        int sum = 0;
        for (int i = 0; i < number.length() - 1; i++) {
            sum += Character.getNumericValue(number.charAt(i)) * weights[i];
        }
        return (sum % 11) % 10 == Character.getNumericValue(number.charAt(number.length() - 1));
    }
}
