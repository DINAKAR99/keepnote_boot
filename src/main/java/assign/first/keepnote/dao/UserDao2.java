package assign.first.keepnote.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import assign.first.keepnote.model.User;

public interface UserDao2 extends JpaRepository<User, Integer> {

}
