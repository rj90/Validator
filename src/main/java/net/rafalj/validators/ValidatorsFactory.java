package net.rafalj.validators;

import net.rafalj.validators.types.ValidatorType;

import java.util.HashMap;
import java.util.Map;

public class ValidatorsFactory {

    private final Map<ValidatorType, Validator> validators;

    private static volatile ValidatorsFactory INSTANCE = null;

    private ValidatorsFactory() {
        validators = new HashMap<>();
        validators.put(ValidatorType.NIP, NipValidator.getInstance());
        validators.put(ValidatorType.PESEL, PeselValidator.getInstance());
        validators.put(ValidatorType.REGON, RegonValidator.getInstance());
    }

    private static ValidatorsFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (ValidatorsFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ValidatorsFactory();
                }
            }
        }
        return INSTANCE;
    }

    public static Validator getValidator(ValidatorType type) {
        return getInstance().validators.get(type);
    }
}
