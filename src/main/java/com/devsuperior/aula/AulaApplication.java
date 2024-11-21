package com.devsuperior.aula;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.services.OrderService;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner{
	
	
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println();
			System.out.println("Dados do Pedido");
			System.out.print("Código: ");
			int codigo = sc.nextInt();
			System.out.print("Valor basico: ");
			double valor = sc.nextDouble();
			System.out.print("Porcentagem de desconto: ");
			double desconto = sc.nextDouble();
			
			Order order = new Order(codigo, valor, desconto);
			
			System.out.println();
			System.out.println("Pedido código: " + order.getCode());
			System.out.printf("Valor Total: R$ %.2f", orderService.total(order));
			System.out.println();
			System.out.println();
		}
		
		sc.close();
	}

}
