import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import exceptions.InvalidCategoryException;
import model.Order;
import service.IOrderService;

public class Midterm1 implements IOrderService {
 
	private static List<Order> orders;
	private static List<String> categories = new ArrayList<String>();
	private static Scanner scanner = new Scanner(System.in);
	public static Midterm1 admin = new Midterm1();
	
	public static void main(String[] args) throws InvalidCategoryException {
		
		System.out.println("Order Query Menu\n---------------");
		System.out.println("1. Query All Orders by Category");
		System.out.println("2. Query Total Order Cost");
		System.out.println("3. Query All Cancelled Order");
		System.out.println("4. Create Order Map By User");
		System.out.println("5. Filter Orders");
		System.out.println("6. Query Orders based on Order Value");
		System.out.println("7. Generate PDF Report");
		System.out.println("8. Exit");
		System.out.println("Enter Numbers above to Continue");
		
		String fileName = "Order.csv";
		orders = readCsv(fileName);
		// Obtain all available categories for checking category exception
		for (Order order: orders) 
			categories.add(order.getCategory());
		
		// Use while true (including latter parts) to allow multiple queries
		while (true) {
			String temp = scanner.next();
			if (!isValidInput(temp)) {
				System.out.println("Invalid input. Please try again: ");
				continue;
			}
			int option = Integer.parseInt(temp); 
			if (option == 8) {
				scanner.close();
				System.out.println("Program ends here. ");
				break;
			} else {
				processOption(option);
				System.out.println("Enter Number Again to Query Other Information: ");
			}
		}
		
	}
	
	public static boolean isValidInput(String temp) {
	    int option;
		try {
	    	option = Integer.parseInt(temp);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
		if (option < 1 || option > 8) {
			return false;
		}
	    return true;
	}
	
	public static boolean isValidCategory(String category) {
		try {
			if (!categories.contains(category)) {
				throw new InvalidCategoryException(category);
			}
	    } catch (InvalidCategoryException ice) {
	    	ice.printException();
	        return false;
	    }
	    return true;
	}

	
	public static List<Order> readCsv(String fileName) {
		
		List<Order> orders = new ArrayList<Order>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    br.readLine(); // header 
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        Order order = new Order(values[0],values[1],Integer.parseInt(values[2]),values[3],values[4]);
	        	orders.add(order);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return orders;
		
	}
	
	public static void processOption(int option) throws InvalidCategoryException {
		
		String category;
		String action;
		switch (option){
			case 1:
				System.out.println("Please enter the category:");
				while (true) {
					category = scanner.next();					
					if (!isValidCategory(category)) {
						System.out.println("Invalid category. Please try again: ");
						continue;
					} 
					List<Order> ordersByCategory = admin.getAllOrdersByCategory(category);
					System.out.println("Orders By Category " + category + ": \n" + ordersByCategory);
					break;
				}
				break;
			case 2:
				System.out.println("Please enter the category:");
				while (true) {
					category = scanner.next();					
					if (!isValidCategory(category)) {
						System.out.println("Invalid category. Please try again: ");
						continue;
					} 
					int totalOrderCost = admin.getTotalOrderCost(category);
					System.out.println("Total Order Cost excluding Cancelled Orders for " + category + " is " + totalOrderCost);
					break;
				}
				break;
			case 3:
				List<Order> canceledOrders = admin.getAllCanceledOrder();
				System.out.println("Cancelled orders are: \n" + canceledOrders);
				break;
			case 4:
				Map<String, List<Order> > orderMapByUser = admin.createOrderMapByUser();
				System.out.println("Order Map by User: \n" + orderMapByUser);
				break;
			case 5:
				System.out.println("Please enter the action:");
				while (true) {
					action = scanner.next();					
					if (action.equals("delivered") || action.equals("cancelled")) {
						List<Order> filteredOrders = admin.filterOrders(action);
						System.out.println("Orders with " + action + " action are: \n" + filteredOrders);
						break;
					} else {
						System.out.println("Invalid action. Please try again:");
					}
					
				}
				break;
			case 6:
				List<Order> sortedOrders = admin.getOrdersBasedOnOrderValue();
				System.out.println("Sorted orders by order cost: \n" + sortedOrders);
				break;
			case 7:
				admin.generatePDFReports();
				System.out.println("PDF Report generated");
				break;
		}		
		
	}

	@Override
	public List<Order> getAllOrdersByCategory(String category) throws InvalidCategoryException {
		
		List<Order> ordersByCategory = new ArrayList<Order>();
		if (!categories.contains(category)) {
			throw new InvalidCategoryException(category);
		}
		for (Order order: orders) {
			if (order.getCategory().equals(category)) {
				ordersByCategory.add(order);
			}
		}
		return ordersByCategory;
		
	}

	@Override
	public int getTotalOrderCost(String category) throws InvalidCategoryException {
		if (!categories.contains(category)) {
			throw new InvalidCategoryException(category);
		}
		int totalOrderCost = 0;
		for (Order order: orders) {
			if (order.getCategory().equals(category) && order.getAction().equals("delivered")) {
				totalOrderCost = totalOrderCost + order.getOrderCost();
			}
		}
		return totalOrderCost;
	}

	@Override
	public List<Order> getAllCanceledOrder() {
		List<Order> canceledOrders = new ArrayList<Order>();
		for (Order order: orders) {
			if (order.getAction().equals("cancelled")) {
				canceledOrders.add(order);
			}
		}
		return canceledOrders;
	}

	@Override
	public Map<String, List<Order>> createOrderMapByUser() {
		Map<String, List<Order> > orderMapByUser = new HashMap<String, List<Order>>();
		for (Order order: orders) {
			if (!orderMapByUser.containsKey(order.getUsername())){
				List<Order> userOrder = new ArrayList<Order>();
				userOrder.add(order);
				orderMapByUser.put(order.getUsername(), userOrder);						
			} else {
				List<Order> temp = orderMapByUser.get(order.getUsername());
				temp.add(order);
				orderMapByUser.put(order.getUsername(), temp); 
			}
		}
		return orderMapByUser;
	}

	@Override
	public List<Order> filterOrders(String action) {
		List<Order> filteredOrders = new ArrayList<Order>();
		for (Order order: orders) {
			if (order.getAction().equals(action)) {
				filteredOrders.add(order);
			}
		}
		return filteredOrders;
	}

	@Override
	public List<Order> getOrdersBasedOnOrderValue() {
		Comparator<Order> orderComparator = new Comparator<Order>(){
			@Override
			public int compare(Order o1, Order o2){
				if (o1.getOrderCost() > o2.getOrderCost()) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		List<Order> sortedOrders = orders;
		sortedOrders.sort(orderComparator);
		return sortedOrders;
	}

	@Override
	public boolean generatePDFReports() {
		
		Map<String, Integer> actionCount = new HashMap<String,Integer >();
		for (Order order: orders) {
			if (!actionCount.containsKey(order.getAction())){
				actionCount.put(order.getAction(),0);						
			} else {
				actionCount.put(order.getAction(),actionCount.get(order.getAction()) + 1);			
			}
		}		
		
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );
		PDFont font = PDType1Font.HELVETICA_BOLD;

		try {
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.setLeading(14.5f);
			contentStream.setFont( font, 12 );
			contentStream.beginText();
			contentStream.newLineAtOffset( 100, 700 );
			for (Map.Entry<String, Integer> entry : actionCount.entrySet()) {
				contentStream.showText(entry.getKey() + ": " + entry.getValue());
				contentStream.newLine();
			}
			contentStream.endText();
			contentStream.close();
			document.save("Orders Report.pdf");
			document.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
