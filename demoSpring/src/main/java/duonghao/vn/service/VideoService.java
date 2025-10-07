package duonghao.vn.service;

import duonghao.vn.model.Video;
import duonghao.vn.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repo;

    // Liệt kê + tìm kiếm
    public List<Video> listAll(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return repo.findByTitleContainingIgnoreCase(keyword);
        }
        return repo.findAll();
    }

    // Lưu (thêm/sửa)
    public Video save(Video video) {
        return repo.save(video);
    }

    // Lấy theo ID
    public Video get(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Xóa
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
