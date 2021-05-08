package eCommerce.core.abstracts;

import eCommerce.entities.concretes.User;

public interface ExternalAuthService {
	void registerToSystem(User user);
}
