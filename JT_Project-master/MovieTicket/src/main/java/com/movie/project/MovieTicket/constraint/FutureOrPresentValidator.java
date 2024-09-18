package com.movie.project.MovieTicket.constraint;

import java.sql.Date;
import java.util.Calendar;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.FutureOrPresent;

public class FutureOrPresentValidator implements ConstraintValidator<FutureOrPresent, Date>{

	 @Override
	    public void initialize(FutureOrPresent constraintAnnotation) {
	    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
    	if (value == null) {
            return true; // Let @NotNull handle null values
        }

        // Get current date at the start of the day
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);

        // Convert the value to the start of the day
        Calendar bookingDate = Calendar.getInstance();
        bookingDate.setTime(value);
        bookingDate.set(Calendar.HOUR_OF_DAY, 0);
        bookingDate.set(Calendar.MINUTE, 0);
        bookingDate.set(Calendar.SECOND, 0);
        bookingDate.set(Calendar.MILLISECOND, 0);

        // Compare dates
        return !bookingDate.before(currentDate);
    }

}
