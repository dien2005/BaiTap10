package duonghao.vn.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import duonghao.vn.model.Video;

import java.util.List;
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByTitleContainingIgnoreCase(String keyword);
}