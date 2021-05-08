package eCommerce.business.validationRules;

import java.util.regex.Pattern;

import eCommerce.business.constants.Messages;
import eCommerce.entities.concretes.User;

public class UserValidator {
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public static boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}
	
	public static boolean passwordMinSixCharacter(String password) {
		if (password.length() > 6) {
			return true;
		}
		System.out.println(Messages.PasswordMinSixCharacter);
		return false;
	}
	
	public static boolean firstAndLastNameMinTwoCharacter(String firstName, String lastName) {
		if (firstName.length() > 2 && lastName.length() > 2) {
			return true;
		}
		System.out.println(Messages.FirstAndLastNameMinTwoCharacter);
		return false;
	}
	
	public static boolean basicInformationIsRequired(User user) {
		if (user.getFirstName() != null && user.getLastName() != null && 
				user.getemail() != null && user.getPassword() != null) {
			return true;
		}
		System.out.println(Messages.BasicInformationIsRequired);
		return false;
	}
}
