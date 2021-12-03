package com.paki.dating.datingapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;

import com.paki.dating.datingapi.controller.UserAccountController;
import com.paki.dating.datingapi.entity.UserAccount;
import com.paki.dating.datingapi.repository.InterestRepo;
import com.paki.dating.datingapi.repository.UserAccountRepo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatingapiApplicationTests {

	@Mock
	UserAccountRepo userAccountRepo;

	@Mock
	InterestRepo interestRepo;

	@InjectMocks
	UserAccountController controller;

	@Test
	void testRegisterUser() {
		UserAccount userAccount = new UserAccount();
		userAccount.setCountry("Bosnia");
		userAccount.setCity("Derventa");
		UserAccount savedUserAccount = new UserAccount();
		savedUserAccount.setId(123);
		when(userAccountRepo.save(userAccount)).thenReturn(savedUserAccount);

		UserAccount outpuUserAccount = controller.registerUser(userAccount);

		assertNotNull(outpuUserAccount);
		assertNotNull(outpuUserAccount.getId());

		assertEquals(123, outpuUserAccount.getId());

		verify(userAccountRepo).save(userAccount);

	}

	/*
	 * public void testFindMatches(){
	 * //input informations, precondition
	 * UserAccount userAccount=new UserAccount();
	 * userAccount.setId(123);
	 * userAccount.setAge(20);
	 * userAccount.setCity("Derventa");
	 * userAccount.setCountry("Germany");
	 * when(userAccountRepo.findById(123)).thenReturn(Optional.of(userAccount));
	 * when(userAccountRepo.findMatches(20, "Derventa", "Germany", 123))
	 * .thenReturn(new ArrayList <UserAccount> ());
	 * 
	 * 
	 * List<UserAccount> outputMatches =controller.findMatches(123);
	 * }
	 * 
	 */

	public void testDeleteInterest() {

		controller.deleteInterest(123);

	}

	/*
	 * public void testFindAll(){
	 * controller.
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @Test
	 * public void testFindOne(){
	 * //input information
	 * UserAccount userAccount=new UserAccount();
	 * userAccount.setId(123);
	 * userAccount.setAge(20);
	 * userAccount.setCity("New York");
	 * userAccount.setCountry("America");
	 * 
	 * ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //what is really methods and implementation, return User with id number
	 * when(userAccountRepo.findById(123)).thenReturn(Optional.of(userAccount));
	 * 
	 * //return array with parametars
	 * when(userAccountRepo.findMatches(20, "New York", "America", 123))
	 * .thenReturn(userAccounts);
	 * 
	 * 
	 * 
	 * //relation betwwen test class and method
	 * controller.findMatches(123);
	 * 
	 * 
	 * }
	 * 
	 */

}
