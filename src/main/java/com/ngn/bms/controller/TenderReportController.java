package com.ngn.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngn.bms.service.TenderService;

@RestController
@RequestMapping("tender_report")
@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.124.242", "http://103.80.111.102" })
public class TenderReportController {

	@Autowired
	private TenderService tenderService;

	@GetMapping("getUserByDivisionIdWin/{division_id}/{t_status}") // for reference
	public List<ObjectNode> getUserByDivisionIdWin(@PathVariable int division_id,@PathVariable String t_status) {
		return tenderService.getUserByDivision(division_id,t_status);
	}
	
	@GetMapping("getUserByDivisionIdLost/{division_id}/{t_status}") // for reference
	public List<ObjectNode> getUserByDivisionIdLost(@PathVariable int division_id,@PathVariable String t_status) {
		return tenderService.getUserByDivisionIdLost(division_id,t_status);
	}
	
	@GetMapping("getUserTotalTender/{division_id}") // for reference
	public List<ObjectNode> getUserTotalTender(@PathVariable int division_id) {
		return tenderService.getUserTotalTender(division_id);
	}

	@GetMapping("getUserTenderDetail/{t_status}/{t_tender_stage}/{updated_by}/{fromDate}/{toDate}") // for reference
	public List<ObjectNode> getUserTenderDetail(@PathVariable String t_status, @PathVariable int t_tender_stage,
			@PathVariable int updated_by, @PathVariable String fromDate, @PathVariable String toDate) {
		return tenderService.getUserTenderDetail(t_status, t_tender_stage, updated_by, fromDate, toDate);
	}
	
	@GetMapping("getUserTotalTender/{updated_by}/{fromDate}/{toDate}")
	public List<ObjectNode> getUserTotalTender(@PathVariable int updated_by, @PathVariable String fromDate, @PathVariable String toDate) {
		return tenderService.getUserTotalTender(updated_by, fromDate, toDate);
	}
	
	@GetMapping("getTotalWinTender/{fromDate}/{toDate}")
	public List<ObjectNode> getTotalWinTender(@PathVariable String fromDate, @PathVariable String toDate) {
		return tenderService.getTotalWinTender(fromDate, toDate);
	}
	
	@GetMapping("getTotalLostTender/{fromDate}/{toDate}")
	public List<ObjectNode> getTotalLostTender(@PathVariable String fromDate, @PathVariable String toDate) {
		return tenderService.getTotalLostTender(fromDate, toDate);
	}

}
