package com.ngn.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngn.bms.model.DailySales;
import com.ngn.bms.model.DailySalesSequence;
import com.ngn.bms.service.DailySaleService;

@RestController
@RequestMapping("/daily-sale")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
public class DailySaleController {

	@Autowired
	private DailySaleService service;
	
	@GetMapping("/{userId}/byUser")
	public ResponseEntity<List<DailySales>> getDailySaleForToday(@PathVariable int userId){
		return new ResponseEntity<List<DailySales>>(service.getDailySaleForToday(userId), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/byRowId")
	public ResponseEntity<DailySales> getDailySaleById(@PathVariable int id){
		return new ResponseEntity<DailySales>(service.getDailySaleById(id), HttpStatus.OK);
	}
	
	@PostMapping("/{sequenceId}")
	public ResponseEntity<DailySales> createNewDailySale(@RequestBody DailySales dailySale, @PathVariable int sequenceId){
		DailySales newSale = service.createNewDailySale(dailySale, sequenceId);
		return new ResponseEntity<DailySales>(newSale, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<DailySales> createNewDailySale(@RequestBody DailySales dailySale){
		DailySales newSale = service.updateDailySale(dailySale);
		return new ResponseEntity<DailySales>(newSale, HttpStatus.OK);
	}
	
	@GetMapping("/{createdBy}/latestSequence")
	public DailySalesSequence getLatestCashMemoNoByUser(@PathVariable String createdBy) {
		return service.getLatestCashMemoNoByUser(createdBy);
	}
	
	
	@GetMapping("/{createdBy}/{cashId}/latestSequence")
	public DailySalesSequence getLatestCashMemoNoByCashId(@PathVariable String createdBy,@PathVariable int cashId) {
		return service.getLatestCashMemoNoByCashId(createdBy,cashId);
	}
	
	@GetMapping("/weeklyReport/{fromDate}/{toDate}/{createdBy}")
	public List<DailySales> getWeeklySaleRport(@PathVariable String fromDate, @PathVariable String toDate, @PathVariable int createdBy) {
		return service.getWeeklySaleRport(fromDate, toDate, createdBy);
	}
	
}
