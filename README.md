# spring-validator-example
This sample is for input validation.  
The input validation is mandatory to check whether the value entered by user is correct.

This sample provides two way of input validation as follows:
1. Single Validation
2. Correlation Validation

## Single Validation.
Single Validation is used to check single field.

The input form of this sample has four fields as follow:
 - name: input mandatory check, digit check
 - age:: input mandatory check, number check
 - email: input mandatory check, format check
 - confirmEmail: input mandatory check, format check

## Correlation Validation.
Correlation Validation is used to check multi fields.

In the input form of this sample, EmailCorrelationValidation.java checks comparing email and confirm email.
