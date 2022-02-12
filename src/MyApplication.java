import controllers.ProductController;
import controllers.UserController;

import java.util.Scanner;

public class MyApplication {
    private final UserController userCtrl;
    private final ProductController productCtrl;
    private final Scanner sc;

    public MyApplication(UserController userCtrl, ProductController productCtrl) {
        this.userCtrl = userCtrl;
        this.productCtrl = productCtrl;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("Please, select option:");
            System.out.println("1. User`s menu");
            System.out.println("2. Product`s menu");
            System.out.println("0. Exit");

            int option = sc.nextInt();

            try {
                if (option == 1)
                    usersMenu();
                else if (option == 2)
                    productMenu();
                else
                    break;
            } catch (Exception e) {
                System.out.println("Something went wrong: Error " + e.getMessage());
                System.out.println("0. Enter any symbol to return to main menu...");
                sc.next();
            }
        }
    }



    // Users START
    private void usersMenu() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("User`s menu");
            System.out.println("Please, select option:");
            System.out.println("1. Create user");
            System.out.println("2. Get user by id");
            System.out.println("3. Get all users");
            System.out.println("4. Remove user by id");
            System.out.println("0. Exit from user`s menu");

            int option = sc.nextInt();

            if (option == 1)
                createUser();
            else if (option == 2)
                getUserById();
            else if (option == 3)
                getAllUsers();
            else if (option == 4)
                removeUserById();
            else
                break;
        }
    }

    private void removeUserById() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        String resp = userCtrl.removeById(id);
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    private void getAllUsers() {
        String resp = userCtrl.getAll();
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    private void getUserById() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        String resp = userCtrl.getById(id);
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    private void createUser() {
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter surname:");
        String surname = sc.next();
        String resp = userCtrl.create(name, surname);
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    // Users END

    // Products START
    private void productMenu() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("Product`s menu");
            System.out.println("Please, select option:");
            System.out.println("1. Create product");
            System.out.println("2. Get product by id");
            System.out.println("3. Get all products");
            System.out.println("4. Remove product by id");
            System.out.println("5. Get all products by category");
            System.out.println("0. Exit from product`s menu");

            int option = sc.nextInt();

            if (option == 1)
                createProduct();
            else if (option == 2)
                getProductById();
            else if (option == 3)
                getAllProducts();
            else if (option == 4)
                removeProductById();
            else if (option == 5)
                getAllProductsByCategory();
            else
                break;
        }
    }

    private void removeProductById() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        String resp = productCtrl.removeById(id);
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    private void getAllProducts() {
        String resp = productCtrl.getAll();
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    private void getProductById() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        String resp = productCtrl.getById(id);
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    private void createProduct() {
        System.out.println("Enter name:");
        sc.nextLine(); // for ignoring unwanted empty string
        String name = sc.nextLine();
        System.out.println("Enter category:");
        String category = sc.next();
        System.out.println("Enter price:");
        double price = sc.nextDouble();
        String resp = productCtrl.create(name, category, price);
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    private void getAllProductsByCategory() {
        System.out.println("Enter category: ");
        String category = sc.next();
        String resp = productCtrl.getAllByCategory(category);
        System.out.println(resp);

        System.out.println("0. Enter any symbol to exit...");
        sc.next();
    }

    // Products END
}
