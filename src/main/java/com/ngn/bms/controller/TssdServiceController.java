package com.ngn.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngn.bms.model.EmployeeDetails;
import com.ngn.bms.model.ServiceDetailModel;
import com.ngn.bms.model.ServiceRegisterModel;
import com.ngn.bms.model.TssdJobSeq;
import com.ngn.bms.model.TssdSparePart;
import com.ngn.bms.model.TssdSparePartCategory;
import com.ngn.bms.model.TssdSparePartIncluded;
import com.ngn.bms.model.UserList;
import com.ngn.bms.repository.EmployeeRepo;
import com.ngn.bms.repository.ServiceDetailModelRepo;
import com.ngn.bms.repository.ServiceRegisterModelRepo;
import com.ngn.bms.repository.TssdJobSeqRepo;
import com.ngn.bms.repository.TssdSparePartCategoryRepo;
import com.ngn.bms.repository.TssdSparePartIncludedRepo;
import com.ngn.bms.repository.TssdSparePartRepo;
import com.ngn.bms.repository.UserListRepo;
import com.ngn.bms.service.TssdService;

@RestController
@RequestMapping("tssd")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
public class TssdServiceController {

	@Autowired
	private ServiceDetailModelRepo serviceDetailModelRepo;
	
	@Autowired
	private ServiceRegisterModelRepo serviceRegisterModelRepo;
	
	@Autowired
	private TssdJobSeqRepo tssdJobSeqRepo;
	
	@Autowired
	private UserListRepo userListRepo;
	
	@Autowired
	private TssdService tssdService;
	
	@Autowired
	private TssdSparePartRepo sparePartRepo;
	
	@Autowired
	private TssdSparePartCategoryRepo sparePartCategoryRepo;
	
	@Autowired
	private TssdSparePartIncludedRepo tssdSparePartIncludedRepo;
	
	
	@PostMapping("/service-register")
	public ServiceRegisterModel registerService(@RequestBody ServiceRegisterModel entity){
		return serviceRegisterModelRepo.save(entity);
	}
	
	@PostMapping("/service-detail")
	public ServiceDetailModel addServiceDetail(@RequestBody ServiceDetailModel entity){
		return serviceDetailModelRepo.save(entity);
	}
	// tssd sequence generation
	@GetMapping("/service-sequence/{initial}")
	public TssdJobSeq getTssdJobSeq(@PathVariable String initial){
		return tssdJobSeqRepo.findByInitial(initial);
	}
	
	@PostMapping("/service-sequence/{seq}")
	public TssdJobSeq updateTssdJobSeq(@RequestBody TssdJobSeq entity,@PathVariable int seq){
		entity.setSequence(seq+1);
		return tssdJobSeqRepo.save(entity);
	}
	
	@GetMapping("/service-register")
	public List<ServiceRegisterModel> registerService(){
		return serviceRegisterModelRepo.findAllOrderByIdDesc();
	}
	
	@GetMapping("/service-completed")
	public List<ServiceRegisterModel> completedService(){
		return serviceRegisterModelRepo.findAllCompletedServices();
	}
	
	@GetMapping("/service-assigned/{userId}")
	public List<ServiceRegisterModel> registerService(@PathVariable int userId){
		return serviceRegisterModelRepo.findAllByAssignedToOrderByIdDesc(userId);
	}
	
	@GetMapping("/service-inProgress/{userId}")
	public List<ServiceRegisterModel> inProgressService(@PathVariable int userId){
		return serviceRegisterModelRepo.findAllByinProgressServices(userId);
	}
	
	@GetMapping("/service-detail")
	public List<ServiceDetailModel> addServiceDetail(){
		return serviceDetailModelRepo.findAll();
	}
	
	@GetMapping("/service-register/{id}")
	public ServiceRegisterModel getRegisteredService(@PathVariable int id){
		return serviceRegisterModelRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/service-detail/{serviceId}")
	public List<ServiceDetailModel> getServiceDetail(@PathVariable int serviceId){
		return serviceDetailModelRepo.findByServiceIdOrderByIdDesc(serviceId);
	}
	
	
	@GetMapping("/employee-name/{id}")
	public UserList getEmployeeDetails(@PathVariable int id){
		return userListRepo.findById(id).orElse(null);
	}
	
	//Get Technician List
	@GetMapping("/assignTo-list/{designationId}")
	public List<UserList> getTechicianList(@PathVariable int designationId){
		return userListRepo.findAllTechician(designationId);
	}
	// getTechnician
	@GetMapping("/technician-list")
	public List<ObjectNode> getTechician(){
		return tssdService.getTechician();
	}
	
	//Get Assign Task To Technician
	@GetMapping("/numberOf-taskAssigned")
	public List<ObjectNode> getNumberOfTaskAssigned(){
		return tssdService.getNumberOfTaskAssigned();
	}
	
	@GetMapping("/spare-part-category")
	public List<TssdSparePartCategory> sparePartCategoryList(){
		return sparePartCategoryRepo.findAll();
	}
	
	@GetMapping("/spare-part/{categoryId}")
	public List<TssdSparePart> sparePartsList(@PathVariable int categoryId){
		return sparePartRepo.findBySparePartCategoryId(categoryId);
	}
	
	@PostMapping("/add-spare-part")
	public List<TssdSparePartIncluded> saveServiceSparePart(@RequestBody List<TssdSparePartIncluded> entities){
		return tssdSparePartIncludedRepo.saveAll(entities);
	}
	
	@GetMapping("/spare-part-included/{serviceId}")
	public List<TssdSparePartIncluded> getServiceSparePart(@PathVariable int serviceId){
		return tssdSparePartIncludedRepo.findAllByServiceId(serviceId);
	}
	
//	@GetMapping("/employee-name/{id}")
//	public UserList getEmployeeNameById(@PathVariable int id){
//		return userListRepo.findById(id).orElse(null);
//	}
//	
		
	@GetMapping("/request-spare-parts")
	public List<ServiceRegisterModel> sparePartRequested(){
		return serviceRegisterModelRepo.findAllSparePartNeeded();
	}
	
	@GetMapping("/approved-spare-parts")
	public List<ServiceRegisterModel> approvedPartRequested(){
		return serviceRegisterModelRepo.findAllApprovedSparePart();
	}
	
}
