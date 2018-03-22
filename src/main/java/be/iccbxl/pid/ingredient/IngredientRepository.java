package be.iccbxl.pid.ingredient;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

	public List<Ingredient> findByProductId(int productId);
}
