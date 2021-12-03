package com.paki.dating.datingapi.controller;

import java.util.List;

import com.paki.dating.datingapi.entity.Interest;
import com.paki.dating.datingapi.entity.UserAccount;
import com.paki.dating.datingapi.repository.InterestRepo;
import com.paki.dating.datingapi.repository.UserAccountRepo;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import lombok.extern.java.Log;
//import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
public class UserAccountController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory
            .getLogger(UserAccountController.class);

    @Autowired
    private UserAccountRepo userRepo;

    @Autowired
    private InterestRepo interestRepo;

    @PostMapping("/users/register-user")
    public UserAccount registerUser(@RequestBody UserAccount userAccount) {
        log.info("Way to register new User");
        return (UserAccount) userRepo.save(userAccount);

    }

    @PostMapping("/interest/update")
    public Interest updateInterest(@RequestBody Interest interest) {
        log.info("Way to update interest of User");
        UserAccount userAccount = userRepo.findById(interest.getUserAccountId()).get();
        interest.setUserAccount(userAccount);
        return interestRepo.save(interest);

    }

    @GetMapping("/users/get/all")
    List<UserAccount> getUsers() {
        log.info("Way yo show us all register Users");
        return userRepo.findAll();

    }

    /*
     * public List<UserAccount> findMatches(int id) {
     * log.info("Way to find only one User");
     * UserAccount userAccount = userRepo.findById(id).get();
     * return userRepo.findMatches(userAccount.getAge(), userAccount.getCity(),
     * userAccount.getCountry(), userAccount.getId());
     * 
     * }
     * 
     */

    @DeleteMapping("/users/delete/{id}")
    public void deleteInterest(@PathVariable("id") int id) {
        log.info("Way to delete User");
        interestRepo.deleteById(id);

    }

}
