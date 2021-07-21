package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ngn.bms.model.DailySales;
import com.ngn.bms.model.DailySalesSequence;

public interface DailySaleRepository extends JpaRepository<DailySales, Integer> {

	@Query(value = "SELECT * FROM daily_sales a WHERE a.`created_on`=CURRENT_DATE AND a.created_by=?1", nativeQuery = true)
	List<DailySales> getDailySaleForToday(int userId);
	
	@Query(value = "SELECT * FROM daily_sales a WHERE a.`cash_memo_no` <> '' ORDER BY a.`id` DESC LIMIT 1", nativeQuery = true)
	DailySales getLatestCashMemoNoByUser(String createdBy);

	@Query(value = "SELECT * FROM daily_sales a WHERE a.created_on BETWEEN ?1 AND ?2 AND a.created_by = ?3", nativeQuery = true)
	List<DailySales> findByDate(String fromDate, String toDate, int createdBy);
}
