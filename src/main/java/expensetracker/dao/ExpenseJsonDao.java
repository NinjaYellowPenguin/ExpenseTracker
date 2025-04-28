package expensetracker.dao;

import expensetracker.models.Expense;
import expensetracker.persistence.PenguinJsonDao;

public class ExpenseJsonDao extends PenguinJsonDao<Expense>{

	public ExpenseJsonDao() {
		super("ExpenseJson.json");
	}

	@Override
	public Expense findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

}
