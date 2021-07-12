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

import com.cg.onlineshoppingapps.dao.AddressJpaDao;
import com.cg.onlineshoppingapps.entity.AddressEntity;
import com.cg.onlineshoppingapps.exception.AddressNotFoundException;
import com.cg.onlineshoppingapps.service.AddressService;
import com.cg.onlineshoppingapps.service.AddressServiceImpl;

@SpringBootTest
public class AddressServiceTest {
	@InjectMocks
	AddressService iAddressService = new AddressServiceImpl();

	@Mock
	AddressJpaDao addressJpaDao;

	@Test
	public void testViewAllAddress() {

		List<AddressEntity> address = new ArrayList<>();

		address.add(new AddressEntity("Mahal"));
		Mockito.when(addressJpaDao.findAll()).thenReturn(address);
		assertEquals(1, iAddressService.viewAllAddress().size());

	}

	@Test
	public void testViewAllAddressException() {

		List<AddressEntity> mockAddress = new ArrayList<>();

		Mockito.when(addressJpaDao.findAll()).thenReturn(mockAddress);
		Exception exception = assertThrows(AddressNotFoundException.class, () -> iAddressService.viewAllAddress());

		assertEquals("No Address Found!!", exception.getMessage());

	}

	@Test
	public void testAddAddress() {

		AddressEntity mockReturnAddress = new AddressEntity();

		mockReturnAddress.setAddressId(1);
		mockReturnAddress.setBuildingName("Mahal");

		AddressEntity mockArgumentAddress = new AddressEntity();

		mockArgumentAddress.setAddressId(1);
		mockArgumentAddress.setBuildingName("Mahal");

		Mockito.when(addressJpaDao.save(mockArgumentAddress)).thenReturn(mockReturnAddress);
		assertEquals(1, addressJpaDao.save(mockArgumentAddress).getAddressId());

	}

	@Test
	public void testviewAddress() {

		AddressEntity mockReturnAddress = new AddressEntity();
		AddressEntity returnCustomer = new AddressEntity(1);

		int mockArgumentAddress = 1;
		if (mockReturnAddress.getAddressId() == 1) {
			Mockito.when(addressJpaDao.save(mockReturnAddress)).thenReturn(returnCustomer);
			iAddressService.viewAddress(mockArgumentAddress);
			Mockito.verify(addressJpaDao, Mockito.times(1)).save(mockReturnAddress);
		}
	}

	@Test
	public void testRemoveAddress() {

		Mockito.doNothing().when(addressJpaDao).deleteById(1);
		iAddressService.removeAddress(1);
		Mockito.verify(addressJpaDao, Mockito.times(1)).deleteById(1);

	}

	@Test
	public void testupdateAddress() {

		AddressEntity mockReturnAddress = new AddressEntity();
		mockReturnAddress.setAddressId(1);
		mockReturnAddress.setBuildingName("Mahal");

		AddressEntity mockArgumentAddress = new AddressEntity();
		mockArgumentAddress.setAddressId(1);
		mockArgumentAddress.setBuildingName("Mahal");

		Mockito.when(addressJpaDao.save(mockArgumentAddress)).thenReturn(mockReturnAddress);
		iAddressService.updateAddress(mockArgumentAddress);

		Mockito.verify(addressJpaDao, Mockito.times(1)).save(mockArgumentAddress);

	}
}