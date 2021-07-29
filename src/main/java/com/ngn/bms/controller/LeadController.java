package com.ngn.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import com.ngn.bms.model.Lead;
import com.ngn.bms.model.LeadFollowUp;
import com.ngn.bms.model.LeadSaveModel;
import com.ngn.bms.model.Tenders;
import com.ngn.bms.repository.LeadFollowUpRepository;
import com.ngn.bms.repository.LeadRepository;
import com.ngn.bms.repository.LeadSaveModelRepo;
import com.ngn.bms.service.LeadService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
public class LeadController {

	@Autowired
	private LeadRepository leadRepository;

	@Autowired
	private LeadFollowUpRepository leadFollowUpRepository;

	@Autowired
	private LeadService leadService;

	@Autowired
	private LeadSaveModelRepo leadRepo;

	@GetMapping("leadList")
	public List<Lead> getLeadList() {
		return leadRepository.getAll();

	}

	@GetMapping("leadById/{id}")
	public Lead getLeadById(@PathVariable Integer id) {
		return leadRepository.findById(id).orElse(null);

	}

	@GetMapping("acknowledgedLeadByUserId/{userId}") // acknowledged lead that display at user lead dash board
	public List<Lead> getLeadByUserId(@PathVariable int userId) {
		return leadRepository.findByForwardedTo(userId);

	}

	@GetMapping("notAcknowledgedLeadByUserId/{userId}") 
	public List<Lead> leadNotAcknownledge(@PathVariable int userId) {
		return leadRepository.leadNotAcknownledge(userId);

	}

	@GetMapping("opportunityList")
	public List<Lead> getOpportunityList() {
		return leadRepository.getAllOpportunities();

	}

	@PostMapping("leadUpdate") // Add,Update and Delete lead
	public LeadSaveModel addNewLead(@RequestBody LeadSaveModel leadData) {
		return leadRepo.save(leadData); 
	}
 
	@GetMapping("/updateTenderInLead/{lead_id}")
	public ResponseEntity<Object> closeTenerById(@PathVariable int lead_id) throws IOException {
		LeadSaveModel lead = leadRepo.findById(lead_id).orElse(null);
		lead.setActive("N");
		lead.setLeadStatus("tender");
		leadRepo.save(lead); 
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	

	@PostMapping("addLeadFollowUp")
	public LeadFollowUp addLeadFollowUp(@RequestBody LeadFollowUp followUpData) {
		return leadFollowUpRepository.save(followUpData);

	}

	@GetMapping("leadFollowUp/{leadId}")
	public List<LeadFollowUp> getLeadFollowUp(@PathVariable int leadId) {
		return leadFollowUpRepository.findByleadId(leadId);

	}

	@GetMapping("tenderList")
	public List<Lead> getTenderList() {
		return leadRepository.getAllTender();

	}

}
