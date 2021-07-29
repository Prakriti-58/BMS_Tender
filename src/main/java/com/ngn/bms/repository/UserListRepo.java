package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.UserList;


@Repository
public interface UserListRepo extends JpaRepository<UserList, Integer>{

	UserList findByUserId(String username);

	@Query(value = "SELECT \r\n" + 
			"  * \r\n" + 
			"FROM\r\n" + 
			"  `user_details` a \r\n" + 
			"  LEFT JOIN `employee_details` b \r\n" + 
			"    ON a.`emp_id` = b.`id` \r\n" + 
			"  LEFT JOIN `divisions` c \r\n" + 
			"    ON b.`division_id` = c.`id` \r\n" + 
			"  LEFT JOIN `designation` d \r\n" + 
			"    ON b.`designation_id` = d.`id` \r\n" + 
			"WHERE b.`designation_id` = ?1",nativeQuery = true)
	List<UserList> findAllTechician(int designationId);

}
