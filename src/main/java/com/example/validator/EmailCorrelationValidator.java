package com.example.validator;

import com.example.form.AccountForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailCorrelationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // Decide the argument is check target of this validator or not. Here AccountForm class is the target to be checked.
        return AccountForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasFieldErrors()) {
            return;
        }

        final AccountForm form = (AccountForm) target;
        final String email = form.getEmail();
        final String confirmEmail = form.getConfirmEmail();

        if (!email.equals(confirmEmail)) {
            errors.rejectValue("email","EmailCorrelationValidator.email","email and confirmemail must be same.");
        }

    }
}
