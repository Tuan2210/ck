package ck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ck.entity.SanPham;

@Service
public class SanPhamServiceImlp implements  SanPhamService{
	
	private RestTemplate restTemplate;
	private String restApi;
	
	@Autowired
	public SanPhamServiceImlp(RestTemplate restTemplate,@Value("${url}") String restApi) {
		super();
		this.restTemplate = restTemplate;
		this.restApi = restApi;
	}

	@Override
	public List<SanPham> getAllSanPham() {
		ResponseEntity<List<SanPham>> responseEntity=restTemplate.exchange(restApi, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<SanPham>>() {
		});
		List<SanPham> ls=responseEntity.getBody();
		return ls;
	}

	@Override
	public SanPham get1SanPham(int id) {
		SanPham sp=restTemplate.getForObject(restApi+"/"+id, SanPham.class);
		return sp;
	}

	@Override
	public void addSanPham(SanPham sanPham) {
		restTemplate.postForLocation(restApi, sanPham);
		
	}

	@Override
	public void deleteSanPham(int id) {
		restTemplate.delete(restApi+"/"+id);
	}

}
