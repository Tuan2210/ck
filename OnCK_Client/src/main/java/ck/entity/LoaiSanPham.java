package ck.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	private String tenLoai;
	
	
	
	public LoaiSanPham() {
		// TODO Auto-generated constructor stub
	}

	public LoaiSanPham(int id, String tenLoai) {
		super();
		this.id = id;
		this.tenLoai = tenLoai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [id=" + id + ", tenLoai=" + tenLoai + "]";
	}
	
}
