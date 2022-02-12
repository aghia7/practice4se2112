package repositories.products;

import models.Product;
import repositories.EntityRepository;

import java.util.List;

public interface IProductRepository extends EntityRepository<Product> {
    List<Product> getByCategory(String category);
}
