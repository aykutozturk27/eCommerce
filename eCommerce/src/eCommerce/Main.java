package eCommerce;

import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.concretes.GoogleAuthManagerAdapter;
import eCommerce.dataAccess.concretes.HibernateUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		HibernateUserDao hibernateUserDao = new HibernateUserDao();
		AuthManager authManager = new AuthManager(hibernateUserDao, new GoogleAuthManagerAdapter());

		User user1 = new User(1,"Aykut","Öztürk","aykut.ozturk27@gmail.com","123456",true);
		User user2 = new User(2,"Bedia","Öztürk","bediaozturk@gmail.com","123456", true);
		
		authManager.register(user1);

		UserManager userManager = new UserManager(hibernateUserDao);
		userManager.add(user1);
//		userManager.update(user1);
//		userManager.delete(user1);
//		userManager.getAll();
		
	}

}
