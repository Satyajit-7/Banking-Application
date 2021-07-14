/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_application;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Banking_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankAccount obj=new BankAccount("Satyajit","AZ201");
        obj.showMenu();
    }
    
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
    
    BankAccount(String name, String id){
        customerName=name;
        customerId=id;
    }
    
    
    void deposit(int amount){
        if(amount>0)
        {
            balance=balance+amount;
            previousTransaction=amount;
        }
    }
    
    void withdraw(int amount){
        if(amount>0)
        {
            balance=balance-amount;
            previousTransaction=-amount;
        }
    }
    
    void getPreviousTransaction(){
        if(previousTransaction>0)
            System.out.println("Deposited: " + previousTransaction);
        else if(previousTransaction<0)
            System.out.println("Withdrawn: " + -previousTransaction);
        else
            System.out.println("No transaction occured");
    }
    
    void showMenu(){
        char option='\0';
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId + "\n");
        System.out.println("SELECT OPTIONS");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposite");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Trasanction");
        System.out.println("E. Exit");
        
        do{
            System.out.println("================================================================");
            System.out.print("Enter an option: ");
  
            option=scanner.next().charAt(0);
            
            switch(option){
                case 'A':
                  System.out.println("----------------------------------------------"); 
                  System.out.println("Balance: " + balance);
                  System.out.println("----------------------------------------------\n"); 
                  break;
                  
                case 'B':
                  System.out.println("----------------------------------------------"); 
                  System.out.println("Enter an amount to deposite: ");
                  System.out.println("----------------------------------------------"); 
                  int amount=scanner.nextInt();
                  deposit(amount);
                  System.out.println();
                  break;
                
                case 'C':
                  System.out.println("----------------------------------------------"); 
                  System.out.println("Enter an amount to withdraw: ");
                  System.out.println("----------------------------------------------");
                  int amount2=scanner.nextInt();
                  withdraw(amount2);
                  System.out.println();
                  break;
                  
                case 'D':
                  System.out.println("----------------------------------------------"); 
                  getPreviousTransaction();
                  System.out.println("----------------------------------------------"); 
                  System.out.println();
                  break;
                  
                case 'E':
                    System.out.println("========================================================");
                    break;
                  
                default:
                  System.out.println("Invalid Option! Please enter again."); 
                  break;
            }
                    
            
        }while(option!='E');
        
        System.out.println("Thank you for using our service");
        
    }
}
