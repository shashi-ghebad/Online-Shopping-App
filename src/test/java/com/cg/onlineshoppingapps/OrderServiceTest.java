package com.cg.onlineshoppingapps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshoppingapps.dao.OrderJpaDao;
import com.cg.onlineshoppingapps.entity.OrderEntity;
import com.cg.onlineshoppingapps.exception.OrderDetailsNotFoundException;
import com.cg.onlineshoppingapps.service.OrderService;
import com.cg.onlineshoppingapps.service.OrderServiceImpl;

@SpringBootTest
public class OrderServiceTest {

	@InjectMocks
	OrderService iOrderService = new OrderServiceImpl();

	@Mock
	OrderJpaDao orderJpaDao;

	@Test
	public void testViewAllOrders() {

		List<OrderEntity> order = new ArrayList<>();

		order.add(new OrderEntity("Mobile"));
		Mockito.when(orderJpaDao.findAll()).thenReturn(order);
		assertEquals(1, iOrderService.viewAllOrders().size());

	}

	@Test
	public void testViewAllOrdersException() {

		List<OrderEntity> mockOrder = new ArrayList<>();

		Mockito.when(orderJpaDao.findAll()).thenReturn(mockOrder);
		Exception exception = assertThrows(OrderDetailsNotFoundException.class, () -> iOrderService.viewAllOrders());

		assertEquals("No Order Details Found!!", exception.getMessage());

	}

	@Test
	public void testaddOrder() {
		OrderEntity mockReturnOrder = new OrderEntity();
		OrderEntity returnOrder = new OrderEntity(1);

		OrderEntity mockArgumentOrder = returnOrder;
		if (mockReturnOrder.getOrderId() == 1) {
			Mockito.when(orderJpaDao.save(mockReturnOrder)).thenReturn(returnOrder);
			iOrderService.addOrder(mockArgumentOrder);
			Mockito.verify(orderJpaDao, Mockito.times(1)).save(mockReturnOrder);
		}

	}

	@Test
	public void testviewOrder() {
		OrderEntity mockReturnOrder = new OrderEntity();
		OrderEntity returnOrder = new OrderEntity(1);

		int mockArgumentOrder = 1;
		if (mockReturnOrder.getOrderId() == 1) {
			Mockito.when(orderJpaDao.save(mockReturnOrder)).thenReturn(returnOrder);
			iOrderService.viewOrder(mockArgumentOrder);
			Mockito.verify(orderJpaDao, Mockito.times(1)).save(mockReturnOrder);
		}
	}

	@Test
	public void testDeletProduct() {
		Mockito.doNothing().when(orderJpaDao).deleteById(1);
		iOrderService.removeOrder(1);
		Mockito.verify(orderJpaDao, Mockito.times(1)).deleteById(1);
	}

	@Test
	public void testUpdateProduct() {
		OrderEntity mockReturnOrder = new OrderEntity();
		OrderEntity returnOrder = new OrderEntity(1);

		OrderEntity mockArgumentOrder = returnOrder;
		if (mockReturnOrder.getOrderId() == 1) {
			Mockito.when(orderJpaDao.save(mockReturnOrder)).thenReturn(returnOrder);
			iOrderService.addOrder(mockArgumentOrder);
			Mockito.verify(orderJpaDao, Mockito.times(1)).save(mockReturnOrder);
		}

	}
}
