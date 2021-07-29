package com.ngn.bms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ngn.bms.model.Warranty;
import com.ngn.bms.repository.WarrantyRepo;

@Service
public class WarrantyService {

	@Autowired
	private WarrantyRepo warrantyRepo;

	public ResponseEntity<Warranty> postWarrantyDetails(Warranty warranty) {

		try {
			Warranty newWarranty = new Warranty();
			newWarranty = warrantyRepo.save(warranty);
			return new ResponseEntity<Warranty>(newWarranty, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Warranty>(HttpStatus.PARTIAL_CONTENT);
		}
	}

	public ResponseEntity<List<Warranty>> getWarrantyList() {

		try {
			List<Warranty> warrantyList = new ArrayList<Warranty>();
			warrantyList = warrantyRepo.findAll();
			return new ResponseEntity<List<Warranty>>(warrantyList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Warranty>>(HttpStatus.NO_CONTENT);
		}

	}

	public ResponseEntity<Warranty> getwarrantybyId(int warrantyId) {

		try {
			Warranty newWarrantybyId = new Warranty();
			newWarrantybyId = warrantyRepo.findById(warrantyId).orElse(null);
			return new ResponseEntity<Warranty>(newWarrantybyId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Warranty>(HttpStatus.NOT_FOUND);
		}

	}

	 

	public ResponseEntity<Warranty> getWarrantyBySerialNo(String serialNo) {

		try {
			Warranty newWarrantyBySerialNo = new Warranty();
			newWarrantyBySerialNo = warrantyRepo.findAllByModelSerialNo(serialNo);
			return new ResponseEntity<Warranty>(newWarrantyBySerialNo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Warranty>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<Warranty> updateWarranty(int warrantyId,Warranty warranty) {
		
		try {
			Warranty newWarrantybyId = warrantyRepo.findById(warrantyId).orElse(null);
			if(newWarrantybyId != null) { 
				warranty.setId(warrantyId);
				warrantyRepo.save(warranty);
			}
			return new ResponseEntity<Warranty>(newWarrantybyId,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Warranty>(HttpStatus.NOT_MODIFIED);
		}
		
	}

	public ResponseEntity<Warranty> deleteWarranty(int warrantyId, Warranty warranty) {
		try {
			 
			warranty.setId(warrantyId);
			warranty.setStatus("N");
			warrantyRepo.save(warranty);
			 
			return new ResponseEntity<Warranty>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Warranty>(HttpStatus.NOT_MODIFIED);
		}
	}

	public ResponseEntity<List<Warranty>> getwarrantybyCustomer(String customerName) {
		try {
			List<Warranty> warrantybyCustomer = new ArrayList<Warranty>();
			warrantybyCustomer = warrantyRepo.findByCustomerName(customerName);
			return new ResponseEntity<List<Warranty>>(warrantybyCustomer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Warranty>>(HttpStatus.NO_CONTENT);
		}
	}
}