package be.iccbxl.pid.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		
	/*
		Iterator<Product> it = productRepository.findAll().iterator();
		
		while(it.hasNext()) {
			products.add(it.next());
		}
	*/
		
		productRepository.findAll().forEach(products::add);
		
		return products;
	}
	
	public Product getProduct(String id) {
		int indice = Integer.parseInt(id);
		
		return productRepository.findById(indice).get();
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProduct(String id, Product product) {
		productRepository.save(product);
	}

	public void deleteProduct(String id) {
		Integer indice = Integer.parseInt(id);
		
		productRepository.deleteById(indice);
	}
}
