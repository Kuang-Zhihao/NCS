package model;

public class Order {
	
	private String username;
	private String category;
	private int orderCost;
	private String dateOfOrder; // LocalDate if operations needed
	private String action;
		
	public Order() {
		
	}
	
	public Order(String username, String category, int orderCost, String dateOfOrder, String action) {
		this.username = username;
		this.category = category;
		this.orderCost = orderCost;
		this.dateOfOrder = dateOfOrder;
		this.action = action;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}
	public String getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public String toString() {
		return "[" + username + ", " + category + ", " + orderCost + ", " + dateOfOrder + ", " + action + "]\n";
	}
	

}
