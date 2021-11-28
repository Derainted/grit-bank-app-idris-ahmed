package com.beery;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class Mock {

    public static List<Customer> Customers = new ArrayList<>();

    public Mock() throws IOException {
    }

    public static void getCustomersAndAccounts() {

        var customer1 = new Customer("Idris", "Elba", 19990829L);
        var customer2 = new Customer("Jonny", "Herrera", 19970915L);
        var customer3 = new Customer("Michael", "Junior", 19560923L);

        customer1.addAccount(new Account(1001,900,"Debit account"));
        customer2.addAccount(new Account(1002,500,"Debit Account"));
        customer3.addAccount(new Account(1003,290,"Debit account"));

        List<Customer> customers = new ArrayList<>() {

            {
                add(customer1);
                add(customer2);
                add(customer3);

            }
        };

        Customer.addAll(customers);
    }


    public class Filehandler {
        private File myFile;
    }

    // File handler.. to download file from here
    File file = new File("/customerlist/customerlist.txt");
    Scanner scan = new Scanner(file);



    FileWriter writer = new FileWriter("/customerlist/newcustomerlist.txt");

}
