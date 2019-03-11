package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data");
		
		System.out.print("Name: ");
		String clientName = scan.nextLine();
		
		System.out.print("Email: ");
		String clientEmail = scan.nextLine();
		
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDay = sdf.parse(scan.next());
		
		//Cliente instanciado!
		Client client = new Client(clientName, clientEmail, birthDay);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		
		//OrderStatus intanciada!
		OrderStatus status = OrderStatus.valueOf(scan.next());
		
		//Order Instanciado!
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order: ");
		int n = scan.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #" + i + " item data");
			System.out.print("Product name: ");
			scan.nextLine();
			String productName = scan.nextLine();
			
			System.out.println("Product price: ");
			double productPrice = scan.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity ");
			int quantity = scan.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
		scan.close();
	}

}
