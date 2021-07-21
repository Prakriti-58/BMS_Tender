package com.ngn.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngn.bms.model.DailySales;
import com.ngn.bms.model.DailySalesSequence;
import com.ngn.bms.repository.DailySaleRepository;
import com.ngn.bms.repository.DailySalesSequenceRepository;

@Service
public class DailySaleService {

	@Autowired
	private DailySaleRepository repo;
	
	@Autowired
	private DailySalesSequenceRepository sequenceRepo;
	
	
	public DailySales createNewDailySale(DailySales dailySale, int sequenceId) { 
		 
		DailySales newSale = repo.save(dailySale); 
			 
		if(dailySale.getCashMemoNo() != "") {
			DailySalesSequence sequence = sequenceRepo.findById(sequenceId).get();
			sequence.setSalesSequence(sequence.getSalesSequence()+1);
			sequenceRepo.save(sequence);
		}  
		return newSale;
	}
	
	public DailySales updateDailySale(DailySales dailySale) {
		DailySales newSale = repo.save(dailySale);
		return newSale;
	}
	
	public List<DailySales> getDailySaleForToday(int userId){
		return repo.getDailySaleForToday(userId);
	}
	
	public DailySalesSequence getLatestCashMemoNoByUser(String createdBy) {
		return sequenceRepo.findByUserId(createdBy);
	}
	
	public DailySales getDailySaleById(int id) {
		return repo.findById(id).get();
	}

	public List<DailySales> getWeeklySaleRport(String fromDate, String toDate, int createdBy) {
		return repo.findByDate(fromDate, toDate, createdBy);
	}

	public DailySalesSequence getLatestCashMemoNoByCashId(String createdBy, int cashId) {
		return sequenceRepo.findByCashId(createdBy, cashId);		
	}

	
}
