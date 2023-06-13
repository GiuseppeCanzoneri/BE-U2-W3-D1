package Giuseppe.Canzoneri.BEU2W3.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PrenotazioneDateValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PrenotazioneDateConstraint {
	String message() default "La prenotazione deve essere richiesta con almeno due giorni di anticipo!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}