package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void login(User user);
	boolean isExists(String email);
}
