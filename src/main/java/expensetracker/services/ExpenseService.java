package expensetracker.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import expensetracker.dao.ExpenseJsonDao;
import expensetracker.models.Expense;

public class ExpenseService {
	
	private ExpenseJsonDao dao;
	
	public ExpenseService() {
		dao = new ExpenseJsonDao();
	}
	
	public Expense add(String description, int ammountCts) {
		return add(description, ammountCts, "");
	}
	
	public Expense add(String descrition, int ammount, String category) {
		Expense expense = new Expense();
		expense.setUuid(UUID.randomUUID().toString());
		expense.setDescription(descrition);
		expense.setAmountCts(ammount);
		expense.setCategory(category);
		expense.setCreatedAt(LocalDateTime.now());
		return dao.add(expense);		
	}
	
	// Debería extraer la info anterior para mergear
	public Expense update(Expense expense) {		
		return dao.update(expense);		
	}
	
	public Expense delete(String uuid){
		Expense expense = new Expense();
		expense.setUuid(uuid);
		return dao.delete(expense);
	}
	
	public List<Expense> findAll() {
		return new ArrayList<Expense>(dao.findAll());
	}
	
	public Optional<Expense> findById(String uuid) {
		return dao.findAll().stream().filter(e->e.getUuid().equals(uuid)).filter(Objects::nonNull).findFirst();
	}
	
	public int getAllSummary() {
		int summ = 0;
		List<Expense> expenses = findAll();
		for(Expense e: expenses) {
			summ+=e.getAmountCts();
		}
		return summ;		
	}
	
	public int getSpecificSummaty(int month) throws Exception {
		if(month < 1 || month > 12) {
			throw new Exception("Month must be between 1 - 12");
		}
		int summ = 0;
		List<Expense> expenses = findAll();
		for(Expense e: expenses) {
			if(e.getCreatedAt().getMonthValue() == month && e.getCreatedAt().getYear() == LocalDateTime.now().getYear()) {
				summ+=e.getAmountCts();
			}			
		}
		return summ;
	}

}
