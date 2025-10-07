package duonghao.vn.controller;

import duonghao.vn.model.User;
import duonghao.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Hiển thị danh sách + tìm kiếm
    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        List<User> users = userService.listAll(keyword);
        model.addAttribute("users", users);
        model.addAttribute("keyword", keyword);
        return "user/list";
    }

    // Form thêm mới
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    // Lưu (thêm/sửa)
    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    // Form sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "user/form";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
