package com.banking;

import com.banking.service.AccountService;
import com.banking.model.AccountType;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create an instance of AccountService
        AccountService accountService = new AccountService();

        try {
            // Create test accounts (same as before)
            accountService.createAccount(AccountType.SAVINGS, "SAV001", new BigDecimal("5000.00"));
            accountService.createAccount(AccountType.CHECKING, "CHK001", new BigDecimal("1000.00"));
            accountService.createAccount(AccountType.SAVINGS, "SAV002", new BigDecimal("500.00"));
            accountService.createAccount(AccountType.SAVINGS, "SAV003", new BigDecimal("5500.00"));

            // Show Account Summary
            System.out.println("ACCOUNT SUMMARY REPORT");
            System.out.println("Generated: " + getCurrentTime());
            System.out.println("-------------------------");
            Map<String, Object> accountSummary = accountService.getAccountSummary();
            System.out.println("Total Accounts: " + accountSummary.get("totalAccounts"));
            System.out.println("Total Balance: $" + accountSummary.get("totalBalance"));
            System.out.println();
            System.out.println("This shows our total bank holdings");
            System.out.println();

            // Show Daily Activity
            System.out.println("TODAY'S TRANSACTIONS");
            System.out.println("Date: " + getCurrentDate());
            System.out.println("-------------------------");
            Map<String, Object> dailyTransactions = accountService.getDailyTransactions();
            System.out.println("Money Deposited: $" + dailyTransactions.get("totalDeposits"));
            System.out.println("Money Withdrawn: $" + dailyTransactions.get("totalWithdrawals"));
            System.out.println("Total Change: $" + dailyTransactions.get("totalChange"));
            System.out.println();
            System.out.println("This tracks today's money movement");
            System.out.println();

            // Show Account Activity
            System.out.println("TOP ACCOUNTS REPORT");
            System.out.println("Generated: " + getCurrentTime());
            System.out.println("-------------------------");
            Map<String, Object> accountActivity = accountService.getAccountActivity();
            System.out.println("Most Active: " + accountActivity.get("mostActiveAccount"));
            System.out.println("→ Number of Transactions: " + accountActivity.get("transactionCount"));
            System.out.println("Highest Balance: " + accountActivity.get("highestBalanceAccount"));
            System.out.println("→ Current Balance: $" + accountActivity.get("highestBalance"));
            System.out.println();
            System.out.println("This shows our important accounts");

        } catch (Exception e) {
            System.err.println("Error generating reports: " + e.getMessage());
        }
    }

    // Helper function to format the current date and time
    private static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    private static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}
