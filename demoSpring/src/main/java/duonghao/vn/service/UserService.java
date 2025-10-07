package duonghao.vn.service;

import duonghao.vn.model.User;
import duonghao.vn.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> listAll(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
			return repo.findByUsernameContainingIgnoreCase(keyword);
		}
		return repo.findAll();
	}

	// Lưu (thêm/sửa)
	public User save(User user) {
		return repo.save(user);
	}

	// Lấy theo ID
	public User get(Long id) {
		return repo.findById(id).orElse(null);
	}

	// Xóa
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
