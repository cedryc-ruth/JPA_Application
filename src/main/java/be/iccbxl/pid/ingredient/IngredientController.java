package be.iccbxl.pid.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.iccbxl.pid.product.Product;

@RestController
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@RequestMapping("/products/{id}/ingredients")
	public List<Ingredient> getAllIngredients(@PathVariable String id) {
		return ingredientService.getAllIngredients(id);
	}
	
	@RequestMapping("/products/{productId}/ingredients/{id}")
	public Ingredient getIngredient(@PathVariable String id) {
		return ingredientService.getIngredient(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products/{productId}/ingredients")
	public void addIngredient(@RequestBody Ingredient ingredient, @PathVariable String productId) {
		ingredient.setProduct(new Product(Integer.parseInt(productId),"",0d));
		ingredientService.addIngredient(ingredient);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{productId}/ingredients/{id}")
	public void updateIngredient(@RequestBody Ingredient ingredient, @PathVariable String productId, @PathVariable String id) {
		ingredient.setProduct(new Product(Integer.parseInt(productId),"",0d));
		ingredientService.updateIngredient(ingredient);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{productId}/ingredients/{id}")
	public void deleteIngredient(@PathVariable String id) {
		ingredientService.deleteIngredient(id);
	}
}
