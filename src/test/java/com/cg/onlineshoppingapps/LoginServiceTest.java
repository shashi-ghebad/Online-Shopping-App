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

import com.cg.onlineshoppingapps.dao.LoginJpaDao;
import com.cg.onlineshoppingapps.entity.UserEntity;
import com.cg.onlineshoppingapps.exception.UserNotFoundException;
import com.cg.onlineshoppingapps.service.LoginService;
import com.cg.onlineshoppingapps.service.LoginServiceImpl;

@SpringBootTest
public class LoginServiceTest {

	@InjectMocks
	LoginService iLoginService = new LoginServiceImpl();

	@Mock
	LoginJpaDao loginJpaDao;

	@Test
	public void testGetAllUsers() {

		List<UserEntity> user = new ArrayList<>();

		user.add(new UserEntity("Admin"));
		Mockito.when(loginJpaDao.findAll()).thenReturn(user);
		assertEquals(1, iLoginService.getAllUsers().size());

	}

	@Test
	public void testGetAllUsersException() {

		List<UserEntity> mockUser = new ArrayList<>();

		Mockito.when(loginJpaDao.findAll()).thenReturn(mockUser);
		Exception exception = assertThrows(UserNotFoundException.class, () -> iLoginService.getAllUsers());

		assertEquals("No User Found!!", exception.getMessage());

	}

	@Test
	public void testAddUser() {
		UserEntity mockReturnUser = new UserEntity();
		UserEntity returnUser = new UserEntity("sangram");

		UserEntity mockArgumentUser = returnUser;
		if (mockReturnUser.getUsername() == "sangram") {
			Mockito.when(loginJpaDao.save(mockReturnUser)).thenReturn(returnUser);
			iLoginService.addUser(mockArgumentUser);
			Mockito.verify(loginJpaDao, Mockito.times(1)).save(mockReturnUser);
		}

	}

}
