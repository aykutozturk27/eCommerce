package eCommerce.google;

import eCommerce.entities.concretes.User;

public class GoogleAuthManager {
	public void register(User user) {
		System.out.println("Google ile �ye olundu : " + user.getFirstName() + user.getLastName());
	}
}
