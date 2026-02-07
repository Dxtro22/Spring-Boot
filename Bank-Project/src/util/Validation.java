package util;

import domain.Account;
import exception.ValidationException;

@FunctionalInterface
public interface Validation<Strings> {
    void validate(String value) throws ValidationException;
}
