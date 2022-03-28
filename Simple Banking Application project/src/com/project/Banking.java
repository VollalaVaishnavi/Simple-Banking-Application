package com.project;
import java.util.Scanner;

 class BankDetails
 {
	 
	 private String accno;  
	 private String name;  
	 private String acc_type;  
	 private long balance;  
	 private int age;
	 private String address;
	 static int minimumbalance;
	      
	     
	    Scanner sc = new Scanner(System.in);  
	    //method to open new account  
	    public void openAccount() 
	    {  
	        System.out.print("Enter Account No: ");  
	        accno = sc.next();  
	        System.out.print("Enter Account type: ");  
	        acc_type = sc.next();  
	        System.out.print("Enter Name: ");  
	        name = sc.next();  
	        System.out.println("Enter your age: ");
	        age=sc.nextInt();
	        System.out.println("Enter your address: ");
	        address=sc.next();
	        System.out.println("Enter balance: ");
	        balance=sc.nextLong();
	        System.out.println("Your account has been created..."
	        		+ "Enjoy our services");
	         
	    }  
	    static 
	    {
			minimumbalance=1000;
		}
	    
		 //method to display account details  
	    public void showAccount()
	    {  
	        System.out.println("Name of account holder: " + name);  
	        System.out.println("Account no.: " + accno);  
	        System.out.println("Account type: " + acc_type); 
	         
	        System.out.println("Balance: "+balance);
	    }  
	    //method to check balance
	    public void checkBalance()
	    {
	    	 
	    	 
	    	long amt;
	    	balance=minimumbalance+balance;
	    	System.out.println("******************************");
	    	System.out.println("Current balance is: "+balance);
	    	   
	    	System.out.println("******************************");
	    	 amt=sc.nextLong(); 	
	    }
	    //method to deposit money  
	    public void deposit()
	    {  
	        long amt; 
	        System.out.println(" ");
	        System.out.println("Enter the amount you want to deposit: "); 
	        
	        amt = sc.nextLong();  
	        balance = balance + amt;  
	        System.out.println(" ");
	        System.out.println("******************************");  
	        System.out.println("Balance after deposited:"+balance);  
	        System.out.println("******************************");     
	    }  
	    //method to withdraw money  
	    public void withdrawal() {  
	        long amt;  
	        System.out.println("Enter the amount you want to withdraw: ");  
	        amt = sc.nextLong();  
	        if (balance >minimumbalance) {  
	            balance = balance -amt ; 
	            System.out.println("**************************************");
	            System.out.println("Balance after withdrawal: " + balance);
		        System.out.println("**************************************");
	               
	        } else {  
	            System.out.println("Your balance is less than " + minimumbalance + "\tTransaction failed...!!" ); 
	            System.out.println("*******************************************************");
	        }  
	    }  
	    //method to search an account number  
	    public boolean search(String ac_no) {  
	        if (accno.equals(ac_no)) {  
	            showAccount();  
	            return (true);  
	        }  
	        return (false);  
	    }  
	}  
	public class Banking{  
	    public static void main(String args[]) {  
	        Scanner sc = new Scanner(System.in);  
	        //create initial accounts  
	        System.out.print("###How many number of customers do you want to input? ###");  
	        int n = sc.nextInt();  
	        BankDetails Customers[] = new BankDetails[n];  
	        for (int num= 0; num< Customers.length; num++) 
	        {  
	            Customers[num] = new BankDetails();  
	            Customers[num].openAccount();  
	        }  
	        // loop runs until number 6 is not pressed to exit  
	        int ch;  
	        do {  
	            System.out.println("\n ***Banking System Application***");  
	            System.out.println("1. Display all account details");
	            System.out.println("2. Search by Account number");
	            System.out.println("3. Deposit the amount");
	            System.out.println("4. Withdraw the amount");
	            System.out.println("5.CheckBalance");
	            System.out.println("6.Exit \n");  
	            System.out.println("Enter your choice: ");  
	            ch = sc.nextInt();  
	                switch (ch) {  
	                    case 1:  
	                        for (int num= 0; num< Customers.length; num++) {  
	                            Customers[num].showAccount();  
	                        }  
	                        break;  
	                    case 2:  
	                        System.out.print("Enter account no. you want to search: ");  
	                        String ac_no = sc.next();  
	                        boolean found = false;  
	                        for (int num= 0; num < Customers.length; num++) {  
	                            found = Customers[num].search(ac_no);  
	                            if (found) {  
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break;  
	                    case 3:  //case for deposit
	                        System.out.print("Enter Account no. : ");  
	                        ac_no = sc.next();  
	                        found = false;  
	                        for (int num= 0; num< Customers.length; num++) {  
	                            found = Customers[num].search(ac_no);  
	                            if (found) {  
	                                Customers[num].deposit();  
	                             
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break;  
	                    case 4:  //case for withdraw
	                        System.out.print("Enter Account No : ");  
	                        ac_no = sc.next();  
	                        found = false;  
	                        for (int num= 0; num < Customers.length; num++) {  
	                            found = Customers[num].search(ac_no);  
	                            if (found) {  
	                                Customers[num].withdrawal();  
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break; 
	                    case 5://case for checkbalance
	                    	System.out.println("Enter Account No: ");
	                    	ac_no=sc.next();
	                    	found=false;
	                    	for(int num=0;num<Customers.length;num++) {
	                    		found=Customers[num].search(ac_no);
	                    		if(found) {
	                    			Customers[num].checkBalance();
	                    			 
	                    			break;
	                    		}
	                    	}
	                    	if (!found) {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break; 
	                    	 
	                    case 6:  
	                        System.out.println("Thank you...Visit again");  
	                        break;  
	                }  
	            }  
	            while (ch !=6);  
	        }  
	
	}




