package eCommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.business.abstracts.AuthService;
import eCommerce.business.constants.Messages;
import eCommerce.business.validationRules.UserValidator;
import eCommerce.core.abstracts.ExternalAuthService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService {

	UserDao userDao;
	ExternalAuthService externalAuthService;
	
	List<User> users;

	public AuthManager(UserDao userDao, ExternalAuthService externalAuthService) {
		this.userDao = userDao;
		this.externalAuthService = externalAuthService;
		users = new ArrayList<User>();
        this.users.add(new User(1,"Aykut","Öztürk","aykutozturk27@gmail.com","123456",true));
        this.users.add(new User(2,"Bedia","Öztürk","bediaozturk@gmail.com","123456",true));
        this.users.add(new User(3,"Yaşar","Öztürk","yasarozturk@gmail.com","123456",true));
	}

	@Override
	public void register(User user) {
		var emailIsValid = UserValidator.isEmailValid(user.getemail());
		if (!emailIsValid) {
			System.out.println(Messages.EmailIsNotValid);
			return;
		}

		var userExists = isExists(user.getemail());
		if (!userExists) {
			System.out.println(Messages.UserAlreadyExists);
			return;
		}

		var basicInfoIsRequired = UserValidator.basicInformationIsRequired(user);
		if (!basicInfoIsRequired) {
			System.out.println(Messages.BasicInformationIsRequired);
			return;
		}

		var firstAndLastNameMinTwoCharacter = UserValidator.firstAndLastNameMinTwoCharacter(user.getFirstName(),
				user.getLastName());
		if (!firstAndLastNameMinTwoCharacter) {
			System.out.println(Messages.FirstAndLastNameMinTwoCharacter);
			return;
		}

		var passwordMinSixCharacter = UserValidator.passwordMinSixCharacter(user.getPassword());
		if (!passwordMinSixCharacter) {
			System.out.println(Messages.PasswordMinSixCharacter);
			return;
		}

		System.out.println(Messages.SendVerificationEmail);
		externalAuthService.registerToSystem(user);
		if (user.isVerified()) {
			System.out.println();
		}
		this.userDao.add(user);
	}

	@Override
	public void login(User userModel) {
		var userToCheck = getByMail(userModel.getemail());
		if (userToCheck == null) {
			System.out.println(Messages.UserDoesNotExist);
			return;
		}
		
		User user = getByMail(userModel.getemail());

		if (user != null && user.getPassword().equals(userModel.getPassword())) {
			System.out.println(Messages.LoginSuccessfull);
		}else {
			System.out.println(Messages.LoginFailed);
		}
	}

	@Override
	public boolean isExists(String email) {
		if (getByMail(email) != null) {
			return true;
		}
		return false;
	}
	
	public User getByMail(String email) {
		for (User user : users) {
			if (user.getemail() == email) {
				return user;
			}
		}
		return null;
	}
}
