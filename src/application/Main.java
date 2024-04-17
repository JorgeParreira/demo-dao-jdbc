package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: findByDepartment ===");
        Department department = new Department(4, null);
        List<Seller> list = sellerDao.findByDepartment(department);
       for (Seller obj: list) {
           System.out.println(obj);
       }

        System.out.println("\n=== TEST 3: findAll ===");
        List<Seller> list2 = sellerDao.findAll();
        for (Seller obj: list2) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@mail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted new seller: " + newSeller.getName() + " with id = " + newSeller.getId());


    }
}