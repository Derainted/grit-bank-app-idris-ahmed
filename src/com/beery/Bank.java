package com.beery;


import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    private int findCustomer(long personalIdentityNumber) {
        int customerIndex = -1;
        for (int j = 0; j < customers.size(); j++) {
            if (customers.get(j).getPersonalIdentityNumber() == personalIdentityNumber) {
                customerIndex = 1;
            }
        }
        return customerIndex;
    }

    public List<String> getCustomersAndAccounts() {
        List<String> customerList = new ArrayList<>();
        String accountInfo = "";

        for (Customer customer : customers) {
            accountInfo = "";
            for (int j = 0; j < customer.getAccounts().size(); j++) {
                accountInfo +=
                        customer.getAccounts().get(j).getAccountNumber()
                        + " " +
                        customer.getAccounts().get(j).getAccountType()
                        + " " +
                        customer.getAccounts().get(j) .getBalance();
                        if (j < (customer.getAccounts().size()) -1) accountInfo += " , ";
            }
            customerList.add(
                    customer.getFirstName()
                    + " " +
                    customer.getLastName()
                    + " " +
                    customer.getPersonalIdentityNumber()
                    + " " +
                    accountInfo);
        }
        return customerList;
    }

    public boolean addCustomer(String firstName, String lastName, long personalIdentityNumber) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1) customers.add(new Customer(firstName, lastName, personalIdentityNumber));
        return (customerIndex == -1);
    }

    public List<String> getCustomer(long personalIdentityNumber) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1) return null;

        List<String> customerInfo = new ArrayList<>();

        customerInfo.add("Name: " + customers.get(customerIndex).getFirstName()
                + customers.get(customerIndex).getLastName());

        for (int j = 0; j < customers.get(customerIndex).getAccounts().size(); j++) {
            customerInfo.add(
                    "Account Number: "
                            + customers.get(customerIndex).getAccounts().get(j).getAccountNumber()
                            + "Balance: "
                            + customers.get(customerIndex).getAccounts().get(j).getBalance()
                            + "Account Type: "
                            + customers.get(customerIndex).getAccounts().get(j).getAccountType()
            );
        }
        return customerInfo;
    }

    public boolean changeCustomerName(String firstName, String lastName, long personalIdentityNumber) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1)
            return false;

        customers.get(customerIndex).setFirstName(firstName);
        customers.get(customerIndex).setLastName(lastName);

        return true;
    }

    public List<String> removeCustomer(long personalIdentityNumber) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1)
            return null;

        List<String> accountInfo = new ArrayList<>();

        for (int j = 0; j < customers.get(customerIndex).getAccounts().size(); j++) {
            accountInfo.add(
                    "Account Number: "
                    + customers.get(customerIndex).getAccounts().get(j).getAccountNumber()
                    + "Balance: "
                    + customers.get(customerIndex).getAccounts().get(j).getBalance()
                    + "Account Type: "
                    + customers.get(customerIndex).getAccounts().get(j).getAccountType()
            );
        }

        customers.remove(customerIndex);
        return accountInfo;
    }

    public long addAccount(long personalIdentityNumber, String accountType) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1)
            return -1;

        return customers.get(customerIndex).addAccount(accountType);
    }


    public String getAccount(long personalIdentityNumber, long accountNumber) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1)
            return "Customer not found";

        String returnString = "Account does not exist";
        for (int j = 0; j < customers.get(customerIndex).getAccounts().size(); j++) {
            if (customers.get(customerIndex).getAccounts().get(j).getAccountNumber() == accountNumber) {
                returnString =
                        "Account number: "
                        + accountNumber
                        + "Balance: "
                        + customers.get(customerIndex).getAccounts().get(j).getBalance()
                        + "Account Type: "
                        + customers.get(customerIndex).getAccounts().get(j).getAccountType();
            }
        }
        return returnString;
    }

    public boolean deposit(long personalIdentityNumber,long accountNumber, int amount) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1) return false;

        for (int j = 0; j < customers.get(customerIndex).getAccounts().size(); j++) {
            if (customers.get(customerIndex).getAccounts().get(j).getAccountNumber() == accountNumber) {
                customers.get(customerIndex).getAccounts().get(j).deposit(amount);
            }
        }
        return true;
    }

    public boolean withdraw(long personalIdentityNumber, long accountNumber, int amount){
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1) return false;
        boolean returnVal = false;

        for (int j = 0; j < customers.get(customerIndex).getAccounts().size(); j++) {
            if (customers.get(customerIndex).getAccounts().get(j).getAccountNumber() == accountNumber) {
                returnVal = customers.get(customerIndex).getAccounts().get(j).withdraw(amount);
            }
        }return returnVal;

    }

    public String closeAccount(long personalIdentityNumber, long accountNumber) {
        int customerIndex = findCustomer(personalIdentityNumber);
        if (customerIndex == -1) return "Cannot find customer";

        String returnString = "Account does not exist";
        for (int j = 0; j < customers.get(customerIndex).getAccounts().size(); j++) {

            if (customers.get(customerIndex).getAccounts().get(j).getAccountNumber() == accountNumber) {
                returnString =
                        "Account number: "+
                                accountNumber
                                +", Balance: "+
                                customers.get(customerIndex).getAccounts().get(j).getBalance();
                customers.get(customerIndex).removeAccount(accountNumber);
            }
        }
        return returnString;

    }

    public void addCustomer(Customer customer) {

    }
}
