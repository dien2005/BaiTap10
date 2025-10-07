package duonghao.vn.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import duonghao.vn.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Tìm kiếm theo nội dung tên
    List<Product> findByProductNameContaining(String name);

    // Tìm kiếm và phân trang
    Page<Product> findByProductNameContaining(String name, Pageable pageable);

    // Tìm chính xác theo tên
    Optional<Product> findByProductName(String name);

    // Tìm theo ngày tạo
    Optional<Product> findByCreateDate(Date createAt);
}
