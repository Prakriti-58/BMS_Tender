package com.ngn.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngn.bms.model.DailySales;
import com.ngn.bms.model.DailySalesRequest;
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
	
	public DailySales updatePaymentDetails(DailySalesRequest request) {
		String format = "";
		DailySales newSales = new DailySales();
		DailySalesSequence sequence = new DailySalesSequence();
		
		if(request.getCreatedBy() == 12) {
			sequence = sequenceRepo.findByCashId(Integer.toString(request.getCreatedBy()), 0);
			format = "CM(S)/2021/0";
		} else {
			sequence = sequenceRepo.findByCashId(Integer.toString(request.getCreatedBy()), request.getCashMemoType());
			
			if(request.getCashMemoType() == 1) {
				format = "CM(T)/2021/0";
			} else {
				format = "CM(X)/2021/0";
			}
		}
			
		newSales.setCashAmount(request.getCashAmount());
		newSales.setCashMemoNo(format+(sequence.getSalesSequence()+1));
		newSales.setCreatedBy(request.getCreatedBy());
		newSales.setFile_path(request.getFilePath());
		newSales.setSaleType("cash");
		newSales.setRemarks("Payment Scanner App");
		
		newSales = repo.save(newSales);
		
		sequence = sequenceRepo.findById(sequence.getId()).get();
		sequence.setSalesSequence(sequence.getSalesSequence()+1);
		sequenceRepo.save(sequence);
		
		return newSales;
	}

	public List<DailySales> getDailySaleForTodaySigned(int userId,String status) {
		return repo.getDailySaleForTodaySigned(userId,status);
	}
	
	public List<DailySales> getDailySaleUnsigned(int userId,String status) {
		return repo.getDailySaleUnsigned(userId,status);
	}


}
