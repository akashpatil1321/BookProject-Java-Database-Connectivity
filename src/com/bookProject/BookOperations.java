package com.bookProject;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BookOperations {
	static Connection con=BookConnectivity.createConnection();
	
	static Scanner sc=new Scanner(System.in);
	
	public static void AddBook(int BookId, String BookName,String AuthorName,double Price,double Rating)
	{
		try {
			PreparedStatement pstmt=con.prepareStatement("Insert into books values(?,?,?,?,?)");
			pstmt.setInt(1, BookId);
			pstmt.setString(2, BookName);
			pstmt.setString(3, AuthorName);
			pstmt.setDouble(4, Price);
			pstmt.setDouble(5, Rating);
			pstmt.executeUpdate();
			System.out.println("Book With ID : "+BookId+" Added to the Database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void SearchByBookName(String BookName) {
		int flag=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from books where BookName = ?" );
			pstmt.setString(1, BookName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
			System.out.println("***************************************************");
			System.out.println("Book ID      : "+rs.getInt(1));
			System.out.println("Book Name    : "+rs.getString(2));
			System.out.println("Author Name  : "+rs.getString(3));
			System.out.println("Book Price   : "+rs.getDouble(4));
			System.out.println("Book Rating  : "+rs.getDouble(5));
			System.out.println("***************************************************");
			flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==0) {
			System.out.println("NO Book Available Of Name "+BookName);
		}
	}
	public static void SearchByAuthorName(String AuthorName) {
		int flag=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from books where AuthorName = ?" );
			pstmt.setString(1, AuthorName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
			System.out.println("***************************************************");
			System.out.println("Book ID      : "+rs.getInt(1));
			System.out.println("Book Name    : "+rs.getString(2));
			System.out.println("Author Name  : "+rs.getString(3));
			System.out.println("Book Price   : "+rs.getDouble(4));
			System.out.println("Book Rating  : "+rs.getDouble(5));
			System.out.println("***************************************************");
			flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==0) {
			System.out.println("NO Author Of Name "+AuthorName+" Present In List");
		}
	}
	public static void SortByRating() {
		try {
		PreparedStatement pstmt=con.prepareStatement("SELECT  * FROM books ORDER BY Rating DESC" );
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			System.out.println("***************************************************");
			System.out.println("Book ID      : "+rs.getInt(1));
			System.out.println("Book Name    : "+rs.getString(2));
			System.out.println("Author Name  : "+rs.getString(3));
			System.out.println("Book Price   : "+rs.getDouble(4));
			System.out.println("Book Rating  : "+rs.getDouble(5));
			System.out.println("***************************************************");
		}
	} catch (SQLException e) { 
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void SortByPrice() {
		try {
		PreparedStatement pstmt=con.prepareStatement("SELECT * FROM books ORDER BY Price desc" );
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			System.out.println("***************************************************");
			System.out.println("Book ID      : "+rs.getInt(1));
			System.out.println("Book Name    : "+rs.getString(2));
			System.out.println("Author Name  : "+rs.getString(3));
			System.out.println("Book Price   : "+rs.getDouble(4));
			System.out.println("Book Rating  : "+rs.getDouble(5));
			System.out.println("***************************************************");
		}
	} catch (SQLException e) { 
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void  Display() {
		try {
			Statement stmt=con.createStatement();
			String query="select * from books";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println("***************************************************");
				System.out.println("Book ID      : "+rs.getInt(1));
				System.out.println("Book Name    : "+rs.getString(2));
				System.out.println("Author Name  : "+rs.getString(3));
				System.out.println("Book Price   : "+rs.getDouble(4));
				System.out.println("Book Rating  : "+rs.getDouble(5));
				System.out.println("***************************************************");
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Delete(int id)
	{
		try {
			
			PreparedStatement stmt=con.prepareStatement("DELETE FROM books WHERE BookID=?");
			stmt.setInt(1, id);
			int row=stmt.executeUpdate();
			System.out.println(row+" Row affected ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
