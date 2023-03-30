package DB.connect;

import java.sql.Connection;

import DAO.ProductDAO;
import model.Product;

public class testDB {
	public static void main(String[] args) {
		Connection conn = DatabaseConfig.getConnection();
		ProductDAO dao = new ProductDAO();
		
			
		
	}
}
