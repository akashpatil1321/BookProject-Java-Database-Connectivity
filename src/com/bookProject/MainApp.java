package com.bookProject;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1.Enter the NEW Book \n2.Delete Book \n3.Display all Book \n4.Search By Author Name \n5.Search By Book Name \n6.Sort By Rating \n7.Sort By Price \n8.Exit");
			ch = sc.nextInt();
			switch (ch) {
           
			case 1: {
				System.out.println("Enter the Book ID");
				int ID = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Book Name ");
				String BoookName = sc.nextLine();
				System.out.println("Enter the Author Name ");
				String AuthorName = sc.nextLine();
				System.out.println("Enter the Price of Book");
				double Price = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the Rating of Book");
				double Rating = sc.nextDouble();
				BookOperations.AddBook(ID, BoookName, AuthorName, Price, Rating);
				break;
			}
			case 2: {
				System.out.println("Enter the ID of the Book you Want to DELETE");
				int id = sc.nextInt();
				BookOperations.Delete(id);
				break;
			}
			case 3: {
				BookOperations.Display();
				break;
			}
			case 4:{
				sc.nextLine();
				System.out.println("Enter the Author Name");
				String Aname=sc.nextLine();
				BookOperations.SearchByAuthorName(Aname);
				break;
			}
			case 5:{
				sc.nextLine();
				System.out.println("Enter the Book Name");
				String Bname=sc.nextLine();
				BookOperations.SearchByBookName(Bname);
				break;
			}
			case 6:{
				BookOperations.SortByRating();
				break;
			}
			case 7:{
				BookOperations.SortByPrice();
				break;
			}
			default:{
				System.out.println("InValid Choice....");

			}
			}

		} while (ch != 8);
		sc.close();

	}

}
