package expensetracker.dao;

import java.util.Set;

import expensetracker.models.Expense;
import expensetracker.persistence.PenguinJsonDao;

public class ExpenseJsonDao extends PenguinJsonDao<Expense>{


	public ExpenseJsonDao() {
		super("ExpenseJson.json", Expense.class);
	}

	@Override
	public Expense findById(Object id) {
		Set<Expense> expenses = findAll();
		for(Expense e: expenses) {
			if(e.getUuid().equals(id)) {
				return e;
			}
		}
		return null;
	}

}
