package com.ngn.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngn.bms.model.Warranty;
import com.ngn.bms.service.WarrantyService;

@RestController
@RequestMapping("/warranty")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
public class WarrantyController {
	
	@Autowired
	private WarrantyService warrantyService;
	
	@PostMapping("/save")
	public ResponseEntity<Warranty> saveWarrantyDetails (@RequestBody Warranty warranty){
		return warrantyService.postWarrantyDetails(warranty);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Warranty>> getWarrantyList (){
		return warrantyService.getWarrantyList();
	}
	
	@GetMapping("/by-customer/{customerName}")
	public ResponseEntity<List<Warranty>> getwarrantybyCustomer (@PathVariable String customerName ){
		return warrantyService.getwarrantybyCustomer(customerName);
	}
	@GetMapping("/by-Id/{warrantyId}")
	public ResponseEntity<Warranty> getwarrantybyId (@PathVariable int warrantyId ){
		return warrantyService.getwarrantybyId(warrantyId);
	}
	
	
	@GetMapping("/by-SerialNo/{SerialNo}")
	public ResponseEntity<Warranty> getWarrantyBySerialNo (@PathVariable String SerialNo){
		return warrantyService.getWarrantyBySerialNo(SerialNo);
	}
	
	@PutMapping(value = "/{warrantyId}")
	public ResponseEntity<Warranty> updateWarranty (@RequestBody Warranty warranty,@PathVariable int warrantyId){
		return warrantyService.updateWarranty(warrantyId,warranty);
	}
	
	@DeleteMapping("/delete/{warrantyId}")
	public ResponseEntity<Warranty> deleteWarranty (@RequestBody Warranty warranty, @PathVariable int warrantyId){
		return warrantyService.deleteWarranty(warrantyId,warranty);
	}
}
	
