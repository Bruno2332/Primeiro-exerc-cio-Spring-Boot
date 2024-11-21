package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Order;

@Service	
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;

	public Double total(Order order) {
		double calc = order.getBasic() * order.getDiscount() / 100;
		return order.getBasic() - calc + shippingService.shipment(order);
		
	}

	public ShippingService getShippingService() {
		return shippingService;
	}
	
	
	

}
