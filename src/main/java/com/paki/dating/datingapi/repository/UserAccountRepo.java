package com.paki.dating.datingapi.repository;

//import java.util.List;

import com.paki.dating.datingapi.entity.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

    /*
     * // custom abstract method
     * 
     * @Query("from UserAccount where age=:age and city=:city and country=:country and !id=:id"
     * )
     * List<UserAccount> findMatches(@Param("age") int age, @Param("city") String
     * city,
     * 
     * @Param("country") String country, @Param("id") int id);
     * 
     */

}
