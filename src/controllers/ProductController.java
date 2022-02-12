package controllers;

import models.Product;
import repositories.interfaces.IProductRepository;

import java.util.List;

public class ProductController {
    private final IProductRepository productRepo;

    public ProductController(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public String getById(int id) {
        Product product = productRepo.get(id);

        if (product == null)
            return "Product with id = " + id + " does not exist.";

        return product.toString();
    }

    public String getAll() {
        List<Product> products = productRepo.getAll();

        if (products.isEmpty())
            return "Products list is empty!";

        StringBuilder response = new StringBuilder();
        for (Product product : products)
            response.append(product).append("\n");

        return response.toString();
    }

    public String removeById(int id) {
        Product product = productRepo.get(id);

        if (product == null)
            return "Product with id = " + id + " does not exist.";

        boolean removed = productRepo.delete(id);

        if (removed)
            return "Product " + product.getName() + " " + product.getPrice() +
                    "$ with category " + product.getCategory() + " was removed successfully!";

        return "Product cannot be removed!";
    }

    public String create(String name, String category, double price) {
        Product product = new Product(name, category, price);
        boolean created = productRepo.create(product);

        if (created)
            return "A new product " + name + " " + price + "$ with category " + category
                    + " was added successfully!";

        return "Product cannot be created!";
    }

    public String getAllByCategory(String category) {
        List<Product> products = productRepo.getByCategory(category);

        if (products.isEmpty())
            return "Products list is empty!";

        StringBuilder response = new StringBuilder();
        for (Product product : products)
            response.append(product).append("\n");

        return response.toString();
    }
}
