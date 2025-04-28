package expensetracker.main;

import java.security.Provider.Service;

import expensetracker.services.ExpenseService;

public class Main {

	public static void main(String[] args) {
		
		ExpenseService servie = new ExpenseService();
		
		servie.add("Url domain", 4300, "IT");

	}

}
