package ck.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ck.entity.SanPham;
import ck.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		List<SanPham> sanPhams=sanPhamService.getAllSanPham();
		model.addAttribute("list", sanPhams);
		return "home";
	}
	
	@GetMapping("/delete")
	public String deleteSp(@RequestParam("id") int id) {
		sanPhamService.deleteSanPham(id);
		return "redirect:/sanpham/";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		SanPham sp=new SanPham();
		model.addAttribute("sanpham", sp);
		List<SanPham> sanPhams=sanPhamService.getAllSanPham();
		model.addAttribute("list", sanPhams);
		return "Form";
	}
	
	@GetMapping("/update")
	public String showFormForUpadate(Model model, @RequestParam("id") int id) {
		SanPham sp=sanPhamService.get1SanPham(id);
		model.addAttribute("sanpham", sp);
		return "Form";
	}
	
	@PostMapping("saveSanPham")
	public String saveSanPham(@ModelAttribute("sanpham") SanPham sanPham) {
		sanPhamService.addSanPham(sanPham);
		return "redirect:/sanpham/";
	}
}
