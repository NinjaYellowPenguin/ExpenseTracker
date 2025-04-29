package expensetracker.models;

import java.time.LocalDateTime;
import java.util.Objects;

import glaciar.anotacionespinguino.PenguinAttribute;
import glaciar.anotacionespinguino.PenguinEntity;

@PenguinEntity
public class Expense {
	@PenguinAttribute(penguinKey = true)
	private String uuid;
	private String description;
	private int amountCts; // Amount in cts to avoid floats.
	private String category;
	private LocalDateTime createdAt;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmountCts() {
		return amountCts;
	}

	public void setAmountCts(int amountCts) {
		this.amountCts = amountCts;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder("\n");
		msg.append("uuid").append(getUuid()).append("->\n");
		msg.append("	description").append(getDescription()).append("\n");
		msg.append("	amountCts").append(getAmountCts()).append("\n");
		msg.append("	category").append(getCategory()).append("\n");
		msg.append("	createdAt").append(getCreatedAt()).append("\n");
		
		return super.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true; 
		if (o == null || getClass() != o.getClass())
			return false; 
		Expense expense = (Expense) o; 

		return Objects.equals(uuid, expense.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid); 
	}

}
