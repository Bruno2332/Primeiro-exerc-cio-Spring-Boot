package com.devsuperior.aula.services;

import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Order;

@Service
public class ShippingService {
	
	public Double shipment(Order order) {
		if (order.getBasic() < 100) {
			return 20.0;
		} else if (order.getBasic() >= 100 && order.getBasic() < 200) {
			return 12.0;
		} else {
			return 0.0;
		}
	}
}
