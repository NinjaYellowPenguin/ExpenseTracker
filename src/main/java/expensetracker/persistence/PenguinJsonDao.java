package expensetracker.persistence;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import expensetracker.models.Expense;

public abstract class PenguinJsonDao <T>{

	private JsonManager jsonManager;
	private Set<T> items;
	private JavaType type;
	//Need Jackson yet
	private ObjectMapper mapper;

	public PenguinJsonDao(String path, Class<T> clazz) {		
		this.mapper = new ObjectMapper();
		this.mapper.registerModule(new JavaTimeModule());
		this.type = mapper.getTypeFactory().constructCollectionType(Set.class, clazz);
		jsonManager = new JsonManager(path);
		refresh();		
	}

	public T add(T item) {
		if (items.add(item)) {
			save();
		}
		return item;
	}

	public T update(T item) {
		items.remove(item);
		items.add(item);
		save();
		return item;
	}

	public T delete(T item) {
		items.remove(item);
		save();
		return item;

	}
	
	public abstract T findById(Object id);
	
	/* TODO: Need penguinAnnotations
	public T findById(String id) {
		for(Expense item: items) {
			if(item.getUuid().equals(id)) {
				return item;
			}
		}
		return null;
	}
	*/
	public Set<T> findAll() {
		return items;
	}

	private void save() {
		jsonManager.write(toJson(items));
		refresh();
	}

	private void refresh() {
		String jsonString = jsonManager.readOrCreate();
		items = parseExpenses(jsonString);

	}

	private Set<T> parseExpenses(String json) {
		try {
			return mapper.readValue(json, type);
		} catch (IOException e) {
			e.printStackTrace();
			return Set.of();
		}
	}

	private String toJson(Set<T> items) {
		try {
			return mapper.writeValueAsString(items);
		} catch (IOException e) {
			e.printStackTrace();
			return "[]";
		}
	}

}
