package controller;

import java.util.Scanner;
import java.util.NoSuchElementException;
import dao.LibDao;
import model.LibModel;
import service.LibDetails;

public class MainController {

	public static void main(String[] args) throws ClassNotFoundException {
		LibDetails ld = new LibDetails();
		LibDao libDao = new LibDao();
		System.out.println("********************************************************************************************");
		System.out.println("*****************WELCOME TO LIBRARY MANAGEMENT SYSTEM***************************************");
		System.out.println("********************************************************************************************");	
		System.out.println("Choose any one option:");
		boolean temp = true;
		while(temp) {
			System.out.println("1) Admin \n"
					+ "2) Librarian\n"
					+ "3) Exit");
			try (Scanner sc = new Scanner(System.in)) {
				int option = Integer.parseInt(sc.nextLine());
				switch(option) {
					case 1: {
						System.out.println("Enter your username");
						String adminName = sc.nextLine();
						System.out.println("Enter your password");
						String adminPwd = sc.nextLine();
						if(adminName.equals("Admin") && adminPwd.equals("123")) {
							boolean temp1 = true;
							while(temp1) {
								System.out.println("Choose any one of an operation that you wish to do");
								System.out.println("1) Add New books\n"
										+ "2) View book Details\n"
										+ "3) Update Existing Book Details\n"
										+ "4) Delete Existing Book\n"
										+ "5) Exit");
								boolean flag1 = true;
								int adminOption = 0;
								while(flag1) {
									try {
										adminOption = Integer.parseInt(sc.nextLine());
										flag1 = false;
									}catch(Exception e) {
										System.out.println("Input given type is wrong.");
										flag1 =true;
									}
								}
								
								switch(adminOption) {
									case 1:{
										System.out.println("Enter the number of books that you need to add");
										int lcount = Integer.parseInt(sc.nextLine());
										int bid;
										String bname;
										String aname;
										int rackno;
										double yearpub;
										for(int i=0; i<lcount; i++) {
											bid = Integer.parseInt(sc.nextLine());
											bname = sc.nextLine();
											aname = sc.nextLine();
											rackno = Integer.parseInt(sc.nextLine());
											yearpub = Double.parseDouble(sc.nextLine());
											LibModel lm = new LibModel(bid,bname,aname,rackno,yearpub);
											ld.addlibToList(lm);
										}
										break;
									}
									case 2:{
										libDao.viewLibraryTableRecord();
										break;
									}
									case 3:{
										System.out.println("Enter Book Id");
										int bid = Integer.parseInt(sc.nextLine());
										System.out.println("Select any one of the detail to get updated.\n1) BookName"
												+ "\n2)Author Name"
												+ "\n3) Subject"
												+ "\n4) Year of publish");
										int updateOption = Integer.parseInt(sc.nextLine());
										switch(updateOption) {
										case 1:{
											System.out.println("Enter the new book name which has an id as "+bid);
											String newbName = sc.nextLine();
											libDao.updateLibraryRecord(updateOption,bid,newbName);
											break;
										}
										case 2:{
											System.out.println("Enter the new author name which has an id as "+bid);
											String newan = sc.nextLine();
											libDao.updateLibraryRecord(updateOption,bid,newan);
											break;
										}
										case 3:{
											System.out.println("Enter the subject:");
											int newsub = Integer.parseInt(sc.nextLine());
											libDao.updateLibraryRecord(bid,newsub);
											break;
										}
										case 4:{
											System.out.println("Enter the year of publish ");
											double newyr = Double.parseDouble(sc.nextLine());
											libDao.updateLibraryRecord(bid,newyr);
											break;
										}
										}
										break;
									}
									case 4:
									{
										System.out.println("Enter Book Id");
									    int bid = Integer.parseInt(sc.nextLine());
										libDao.deleteLibraryTableRecord(bid);
										break;
									}
									case 5:{
										System.out.println("********************************************************");
										System.out.println("You have successfully logged out!!!");
										System.out.println("********************************************************");
						                System.exit(0);
										break;
									}
								}
							}
							
						}
						else {
							try{System.out.println("Incorrect username/password...Plz do check!!!!");}
							catch(NoSuchElementException e) {System.out.println("error");}
						}
						break;
					}
					case 2:{
						libDao.viewLibraryTableRecord();
						break;
					}
					case 3:{
						System.out.println("********************************************************");
						System.out.println("You have successfully logged out!!!");
						System.out.println("********************************************************");
		                System.exit(0);
					}
				}
			} 
			catch (NumberFormatException e) 
			{
				e.printStackTrace();
			}
		}
	}
}