package be.iccbxl.pid.ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	
	public List<Ingredient> getAllIngredients(String productId) {
		List<Ingredient> ingredients = new ArrayList<>();
		
	/*
		Iterator<Ingredient> it = ingredientRepository.findAll().iterator();
		
		while(it.hasNext()) {
			ingredients.add(it.next());
		}
	*/
		
		ingredientRepository.findByProductId(Integer.parseInt(productId))
			.forEach(ingredients::add);
		
		return ingredients;
	}
	
	public Ingredient getIngredient(String id) {
		int indice = Integer.parseInt(id);
		
		return ingredientRepository.findById(indice).get();
	}

	public void addIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	public void updateIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	public void deleteIngredient(String id) {
		Integer indice = Integer.parseInt(id);
		
		ingredientRepository.deleteById(indice);
	}
}
