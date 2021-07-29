package com.ngn.bms.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class LeadReportServices {
//TopManagement

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<ObjectNode> getReport(int userId, String queryType, String fromDate, String toDate, int division) {
		String queryStr = "";
		Query query = null;

		if (queryType.equalsIgnoreCase("bidRegistered")) {
			queryStr = "SELECT IFNULL(z.`reference_no`,'') reference_no,IFNULL(c.`source_name`,'') source_name,IFNULL(d.`name`,'') organization_type,IFNULL(e.`name`,'') organization,IFNULL(f.`name`,'') tender_type,IFNULL(z.`publication_date`,'') publication_date,IFNULL(z.`contact_person`,'') contact_person,IFNULL(z.`contact_number`,'') contact_number, \r\n" + 
					"IFNULL(z.`sale_date`,'') sale_date,IFNULL(z.`cost`,'') cost,IFNULL(z.`submission_date`,'') submission_date,IFNULL(b.`emp_first_name`,'') emp_first_name,IFNULL(b.`emp_second_name`,'') emp_second_name,\r\n" + 
					"IFNULL(z.bid_name,'') bid_name,IFNULL(z.client_tender_ref_no,'') client_tender_ref_no,IFNULL(z.tender_amt,'') tender_amt, \r\n" + 
					"IFNULL(g.`margin`,'') margin,IFNULL(g.`cif`,'') cif,IFNULL(g.`qty`,'') total_qty,IFNULL(g.`gain_amt`,'') gain_amt,IFNULL(h.`amount`,'') total_bid\r\n" + 
					"FROM tenders z  \r\n" + 
					"LEFT JOIN `user_details` a ON z.`forwarded_to`=a.`id` \r\n" + 
					"LEFT JOIN `employee_details` b ON a.`emp_id`=b.`id` \r\n" + 
					"LEFT JOIN `source` c ON z.`source_id`=c.`id` \r\n" + 
					"LEFT JOIN `organization_types` d ON z.`organization_type_id`=d.`id` \r\n" + 
					"LEFT JOIN `organizations` e ON z.`organization_id`=e.`id` \r\n" + 
					"LEFT JOIN `tender_types` f ON z.`tender_type_id`=f.`id`  \r\n" + 
					"LEFT JOIN `tender_work_sheet` g ON z.`id`=g.`tender_id`\r\n" + 
					"LEFT JOIN `t_quotation` h ON z.id=h.`tender_id`\r\n" + 
					"WHERE z.added_on BETWEEN ?1 AND ?2 AND z.status IN ('Y','W','L') GROUP BY z.id";
			query = entityManager.createNativeQuery(queryStr, Tuple.class);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);

		} else if (queryType.equalsIgnoreCase("bidSubmitted")) {
			queryStr = "SELECT z.`reference_no`,c.`source_name`,d.`name` AS organization_type,e.`name` AS organization,f.`name` AS tender_type,z.`publication_date`,z.`description`,z.`contact_person`,z.`contact_number`,  \r\n"
					+ "z.`sale_date`,z.`cost`,z.`submission_date`,b.`emp_first_name`,b.`emp_second_name`,z.`updated_on`,z.`final_amt`,\r\n"
					+ "IFNULL(z.bid_name,'') bid_name,IFNULL(z.client_tender_ref_no,'') client_tender_ref_no,IFNULL(z.tender_amt,'') tender_amt,  \r\n"
					+ "IFNULL(g.`margin`,'') margin,IFNULL(g.`cif`,'') cif,IFNULL(g.`qty`,'') total_qty,IFNULL(g.`gain_amt`,'') gain_amt,IFNULL(h.`amount`,'') total_bid \r\n"
					+ "FROM t_quotation h   \r\n"
					+ "LEFT JOIN `tenders` z ON z.id=h.`tender_id` \r\n"
					+ "LEFT JOIN `user_details` a ON z.`forwarded_to`=a.`id`  \r\n"
					+ "LEFT JOIN `employee_details` b ON a.`emp_id`=b.`id`  \r\n"
					+ "LEFT JOIN `source` c ON z.`source_id`=c.`id`  \r\n"
					+ "LEFT JOIN `organization_types` d ON z.`organization_type_id`=d.`id`  \r\n"
					+ "LEFT JOIN `organizations` e ON z.`organization_id`=e.`id`  \r\n"
					+ "LEFT JOIN `tender_types` f ON z.`tender_type_id`=f.`id`   \r\n"
					+ "LEFT JOIN `tender_work_sheet` g ON z.`id`=g.`tender_id`  \r\n"
					+ "WHERE z.added_on BETWEEN ?1 AND ?2 AND h.`active` IN ('Y') GROUP BY z.id";
			query = entityManager.createNativeQuery(queryStr, Tuple.class);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);

		} else if (queryType.equalsIgnoreCase("bidClosed")) {
				queryStr =  "SELECT IFNULL(z.`reference_no`,'') reference_no,IFNULL(c.`source_name`,'') source_name,IFNULL(d.`name`,'') organization_type,IFNULL(e.`name`,'') organization,IFNULL(f.`name`,'') tender_type,IFNULL(z.`publication_date`,'') publication_date,"
						+ "IFNULL(z.`contact_person`,'') contact_person,IFNULL(z.`contact_number`,'') contact_number,IFNULL(z.`updated_on`,'') updated_on, \r\n"
						+ "IFNULL(z.`sale_date`,'') sale_date,IFNULL(z.`cost`,'') cost,IFNULL(z.`submission_date`,'') submission_date,IFNULL(b.`emp_first_name`,'') emp_first_name,IFNULL(b.`emp_second_name`,'') emp_second_name, \r\n"
						+ "IFNULL(z.bid_name,'') bid_name,IFNULL(z.client_tender_ref_no,'') client_tender_ref_no,IFNULL(z.final_amt,'') final_amt,  \r\n"
						+ "IFNULL(g.`margin`,'') margin,IFNULL(g.`cif`,'') cif,IFNULL(g.`qty`,'') total_qty,IFNULL(g.`gain_amt`,'') gain_amt,IFNULL(h.`amount`,'') total_bid \r\n"
						+ "FROM tenders z \r\n"
						+ "LEFT JOIN `user_details` a ON z.`updated_by`=a.`id`  \r\n"
						+ "LEFT JOIN `employee_details` b ON a.`emp_id`=b.`id`  \r\n"
						+ "LEFT JOIN `source` c ON z.`source_id`=c.`id`  \r\n"
						+ "LEFT JOIN `organization_types` d ON z.`organization_type_id`=d.`id`  \r\n"
						+ "LEFT JOIN `organizations` e ON z.`organization_id`=e.`id`  \r\n"
						+ "LEFT JOIN `tender_types` f ON z.`tender_type_id`=f.`id`   \r\n"
						+ "LEFT JOIN `tender_work_sheet` g ON z.`id`=g.`tender_id` \r\n"
						+ "LEFT JOIN `t_quotation` h ON z.id=h.`tender_id` \r\n"
						+ "WHERE z.added_on BETWEEN ?1 AND ?2 AND z.status IN ('W','L','C') GROUP BY z.id";
			query = entityManager.createNativeQuery(queryStr, Tuple.class);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);

		} else if (queryType.equalsIgnoreCase("Win")) {
			queryStr = "SELECT IFNULL(z.`reference_no`,'') reference_no,IFNULL(c.`source_name`,'') source_name,IFNULL(d.`name`,'') organization_type,IFNULL(e.`name`,'') organization,IFNULL(f.`name`,'') tender_type,IFNULL(z.`publication_date`,'') publication_date,IFNULL(z.`contact_person`,'') contact_person,IFNULL(z.`contact_number`,'') contact_number,  \r\n"
					+ "IFNULL(z.`sale_date`,'') sale_date,IFNULL(z.`cost`,'') cost,IFNULL(z.`submission_date`,'') submission_date,IFNULL(b.`emp_first_name`,'') emp_first_name,IFNULL(b.`emp_second_name`,'') emp_second_name, \r\n"
					+ "IFNULL(z.bid_name,'') bid_name,IFNULL(z.client_tender_ref_no,'') client_tender_ref_no,IFNULL(z.tender_amt,'') tender_amt,  \r\n"
					+ "IFNULL(g.`margin`,'') margin,IFNULL(g.`cif`,'') cif,IFNULL(g.`qty`,'') total_qty,IFNULL(g.`gain_amt`,'') gain_amt,IFNULL(h.`amount`,'') total_bid \r\n"
					+ "FROM tenders z   \r\n"
					+ "LEFT JOIN `user_details` a ON z.`updated_by`=a.`id`  \r\n"
					+ "LEFT JOIN `employee_details` b ON a.`emp_id`=b.`id`  \r\n"
					+ "LEFT JOIN `source` c ON z.`source_id`=c.`id`  \r\n"
					+ "LEFT JOIN `organization_types` d ON z.`organization_type_id`=d.`id`  \r\n"
					+ "LEFT JOIN `organizations` e ON z.`organization_id`=e.`id`  \r\n"
					+ "LEFT JOIN `tender_types` f ON z.`tender_type_id`=f.`id`   \r\n"
					+ "LEFT JOIN `tender_work_sheet` g ON z.`id`=g.`tender_id` \r\n"
					+ "LEFT JOIN `t_quotation` h ON z.id=h.`tender_id` \r\n"
					+ "WHERE z.added_on BETWEEN ?1 AND ?2 AND z.status IN ('W') GROUP BY z.id";
			query = entityManager.createNativeQuery(queryStr, Tuple.class);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);
		} else if (queryType.equalsIgnoreCase("Loss")) {
			queryStr = "SELECT IFNULL(z.`reference_no`,'') reference_no,IFNULL(c.`source_name`,'') source_name,IFNULL(d.`name`,'') organization_type,IFNULL(e.`name`,'') organization,IFNULL(f.`name`,'') tender_type,IFNULL(z.`publication_date`,'') publication_date,IFNULL(z.`contact_person`,'') contact_person,IFNULL(z.`contact_number`,'') contact_number,  \r\n"
					+ "IFNULL(z.`sale_date`,'') sale_date,IFNULL(z.`cost`,'') cost,IFNULL(z.`submission_date`,'') submission_date,IFNULL(b.`emp_first_name`,'') emp_first_name,IFNULL(b.`emp_second_name`,'') emp_second_name, \r\n"
					+ "IFNULL(z.bid_name,'') bid_name,IFNULL(z.client_tender_ref_no,'') client_tender_ref_no,IFNULL(z.tender_amt,'') tender_amt,  \r\n"
					+ "IFNULL(g.`margin`,'') margin,IFNULL(g.`cif`,'') cif,IFNULL(g.`qty`,'') total_qty,IFNULL(g.`gain_amt`,'') gain_amt,IFNULL(h.`amount`,'') total_bid \r\n"
					+ "FROM tenders z   \r\n"
					+ "LEFT JOIN `user_details` a ON z.`updated_by`=a.`id`  \r\n"
					+ "LEFT JOIN `employee_details` b ON a.`emp_id`=b.`id`  \r\n"
					+ "LEFT JOIN `source` c ON z.`source_id`=c.`id`  \r\n"
					+ "LEFT JOIN `organization_types` d ON z.`organization_type_id`=d.`id`  \r\n"
					+ "LEFT JOIN `organizations` e ON z.`organization_id`=e.`id`  \r\n"
					+ "LEFT JOIN `tender_types` f ON z.`tender_type_id`=f.`id`   \r\n"
					+ "LEFT JOIN `tender_work_sheet` g ON z.`id`=g.`tender_id` \r\n"
					+ "LEFT JOIN `t_quotation` h ON z.id=h.`tender_id` \r\n"
					+ "WHERE z.added_on BETWEEN ?1 AND ?2 AND z.status IN ('L') GROUP BY z.id";
			query = entityManager.createNativeQuery(queryStr, Tuple.class);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);
		} else if (queryType.equalsIgnoreCase("Total")) {
			queryStr = "SELECT \r\n" + "COUNT(z.`reference_no`) AS total  \r\n" + "FROM \r\n" + "`tenders` z  \r\n"
					+ "WHERE z.status = 'W' OR z.`status`='L' AND z.`acknowledge`='Y' \r\n"
					+ "AND z.`added_on` BETWEEN ?1\r\n" + "AND ?2";
			query = entityManager.createNativeQuery(queryStr, Tuple.class);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);
		} else if (queryType.equalsIgnoreCase("Report")) {
			queryStr = "SELECT b.`emp_first_name`,b.`emp_second_name`,c.`id`,e.`division`,IFNULL(f.`amount`,'') amount,a.`status` FROM `tenders` a\r\n"
					+ "LEFT JOIN `user_details` c ON a.`updated_by`= c.`id` \r\n"
					+ "LEFT JOIN `employee_details` b ON c.`emp_id`=b.`id`\r\n"
					+ "LEFT JOIN `divisions` e ON b.`division_id`=e.`id`\r\n"
					+ "LEFT JOIN `t_quotation` f ON a.`id`=f.`tender_id`\r\n"
					+ "WHERE e.`id`=?3 AND a.`status`<>'B' AND a.`status`<>'Y' AND a.`added_on` BETWEEN ?1 AND ?2";

			query = entityManager.createNativeQuery(queryStr, Tuple.class);
			query.setParameter(1, fromDate);
			query.setParameter(2, toDate);
			query.setParameter(3, division);
		}
		try {
			List<Tuple> results = query.getResultList();
			List<ObjectNode> json = _toJson(results);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<ObjectNode> funnelReport(String fromDate, String toDate, String lead) {
		String queryStr = "";
		Query query = null;

		queryStr = "SELECT a.added_on,a.lead_name,b.name,e.emp_first_name,e.emp_second_name,f.division,IFNULL(a.lead_amount,'') lead_amount,c.name,IFNULL(a.lead_description,'') lead_description FROM lead a \r\n" + 
				"LEFT JOIN organizations b ON a.organization_id = b.id\r\n" + 
				"LEFT JOIN product_categories c ON a.product_category_id=c.id\r\n" + 
				"LEFT JOIN user_details d ON a.added_by = d.id\r\n" + 
				"LEFT JOIN employee_details e ON d.emp_id = e.id\r\n" + 
				"LEFT JOIN divisions f ON e.division_id = f.id\r\n" + 
				"WHERE a.added_on  BETWEEN ?1 AND ?2 AND a.lead_status=?3";
		query = entityManager.createNativeQuery(queryStr, Tuple.class);
		query.setParameter(1, fromDate);
		query.setParameter(2, toDate);
		query.setParameter(3, lead);

		try {
			List<Tuple> results = query.getResultList();
			List<ObjectNode> json = _toJson(results);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public List<ObjectNode> funnelReport(String fromDate, String toDate) {
	    String queryStr = "";
	    Query query = null;

	    queryStr = "SELECT a.added_on,a.lead_name,b.name,e.emp_first_name,e.emp_second_name,f.division,IFNULL(a.lead_amount,'') lead_amount,IFNULL(c.name,'') category,IFNULL(a.lead_description,'') lead_description, IFNULL(a.lead_status,'') lead_status  FROM lead a  \r\n" + 
	        "LEFT JOIN organizations b ON a.organization_id = b.id \r\n" + 
	        "LEFT JOIN product_categories c ON a.product_category_id=c.id \r\n" + 
	        "LEFT JOIN user_details d ON a.added_by = d.id \r\n" + 
	        "LEFT JOIN employee_details e ON d.emp_id = e.id \r\n" + 
	        "LEFT JOIN divisions f ON e.division_id = f.id \r\n" + 
	        "WHERE a.added_on  BETWEEN ?1 AND ?2";
	    query = entityManager.createNativeQuery(queryStr, Tuple.class);
	    query.setParameter(1, fromDate);
	    query.setParameter(2, toDate); 

	    try {
	      List<Tuple> results = query.getResultList();
	      List<ObjectNode> json = _toJson(results);
	      return json;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return null;

	  }

	private List<ObjectNode> _toJson(List<Tuple> results) {
		List<ObjectNode> json = new ArrayList<ObjectNode>();
		ObjectMapper mapper = new ObjectMapper();
		for (Tuple t : results) {
			List<TupleElement<?>> cols = t.getElements();
			ObjectNode one = mapper.createObjectNode();
			for (@SuppressWarnings("rawtypes")
			TupleElement col : cols) {
				one.put(col.getAlias(), t.get(col.getAlias()).toString());
			}
			json.add(one);
		} 
		return json;
	} 

}
