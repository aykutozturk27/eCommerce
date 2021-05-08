package eCommerce.google;

import eCommerce.entities.concretes.User;

public class GoogleAuthManager {
	public void register(User user) {
		System.out.println("Google ile üye olundu : " + user.getFirstName() + user.getLastName());
	}
}
