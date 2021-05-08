package eCommerce.dataAccess.concretes;

import java.util.List;

import eCommerce.business.constants.Messages;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println(Messages.AddUser + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void update(User user) {
		System.out.println(Messages.UpdateUser + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void delete(User user) {
		System.out.println(Messages.DeleteUser + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
