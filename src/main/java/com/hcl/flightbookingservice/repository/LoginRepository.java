package com.hcl.flightbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.flightbookingservice.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	@Query(value = "select * from logindetails where user_name =?1", nativeQuery = true)
	Login findByUserName(String userName);

}
