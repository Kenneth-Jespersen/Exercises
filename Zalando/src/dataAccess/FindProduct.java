package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindProduct {
	
	
	public static void findProduct() throws SQLException
	{
		Scanner in = new Scanner(System.in);
		ArrayList<String> foundProducts = new ArrayList<String>(); 
		Connection conn = null; 
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		
		System.out.print("Søg: ");
		String search = in.next();
		
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/zalando?user=root&password=");			
//			prepareStatement = conn.prepareStatement("SELECT * FROM products WHERE product_name LIKE ?");
			
			prepareStatement = conn.prepareStatement("SELECT * FROM products WHERE product_name LIKE ? OR brand_name LIKE ? OR colour LIKE ? OR size LIKE ? OR fit_type LIKE ? OR material LIKE ? OR article_number LIKE ?");
			
				prepareStatement.setString(1,"'%"+search+"%'");
				prepareStatement.setString(2,"'%"+search+"%'");
				//prepareStatement.setObject(3,"'%"+search+"%'");
				prepareStatement.setString(3,"'%"+search+"%'");
				prepareStatement.setString(4,"'%"+search+"%'");
				prepareStatement.setString(5,"'%"+search+"%'");
				prepareStatement.setString(6,"'%"+search+"%'");
//				prepareStatement.setObject(8,"'%"+search+"%'");
//				prepareStatement.setObject(9,"'%"+search+"%'");
//				prepareStatement.setObject(10,"'%"+search+"%'");
//				prepareStatement.setObject(11,"'%"+search+"%'");
				prepareStatement.setString(7,"'%"+search+"%'");
			
			result = prepareStatement.executeQuery();
			
			System.err.println("in while");
			
			while(result.next())
			{
				foundProducts.add(result.getString("product_name"));
				foundProducts.add(result.getString("brand_name"));
				//foundProducts.add(result.getInt("price"));
				foundProducts.add(result.getString("colour"));
				foundProducts.add(result.getString("size"));
				foundProducts.add(result.getString("fit_type"));
				foundProducts.add(result.getString("material"));
//				foundProducts.add(result.getObject("in_stock"));
//				foundProducts.add(result.getObject("height"));
//				foundProducts.add(result.getObject("width"));
//				foundProducts.add(result.getObject("depth"));
				foundProducts.add(result.getString("article_number"));
				System.err.println("in while");
			
			}

				System.out.print(foundProducts);

		} 
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}

	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
