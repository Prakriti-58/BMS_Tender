package com.ngn.bms.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ngn.bms.model.CountryList;
import com.ngn.bms.model.LeadToTender;
import com.ngn.bms.model.ProductModel;
import com.ngn.bms.model.SaveQuotation;
import com.ngn.bms.model.TenderFollowUp;
import com.ngn.bms.model.TenderLost;
import com.ngn.bms.model.TenderSeq;
import com.ngn.bms.model.TenderStage;
import com.ngn.bms.model.TenderWorkSheet;
import com.ngn.bms.model.Tenders;
import com.ngn.bms.model.TransportationHistroy;
import com.ngn.bms.repository.CountryListRepo;
import com.ngn.bms.repository.LeadToTenderRepo;
import com.ngn.bms.repository.ProductModelRepo;
import com.ngn.bms.repository.SaveQuotationRepo;
import com.ngn.bms.repository.TenderFollowUpRepo;
import com.ngn.bms.repository.TenderLostRepo;
import com.ngn.bms.repository.TenderRefRepo;
import com.ngn.bms.repository.TenderRepository;
import com.ngn.bms.repository.TenderStageRepo;
import com.ngn.bms.repository.TenderWorkSheetRepo;
import com.ngn.bms.repository.TransportationRepo;
import com.ngn.bms.service.TenderService;

@RestController
@RequestMapping("tender")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
public class TenderController {

	@Autowired
	public TenderRepository tenderRepository;

	@Autowired
	public TenderService tenderService;

	@Autowired
	public TenderFollowUpRepo tenderFollowUpRepo;

	@Autowired
	public TenderWorkSheetRepo tenderWorkSheetRepo;

	@Autowired
	private TenderRefRepo tenderRefRepo;

	@Autowired
	private CountryListRepo countryListRepo;

	@Autowired
	private ProductModelRepo productModelRepo;

	@Autowired
	private TransportationRepo transportationRepo;

	@Autowired
	private SaveQuotationRepo saveQuotationRepo;

	@Autowired
	private TenderStageRepo tenderStageRepo;

	@Autowired
	private LeadToTenderRepo leadToTenderRepo;
	
	@Autowired
	private TenderLostRepo tenderLostRepo;

	@GetMapping("/assigned/{userId}")
	public List<Tenders> geTendersList(@PathVariable Integer userId) {
		return tenderRepository.findAllAssignedTender(userId);
	}

	@GetMapping("/tenderCollection")
	public List<Tenders> getTenderCollection() {
		return tenderRepository.findAllTenderCollection();
	}
	
	@GetMapping("/prepared-tender/{userId}")
	public List<Tenders> getPreparedTenders(@PathVariable Integer userId) {
		return tenderRepository.findAllPreparedTender(userId);
	}

	@GetMapping("/open/{userId}")
	public List<Tenders> geOpenTendersList(@PathVariable Integer userId) {
		return tenderRepository.findAllOpenTender(userId);
	}

	@PostMapping("/save") // Acknowledge,update,save,delete
	public Tenders posTenders(@RequestBody Tenders entity) {
		Tenders savTenders = tenderRepository.save(entity);
		return savTenders;

	}

	@GetMapping("/getById/{id}")
	public Tenders getTendersById(@PathVariable Integer id) {
		return tenderRepository.findById(id).orElse(null);

	} 
	// Tender Follow UP

	@GetMapping("/followUp/{tenderId}")
	public List<TenderFollowUp> geFollowUpsList(@PathVariable Integer tenderId) {
		return tenderFollowUpRepo.followUpByTenderId(tenderId);

	}

	@PostMapping("/followUp/save")
	public TenderFollowUp posTenderFollowUp(@RequestBody TenderFollowUp entity) {
		return tenderFollowUpRepo.save(entity);

	}
	
	// Tender work sheet 
	@GetMapping("/worksheet/{tenderId}/{userId}")
	public List<TenderWorkSheet> getWorksheet(@PathVariable Integer tenderId, @PathVariable Integer userId) {
		return tenderWorkSheetRepo.getWorkSheetBy(tenderId, userId);

	}

	@GetMapping("/worksheet/getId/{id}")
	public TenderWorkSheet getWorkSheetById(@PathVariable Integer id) {
		return tenderWorkSheetRepo.findById(id).orElse(null);

	}

	@DeleteMapping("/worksheet/delete/{id}")
	public void deleteWorkSheet(@PathVariable Integer id) {
		tenderWorkSheetRepo.deleteById(id);
	}

	@PostMapping("/worksheet/save") // Acknowledge,update,save,delete
	public TenderWorkSheet postWorkSheet(@RequestBody TenderWorkSheet entity) {
		return tenderWorkSheetRepo.save(entity);

	}
	
	@PostMapping("/worksheet/saveAll") 
	  public TenderWorkSheet saveWorkSheetList(@RequestBody List<TenderWorkSheet> entity) {
	    tenderWorkSheetRepo.saveAll(entity);
	    return null;

	  }

	@GetMapping("/sequence")
	public List<TenderSeq> geTenderSeq() {
		return tenderRefRepo.findAll();
	}

	@GetMapping("/sequence/{seq}")
	public TenderSeq incremenTenderSeq(@PathVariable Integer seq) {
		TenderSeq tenderSeq = new TenderSeq();
		tenderSeq.setSequence(seq + 1);
		tenderSeq.setId(1);
		return tenderRefRepo.save(tenderSeq);
	}

	@GetMapping("/countryList")
	public List<CountryList> getCountryList() {
		return countryListRepo.findCountryList();

	}

//	@GetMapping("feedEGPdata/{tenderId}")
//	public void setDataInDB(@PathVariable Integer tenderId) throws IOException {
//		tenderService.saveEgpData(tenderId);
//	}

	@GetMapping("model-description/{id}")
	public ProductModel getModelDescription(@PathVariable Integer id) {
		return productModelRepo.findById(id).orElse(null);
	}

	@PostMapping("add-transportation-detail")
	public TransportationHistroy addHistroy(@RequestBody TransportationHistroy entity) {
		return transportationRepo.save(entity);
	}

	@GetMapping("transportation-detail/{tenderId}/{productModelId}")
	public List<TransportationHistroy> getTransportationHistroy(@PathVariable Integer tenderId,
			@PathVariable Integer productModelId) {
		return transportationRepo.findByProductModelId(tenderId, productModelId);
	}

	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;

	@PostMapping("/uploadFile")
	public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file) throws IOException {
		File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping("/add-quotation")
	public SaveQuotation saveQuotation(@RequestBody SaveQuotation entity) {
		entity.setFile_path(FILE_DIRECTORY);
		return saveQuotationRepo.save(entity);
	}

	@GetMapping("/getTenderStage")
	public List<TenderStage> getTendersStage() {
		return tenderStageRepo.findAll();
	}

	@GetMapping("/getQuotedTender/{userId}")
	public List<SaveQuotation> getQuotation(@PathVariable int userId) {
		return saveQuotationRepo.findAllByUpdatedBy(userId);
	}

	@GetMapping("/quotationById/{id}")
	public SaveQuotation getQuotationById(@PathVariable int id) {
		return saveQuotationRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/getQuoAmtByTenderId/{id}")
	public SaveQuotation getByTenderId(@PathVariable int id) {
		return saveQuotationRepo.findByTenderId(id);
	}
	
	@GetMapping("/closeQuotationByTenderId/{id}/{final_amt}")
	public SaveQuotation closeQuotationByTenderId(@PathVariable int id,@PathVariable int final_amt) {
		SaveQuotation getQuotation = saveQuotationRepo.findByTenderId(id);
		getQuotation.setAmount(final_amt);
		getQuotation.setActive("N");
		return saveQuotationRepo.save(getQuotation);
	}

	@PutMapping("/updateWinRate")
	public ResponseEntity<Object> getQuotation(@RequestBody SaveQuotation entity) {
		saveQuotationRepo.save(entity);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping("/leadConvertsTender")
	public ResponseEntity<Object> leadToTender(@RequestBody LeadToTender entity) throws IOException {
		leadToTenderRepo.save(entity);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/closeTenderById/{tender_id}/{decision}")
	public ResponseEntity<Object> closeTenerById(@PathVariable int tender_id,@PathVariable String decision ) throws IOException {
		Tenders tender = tenderRepository.findById(tender_id).orElse(null);
		tender.setStatus(decision);
		tender.setTender_stage_id(6);
		tenderRepository.save(tender); 
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/updateTenderStage/{tender_id}/{tenderStage}/{final_amt}")
	public ResponseEntity<Object> updateTenderStage(@PathVariable int tender_id,@PathVariable int tenderStage,@PathVariable int final_amt ) throws IOException {
		long millis=System.currentTimeMillis();  
		Date getDate = new java.sql.Date(millis);  
		Tenders tender = tenderRepository.findById(tender_id).orElse(null);
		Integer user = tender.getForwardedTo();
		tender.setFinal_amt(final_amt);
		tender.setAcknowledge_date(getDate.toString());
		tender.setTender_stage_id(tenderStage);
		tender.setAcknowledge("Y"); 
		tender.setUpdatedBy(user);
		tenderRepository.save(tender); 
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/getTenderByStage/{tenderStage}/{userId}")
	public List<Tenders> updateTenderStage(@PathVariable int tenderStage,@PathVariable int userId ) throws IOException {
		 return tenderRepository.findByTenderStage(tenderStage,userId);
	}
	
	@GetMapping("/closeQuotationById/{tender_id}")
	public ResponseEntity<Object> closeQuotationById(@PathVariable int tender_id) throws IOException {
		SaveQuotation quotation = saveQuotationRepo.findByTenderId(tender_id);
		quotation.setActive("N");
		saveQuotationRepo.save(quotation); 
		return new ResponseEntity<Object>(HttpStatus.OK);
	} 
	//Tender Lost Api
	@PostMapping("/tenderLost")
	public ResponseEntity<Object> postTenderLost(@RequestBody TenderLost entity) {
		tenderLostRepo.save(entity);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
