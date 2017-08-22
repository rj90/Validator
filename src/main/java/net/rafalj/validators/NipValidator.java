package net.rafalj.validators;

import java.util.regex.Pattern;

public class NipValidator implements Validator {

    private static final int[] WEIGHTS = {6, 5, 7, 2, 3, 4, 5, 6, 7};

    private static final Pattern PATTERN = Pattern.compile("\\d{10}");

    private static volatile NipValidator INSTANCE = null;

    private NipValidator() {
    }

    static NipValidator getInstance() {
        if (INSTANCE == null) {
            synchronized (NipValidator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NipValidator();
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
        return (sum % 11 == Character.getNumericValue(number.charAt(number.length() - 1)));
    }
}
