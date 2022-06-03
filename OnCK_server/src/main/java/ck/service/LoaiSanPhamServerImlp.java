package ck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ck.dao.LoaiSanPhamDao;
import ck.entity.LoaiSanPham;

@Service
public class LoaiSanPhamServerImlp implements LoaiSanPhamService{
	
	@Autowired
	private LoaiSanPhamDao loaiSanPhamDao;

	@Override
	@Transactional
	public List<LoaiSanPham> getAllLoai() {
		return loaiSanPhamDao.getAllLoai();
	}
	
}
