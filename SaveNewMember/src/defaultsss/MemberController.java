package defaultsss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	
	public static void saveMember() throws SQLException
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Indtast fornavn: ");
		String name = in.next();
		System.out.print("Indtast efternavn: ");
		String lastName = in.next();
		System.out.print("Indtast nummer: ");
		int number = in.nextInt();
		System.out.print("Indtast email: ");
		String email = in.next();
		
		Connection conn = null; 
		PreparedStatement prepareStatement = null;
		
		
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/my_first_database?user=root&password=");
			prepareStatement = conn.prepareStatement("INSERT INTO customers VALUES(default, ?, ?, ?, ?)");
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, lastName);
			prepareStatement.setInt(3, number);
			prepareStatement.setString(4, email);
			
			prepareStatement.executeUpdate();
		
		} 
		catch (SQLException e) 
		{
			System.err.println(e);
		}
		finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}
	public static void loadMember() throws SQLException
	{
		ArrayList<String> foundMembers = new ArrayList<String>(); 
		Connection conn = null; 
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		
		
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/my_first_database?user=root&password=");
			prepareStatement = conn.prepareStatement("SELECT * FROM customers");
		
			result = prepareStatement.executeQuery();
			
			while(result.next())
			{
				int id = result.getInt("id");
				String name = result.getString("name");
				String lastName = result.getString("last_name");
				int phone = result.getInt("phone");
				String email = result.getString("email");
				
				System.out.println(id + " " + name + " " + lastName + " " + phone + " " + email);
				foundMembers.add(id + " " + name + " " + lastName + " " + phone + " " + email);
			}
			
			//System.out.println(foundMembers);
		} 
		catch (SQLException e) 
		{
			System.err.println(e);
		}
		finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}
}
