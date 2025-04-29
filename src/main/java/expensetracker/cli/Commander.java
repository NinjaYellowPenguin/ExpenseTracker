package expensetracker.cli;

import java.time.Month;
import java.util.List;

import expensetracker.models.Expense;
import expensetracker.services.ExpenseService;
import glaciar.commanderpenguin.CommanderPenguin;
import glaciar.commanderpenguin.PenguinComand;
import glaciar.tablapinguino.TablaPinguino;

public class Commander extends CommanderPenguin{	

	public Commander(String[] args) {
		super(args);
	}
	
	@PenguinComand("add")
	public void addExpense() {
		ExpenseService service = new ExpenseService();
		String description = penguinFlags.get("description");
		int amount = Integer.parseInt(penguinFlags.get("amount"));
		String cat = penguinFlags.get(penguinFlags.get("category"));
		Expense expense = service.add(description, amount, cat);
		System.out.println("Expense added. ID: " + expense.getUuid());
	}
	
	@PenguinComand("list")
	public void listExpends() {		
		ExpenseService service = new ExpenseService();
		List<Expense> expenses = service.findAll();
		TablaPinguino tabla = new TablaPinguino(expenses.toArray());
		tabla.sysoTable();	
	}
	
	@PenguinComand("summary")
	public void getSummary() {
		ExpenseService service = new ExpenseService();
		String monthS = penguinFlags.get("month");
		if(monthS != null) {
			try {
				int month = Integer.parseInt(monthS);
				int summary = service.getSpecificSummaty(month);
				System.out.println("Total expenses for " + Month.of(month).toString() + ": " + summary);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		}else {
			int summary = service.getAllSummary();
			System.out.println("Total expenses: " + summary);
		}		
	}
	
	/*
	 * $ expense-tracker delete --id 2
	# Expense deleted successfully
	 */
	
	@PenguinComand("delete")
	public void deleteExpense() {
		String id = penguinFlags.get("id");
		ExpenseService service = new ExpenseService();
		Expense deletedExp = service.delete(id);
		System.out.println("Expense deleted successfully. ID: " + deletedExp.getUuid());		
	}
	
}
