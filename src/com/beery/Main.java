package com.beery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Mock.getCustomersAndAccounts();

        var Customers = Mock.Customers;

        Bank b1 = new Bank();
        Bank b2 = new Bank();
        Bank b3 = new Bank();

        for (var customer : Customers) {
            b1.addCustomer(customer);
        }

        var customerInfo1 = b1.getCustomer(19990829L);
        var customerInfo2 = b2.getCustomer(19970915L);
        var customerInfo3 = b3.getCustomer(19560923L);






        // MENU..
        List<Customer> c = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1. ADD A CUSTOMER");
            System.out.println("2. DISPLAY CUSTOMER LIST");
            System.out.println("3. SEARCH CUSTOMER");
            System.out.println("4. DELETE CUSTOMER");
            System.out.println("5. UPDATE INFORMATION");
            System.out.println("Enter Your Choice; ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = s1.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = s1.nextLine();
                    System.out.print("Enter PersonalNo: ");
                    long personalIdentityNumber = s.nextLong();

                    c.add(new Customer(firstName, lastName, personalIdentityNumber));
                    break;

                case 2:
                    System.out.println("------------------------");
                    Iterator<Customer> i = c.iterator();
                    while (i.hasNext()) {
                        Customer e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("-------------------------");
                    break;

                case 3:
                    boolean found = false;
                    System.out.println("Enter PersonalNo to search");
                    personalIdentityNumber = s.nextLong();
                    System.out.println("------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Customer e = i.next();
                        if (e.getPersonalIdentityNumber() == personalIdentityNumber) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("User not found");
                    }
                    System.out.println("-------------------------");
                    break;

                case 4:
                    found = false;
                    System.out.println("Enter PersonNo to delete");
                    personalIdentityNumber = s.nextLong();
                    System.out.println("------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Customer e = i.next();
                        if (e.getPersonalIdentityNumber() == personalIdentityNumber) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("User not found");
                    } else {
                        System.out.println("Record is deleted Successfully");
                    }
                    System.out.println("-------------------------");
                    break;

                case 5:
                    found = false;
                    System.out.println("Enter PersonNo to update");
                    personalIdentityNumber = s.nextLong();
                    System.out.println("------------------------");
                    ListIterator<Customer> li = c.listIterator();
                    while (li.hasNext()) {
                        Customer e = li.next();
                        if (e.getPersonalIdentityNumber() == personalIdentityNumber) {
                            System.out.println("Enter new first name");
                            firstName = s1.nextLine();
                            System.out.println("Enter new last name");
                            lastName = s1.nextLine();
                            li.set(new Customer(firstName, lastName, personalIdentityNumber));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("User not found");
                    } else {
                        System.out.println("Record is updated Successfully");
                    }
                    System.out.println("-------------------------");
                    break;
            }
        }
        while (ch != 0);

    }
}
