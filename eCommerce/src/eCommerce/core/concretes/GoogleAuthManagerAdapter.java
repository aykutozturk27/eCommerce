package eCommerce.core.concretes;

import eCommerce.core.abstracts.ExternalAuthService;
import eCommerce.entities.concretes.User;
import eCommerce.google.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements ExternalAuthService {

	@Override
	public void registerToSystem(User user) {
		GoogleAuthManager manager = new GoogleAuthManager();
		manager.register(user);
	}

}
