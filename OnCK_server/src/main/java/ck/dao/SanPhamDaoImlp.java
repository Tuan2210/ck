package ck.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ck.entity.SanPham;
@Repository
public class SanPhamDaoImlp implements SanPhamDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SanPham> getAllSanPham() {
		List<SanPham> ds=new ArrayList<SanPham>();
		Session session =sessionFactory.getCurrentSession();
		Query<SanPham> query=session.createNativeQuery("select *from SanPham", SanPham.class);
		ds = query.getResultList();
		
		return ds;
	}

	@Override
	public SanPham get1SanPham(int id) {
		Session session =sessionFactory.getCurrentSession();
		SanPham sp=session.get(SanPham.class, id);
		return sp;
	}

	@Override
	public void addSanPham(SanPham sanPham) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(sanPham);
		
	}

	@Override
	public void deleteSanPham(int id) {
		Session session =sessionFactory.getCurrentSession();
		SanPham sp=session.get(SanPham.class, id);
		session.delete(sp);
		
	}

}
