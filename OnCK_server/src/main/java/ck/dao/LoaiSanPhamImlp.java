package ck.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ck.entity.LoaiSanPham;

@Repository
public class LoaiSanPhamImlp implements LoaiSanPhamDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<LoaiSanPham> getAllLoai() {
		Session session=sessionFactory.getCurrentSession();
		List<LoaiSanPham> lsp =new ArrayList<LoaiSanPham>();
		Query<LoaiSanPham> query = session.createNativeQuery("select * from LoaiSanPham",LoaiSanPham.class);
		lsp=query.getResultList();
		return lsp;
	}

}
