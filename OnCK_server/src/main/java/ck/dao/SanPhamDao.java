package ck.dao;

import java.util.List;

import ck.entity.SanPham;

public interface SanPhamDao {
	public List<SanPham> getAllSanPham();
	public SanPham get1SanPham(int id);
	public void addSanPham(SanPham sanPham);
	public void deleteSanPham(int id);
}
