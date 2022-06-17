package service;

import java.io.IOException;
import java.util.List;
import model.Order;
import java.util.Map;

import exceptions.InvalidCategoryException;

public interface IOrderService {
	
	public List<Order> getAllOrdersByCategory(String category)throws InvalidCategoryException;
	public int getTotalOrderCost(String category)throws InvalidCategoryException;
	public List<Order> getAllCanceledOrder();
	public Map<String, List<Order>> createOrderMapByUser(); // key is username , value is List of orders
	public List<Order> filterOrders(String action); 
	public List<Order> getOrdersBasedOnOrderValue(); // sort the orders
	public boolean generatePDFReports(); // method will count the number of orders on cash payment , online payment and remains unpaid, delivered or cancelled

	
}
