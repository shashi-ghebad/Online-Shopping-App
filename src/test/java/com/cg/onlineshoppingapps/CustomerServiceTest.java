package com.cg.onlineshoppingapps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshoppingapps.dao.CustomerJpaDao;
import com.cg.onlineshoppingapps.entity.CustomerEntity;
import com.cg.onlineshoppingapps.exception.CustomerDetailsNotFoundException;
import com.cg.onlineshoppingapps.service.CustomerService;
import com.cg.onlineshoppingapps.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {
	@InjectMocks
	CustomerService iCustomerService = new CustomerServiceImpl();

	@Mock
	CustomerJpaDao customerJpaDao;

	@Test
	public void testViewAllCustomers() {

		List<CustomerEntity> customer = new ArrayList<>();

		customer.add(new CustomerEntity("Sangram"));
		Mockito.when(customerJpaDao.findAll()).thenReturn(customer);
		assertEquals(1, iCustomerService.ViewAllCustomers().size());

	}

	@Test
	public void testViewAllCustomerException() {

		List<CustomerEntity> mockCustomer = new ArrayList<>();

		Mockito.when(customerJpaDao.findAll()).thenReturn(mockCustomer);
		Exception exception = assertThrows(CustomerDetailsNotFoundException.class, () -> iCustomerService.ViewAllCustomers());

		assertEquals("No Customer Found!!", exception.getMessage());

	}

	@Test
	public void testaddCustomer() {

		CustomerEntity mockReturnCustomer = new CustomerEntity();

		mockReturnCustomer.setCustomerId(1);
		mockReturnCustomer.setFirstName("Sangram");
		mockReturnCustomer.setLastName("patil");

		CustomerEntity mockArgumentCustomer = new CustomerEntity();

		mockArgumentCustomer.setCustomerId(1);
		mockArgumentCustomer.setFirstName("Sangram");
		mockArgumentCustomer.setLastName("Patil");

		Mockito.when(customerJpaDao.save(mockArgumentCustomer)).thenReturn(mockReturnCustomer);
		assertEquals(1, customerJpaDao.save(mockArgumentCustomer).getCustomerId());

	}

	@Test
	public void testViewCustomer()
	{

		CustomerEntity mockReturnCustomer = new CustomerEntity();

		mockReturnCustomer.setCustomerId(1);
		mockReturnCustomer.setFirstName("Sangram");
		mockReturnCustomer.setLastName("patil");

		Mockito.when(customerJpaDao.findById(1)).thenReturn(Optional.of(mockReturnCustomer));

		// assertNotNull(productJpaDao.getById(1));
		assertEquals(1, iCustomerService.viewCustomer(1).getCustomerId());
	}

	@Test
	public void testRemoveCustomer()
	{

		Mockito.doNothing().when(customerJpaDao).deleteById(1);
		iCustomerService.removeCustomer(1);
		Mockito.verify(customerJpaDao, Mockito.times(1)).deleteById(1);

	}

	@Test
	public void testupdateCustomer() {

		CustomerEntity mockReturnCustomer= new CustomerEntity();
		mockReturnCustomer.setCustomerId(1);
		mockReturnCustomer.setFirstName("Sangram");
		mockReturnCustomer.setLastName("Patil");

		CustomerEntity mockArgumentCustomer = new CustomerEntity();
		mockArgumentCustomer.setCustomerId(1);
		mockArgumentCustomer.setFirstName("Sangram");
		mockArgumentCustomer.setLastName("Patil");

		Mockito.when(customerJpaDao.save(mockArgumentCustomer)).thenReturn(mockReturnCustomer);
		iCustomerService.updateCustomer(mockArgumentCustomer);

		Mockito.verify(customerJpaDao, Mockito.times(1)).save(mockArgumentCustomer);

	}
}
