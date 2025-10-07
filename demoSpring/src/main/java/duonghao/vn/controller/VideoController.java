package duonghao.vn.controller;

import duonghao.vn.model.Category;
import duonghao.vn.model.Video;
import duonghao.vn.service.VideoService;
import duonghao.vn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/videos")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@Autowired
	private CategoryService categoryService;

	// Hiển thị danh sách + tìm kiếm
	@GetMapping
	public String list(@RequestParam(required = false) String keyword, Model model) {
		List<Video> videos = videoService.listAll(keyword);
		model.addAttribute("videos", videos);
		model.addAttribute("keyword", keyword);
		return "video/list";
	}

	// Form thêm mới
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("video", new Video());
		model.addAttribute("categories", categoryService.listAll()); // lấy tất cả category
		return "video/form";
	}

	// Lưu (thêm/sửa)
	@PostMapping("/save")
	public String save(@ModelAttribute Video video) {
		// Lấy category từ DB dựa trên id
		if (video.getCategory() != null) {
			Category cat = categoryService.get(video.getCategory().getId());
			video.setCategory(cat);
		}
		videoService.save(video);
		return "redirect:/admin/videos";
	}

	// Form sửa
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id, Model model) {
		model.addAttribute("video", videoService.get(id));
		model.addAttribute("categories", categoryService.listAll());
		return "video/form";
	}

	// Xóa
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		videoService.delete(id);
		return "redirect:/admin/videos";
	}
}
