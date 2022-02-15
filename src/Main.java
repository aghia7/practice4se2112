import controllers.ProductController;
import controllers.UserController;
import data.DB;
import data.postgres.Postgres;
import models.Product;
import repositories.interfaces.IProductRepository;
import repositories.products.ProductRepository;
import repositories.interfaces.IUserRepository;
import repositories.users.UserRepository;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DB db = Postgres.getInstance();
        IUserRepository userRepo = new UserRepository(db);
        IProductRepository productRepo = new ProductRepository(db);

        UserController userCtrl = new UserController(userRepo);
        ProductController productCtrl = new ProductController(productRepo);

        MyApplication app = new MyApplication(userCtrl, productCtrl);

        app.start();

        db.close();
    }
}