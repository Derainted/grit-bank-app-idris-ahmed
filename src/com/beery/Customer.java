package com.beery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private String firstName;
    private String lastName;
    private long personalIdentityNumber;
    private List<Account> accounts;
    private UUID id;

    public Customer(String firstName, String lastName, long personalIdentityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdentityNumber = personalIdentityNumber;
        this.id = UUID.randomUUID();
        this.accounts = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalIdentityNumber=" + personalIdentityNumber +
                ", accounts=" + accounts +
                ", id=" + id +
                '}';
    }

    public static void addAll(List<Customer> customers) {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPersonalIdentityNumber() {
        return personalIdentityNumber;
    }

    public void setPersonalIdentityNumber(long personalIdentityNumber) {
        this.personalIdentityNumber = personalIdentityNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public long addAccount(String accountType) {
        Account account = new Account(accountType);

        long nextAccountNumber = 1001;
        for (Account value : accounts) {
            if (nextAccountNumber < value.getAccountNumber()) {
                nextAccountNumber = value.getAccountNumber();
            }
        }
        nextAccountNumber += 1;
        account.setAccountNumber(nextAccountNumber);

        accounts.add(account);
        return nextAccountNumber;
    }

    public void removeAccount(long accountNumber) {
        for (int j = 0; j < accounts.size(); j++) {
            if (accounts.get(j).getAccountNumber() == accountNumber) {
                accounts.remove(j);
                break;
            }
        }
    }

    public void presetAccount(long accountNumber, float balance, String accountType) {
        Account account = new Account(accountNumber, balance, accountType);

        accounts.add(account);
    }

    public void addAccount(Account debit_account) {

    }
}


