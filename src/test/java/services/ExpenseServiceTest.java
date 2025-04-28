package services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import expensetracker.dao.ExpenseJsonDao;
import expensetracker.models.Expense;
import expensetracker.services.ExpenseService;

public class ExpenseServiceTest {

    private ExpenseService service;
    private ExpenseJsonDao mockDao;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        service = new ExpenseService(); // Usamos la clase original
        mockDao = mock(ExpenseJsonDao.class);

        // Usamos reflexión para acceder al campo privado `dao` y asignar el mock
        Field daoField = ExpenseService.class.getDeclaredField("dao");
        daoField.setAccessible(true); // Permite acceso a campos privados
        daoField.set(service, mockDao); // Inyectamos el mock
    }

    @Test
    public void testAddExpense() {
        Expense expected = new Expense();
        when(mockDao.add(any(Expense.class))).thenReturn(expected);

        Expense result = service.add("Compra", 500);

        assertNotNull(result);
        verify(mockDao, times(1)).add(any(Expense.class));
    }

    @Test
    public void testUpdateExpense() {
        Expense expense = new Expense();
        when(mockDao.update(expense)).thenReturn(expense);

        Expense updated = service.update(expense);

        assertEquals(expense, updated);
        verify(mockDao, times(1)).update(expense);
    }

    @Test
    public void testDeleteExpense() {
        Expense expense = new Expense();
        expense.setUuid("1234");

        when(mockDao.delete(any(Expense.class))).thenReturn(expense);

        Expense deleted = service.delete("1234");

        assertEquals("1234", deleted.getUuid());
        verify(mockDao, times(1)).delete(any(Expense.class));
    }

    @Test
    public void testFindAllExpenses() {
    	Expense e1 = new Expense();
        e1.setUuid(UUID.randomUUID().toString());
        e1.setAmountCts(100);

        Expense e2 = new Expense();
        e2.setUuid(UUID.randomUUID().toString());
        e2.setAmountCts(200);
        
        List<Expense> expenses = Arrays.asList(e1, e2);
        when(mockDao.findAll()).thenReturn(new HashSet<Expense>(expenses));

        List<Expense> result = service.findAll();

        assertEquals(2, result.size());
        verify(mockDao, times(1)).findAll();
    }

    @Test
    public void testFindByIdExists() {
        Expense expense = new Expense();
        expense.setUuid("abcd");

        when(mockDao.findAll()).thenReturn(Collections.singleton(expense));

        Optional<Expense> found = service.findById("abcd");

        assertTrue(found.isPresent());
        assertEquals("abcd", found.get().getUuid());
    }

    @Test
    public void testFindByIdNotExists() {
        when(mockDao.findAll()).thenReturn(Collections.emptySet());

        Optional<Expense> found = service.findById("xyz");

        assertFalse(found.isPresent());
    }

    @Test
    public void testGetAllSummary() {
        Expense e1 = new Expense();
        e1.setUuid(UUID.randomUUID().toString());
        e1.setAmountCts(100);

        Expense e2 = new Expense();
        e2.setUuid(UUID.randomUUID().toString());
        e2.setAmountCts(200);

        when(mockDao.findAll()).thenReturn(new HashSet<>(Arrays.asList(e1, e2)));

        int total = service.getAllSummary();

        assertEquals(300, total);
    }

    @Test
    public void testGetSpecificSummaryCorrectMonth() throws Exception {
        Expense e1 = new Expense();
        e1.setAmountCts(150);
        e1.setCreatedAt(LocalDateTime.now());

        Expense e2 = new Expense();
        e2.setAmountCts(250);
        e2.setCreatedAt(LocalDateTime.now().minusMonths(1)); // Otro mes

        when(mockDao.findAll()).thenReturn(new HashSet<>(Arrays.asList(e1, e2)));

        int currentMonth = LocalDateTime.now().getMonthValue();
        int total = service.getSpecificSummaty(currentMonth);

        assertEquals(150, total);
    }

    @Test
    public void testGetSpecificSummaryInvalidMonthLow() {
        Exception exception = assertThrows(Exception.class, () -> {
            service.getSpecificSummaty(0);
        });

        assertEquals("Month must be between 1 - 12", exception.getMessage());
    }

    @Test
    public void testGetSpecificSummaryInvalidMonthHigh() {
        Exception exception = assertThrows(Exception.class, () -> {
            service.getSpecificSummaty(13);
        });

        assertEquals("Month must be between 1 - 12", exception.getMessage());
    }
}

