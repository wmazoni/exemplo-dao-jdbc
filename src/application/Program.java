package application;

import java.util.Date;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		System.out.println("=== TEST 1: seller findById ====");
		
		Seller seller = sellerDAO.findById(3);
		
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: seller findAll ====");
		list = sellerDAO.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
	}

}
