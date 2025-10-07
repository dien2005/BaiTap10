package duonghao.vn.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import duonghao.vn.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameContainingIgnoreCase(String keyword);
}