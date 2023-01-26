package me.anvarisy.kodegiri.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import me.anvarisy.kodegiri.entity.Product;
// import at.favre.lib.crypto.bcrypt.BCrypt;
import me.anvarisy.kodegiri.entity.User;
import me.anvarisy.kodegiri.repository.ProductRepository;
import me.anvarisy.kodegiri.repository.UserRepository;

@Component
public class UserSeeder implements CommandLineRunner{

    @Autowired
    private UserRepository repo;

    @Autowired
    private ProductRepository repoProduct;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        if(repo.count()<=0){
            String p = new BCryptPasswordEncoder().encode("kodegiri");
            // String password = BCrypt.withDefaults().hashToString(12, "kodegiri".toCharArray());;
            repo.save(new User(1,"kodegiri", p));
        }
        if(repoProduct.count()<=0){
            List<Product> products = new ArrayList<>();
            products.add(new Product(1, "Toyota",5000, 10));
            products.add(new Product(2, "BMW",6000, 9));
            products.add(new Product(3, "MITSUBISHI",4000, 20));
            products.add(new Product(4, "TESLA",7500, 5));
            products.add(new Product(5, "HONDA",4500, 11));
            repoProduct.saveAll(products);
        }
        System.out.println("Seeding item done...");
    }
    
}
