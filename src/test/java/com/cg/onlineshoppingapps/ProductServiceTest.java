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

import com.cg.onlineshoppingapps.dao.ProductJpaDao;
import com.cg.onlineshoppingapps.entity.ProductEntity;
import com.cg.onlineshoppingapps.exception.ProductNotFoundException;
import com.cg.onlineshoppingapps.service.ProductService;
import com.cg.onlineshoppingapps.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceTest {

	@InjectMocks
	ProductService iProductService = new ProductServiceImpl();

	@Mock
	ProductJpaDao productJpaDao;

	@Test
	public void testViewAllProducts() {

		List<ProductEntity> product = new ArrayList<>();

		product.add(new ProductEntity("Mobile"));
		Mockito.when(productJpaDao.findAll()).thenReturn(product);
		assertEquals(1, iProductService.viewAllProducts().size());

	}

	@Test
	public void testViewAllProductsException() {

		List<ProductEntity> mockProducts = new ArrayList<>();

		Mockito.when(productJpaDao.findAll()).thenReturn(mockProducts);
		Exception exception = assertThrows(ProductNotFoundException.class, () -> iProductService.viewAllProducts());

		assertEquals("Products Not Found", exception.getMessage());

	}

	@Test
	public void testAddProduct() {

		ProductEntity mockReturnProduct = new ProductEntity();

		mockReturnProduct.setProductId(1);
		mockReturnProduct.setProductName("Mobile");

		ProductEntity mockArgumentProduct = new ProductEntity();

		mockArgumentProduct.setProductId(1);
		mockArgumentProduct.setProductName("laptop");

		Mockito.when(productJpaDao.save(mockArgumentProduct)).thenReturn(mockReturnProduct);
		assertEquals(1, productJpaDao.save(mockArgumentProduct).getProductId());

	}

	@Test
	public void testGetProduct() {

		ProductEntity mockReturnProduct = new ProductEntity();
		

		mockReturnProduct.setProductId(1);
		mockReturnProduct.setProductName("mobile");

		Mockito.when(productJpaDao.findById(1)).thenReturn(Optional.of(mockReturnProduct));

		//assertNotNull(productJpaDao.getById(1));
		assertEquals(1, iProductService.viewProductsByProductId(1).getProductId());
	}

	@Test
	public void testDeletProduct() {

		Mockito.doNothing().when(productJpaDao).deleteById(1);
		iProductService.removeProduct(1);
		Mockito.verify(productJpaDao, Mockito.times(1)).deleteById(1);

	}

	@Test
	public void testUpdateProduct() {

		ProductEntity mockReturnProduct = new ProductEntity();
		mockReturnProduct.setProductId(1);
		mockReturnProduct.setProductName("Mobile");

		ProductEntity mockArgumentProduct = new ProductEntity();
		mockArgumentProduct.setProductId(1);
		mockArgumentProduct.setProductName("Bag");

		Mockito.when(productJpaDao.save(mockArgumentProduct)).thenReturn(mockReturnProduct);
		iProductService.updateProduct(mockArgumentProduct);

		Mockito.verify(productJpaDao, Mockito.times(1)).save(mockArgumentProduct);

	}
}
