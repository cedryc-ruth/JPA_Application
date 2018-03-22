package be.iccbxl.pid.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService productService;
	
	@RequestMapping("/products")
	public List<Category> getAll() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable String id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public void addProduct(@RequestBody Category product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
	public void updateProduct(@RequestBody Category product, @PathVariable String id) {
		productService.updateProduct(id, product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		productService.deleteProduct(id);
	}
}
