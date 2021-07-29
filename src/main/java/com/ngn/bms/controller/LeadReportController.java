package com.ngn.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngn.bms.service.LeadReportServices;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
@RequestMapping("report")
public class LeadReportController {
	
	@Autowired
	private LeadReportServices leadReportService;	
	
	@GetMapping("/tender/{userId}/{queryType}/{fromDate}/{toDate}/{division}")// for reference
	public  List<ObjectNode> getCEO(@PathVariable int userId,@PathVariable String queryType,@PathVariable String fromDate, @PathVariable String toDate,@PathVariable int division){
		return leadReportService.getReport(userId,queryType,fromDate,toDate,division);
	} 
	
	@GetMapping("/funnelReport/{fromDate}/{toDate}")// for reference
	  public  List<ObjectNode> getFunnelReport(@PathVariable String fromDate, @PathVariable String toDate){
	    return leadReportService.funnelReport(fromDate,toDate);
	 }
}
