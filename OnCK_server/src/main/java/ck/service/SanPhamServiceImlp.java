package ck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ck.dao.SanPhamDao;
import ck.entity.SanPham;

@Service
public class SanPhamServiceImlp implements SanPhamService{
	
	@Autowired
	private SanPhamDao sanPhamDao;

	@Override
	@Transactional
	public List<SanPham> getAllSanPham() {
		return sanPhamDao.getAllSanPham();
	}

	@Override
	@Transactional
	public SanPham get1SanPham(int id) {
		return sanPhamDao.get1SanPham(id);
	}

	@Override
	@Transactional
	public void addSanPham(SanPham sanPham) {
		sanPhamDao.addSanPham(sanPham);
		
	}

	@Override
	@Transactional
	public void deleteSanPham(int id) {
		sanPhamDao.deleteSanPham(id);
		
	}

}
