package ck.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ten_sp")
	private String tenSanPham;
	
	@Column(name = "don_gia")
	private float donGia;
	
	@ManyToOne
	@JoinColumn(name = "id_loaisp")
	private LoaiSanPham loaiSP;
	
	public SanPham() {
		// TODO Auto-generated constructor stub
	}

	public SanPham(int id, String tenSanPham, float donGia, LoaiSanPham loaiSP) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.loaiSP = loaiSP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public LoaiSanPham getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(LoaiSanPham loaiSP) {
		this.loaiSP = loaiSP;
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", tenSanPham=" + tenSanPham + ", donGia=" + donGia + ", loaiSP=" + loaiSP + "]";
	}
	
}
