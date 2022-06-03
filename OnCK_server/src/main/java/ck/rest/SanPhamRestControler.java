package ck.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ck.entity.SanPham;
import ck.service.SanPhamService;

@RestController
@RequestMapping("/api")
public class SanPhamRestControler {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping("/sanphams")
	public List<SanPham> getAllSanPham() {
		return sanPhamService.getAllSanPham();
	}
	@GetMapping("/sanphams/{id}")
	public SanPham get1SanPham(@PathVariable int id) {
		return sanPhamService.get1SanPham(id);
	}
	
	@PostMapping("/sanphams")
	public void addSanPham(@RequestBody SanPham sanPham) {
		sanPhamService.addSanPham(sanPham);
	}
	
	@PutMapping("/sanphams")
	public void updateSanPham(@RequestBody SanPham sanPham) {
		sanPhamService.addSanPham(sanPham);
	}
	
	@DeleteMapping("/sanphams/{id}")
	public void deleteSP(@PathVariable int id) {
		sanPhamService.deleteSanPham(id);
	}
	
}
