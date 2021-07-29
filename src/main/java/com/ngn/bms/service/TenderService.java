package com.ngn.bms.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngn.bms.model.Quotation;
import com.ngn.bms.repository.QuotationRepo;

@Service
public class TenderService {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")

	String queryStr = "";
	Query query = null;

	public List<ObjectNode> getUserByDivision(int division_id,String t_status) {

		queryStr = "SELECT COUNT(a.`status`) AS win,a.`updated_by`,c.`emp_first_name`,c.`emp_second_name`,a.`status` FROM  `tenders` a\r\n" + 
				"LEFT JOIN `user_details` b ON a.`updated_by`=b.`id`\r\n" + 
				"LEFT JOIN `employee_details` c ON b.`emp_id`=c.id\r\n" + 
				"WHERE a.`status`='W' AND c.`division_id`=?1 GROUP BY a.`updated_by`";
		query = entityManager.createNativeQuery(queryStr, Tuple.class);
		query.setParameter(1, division_id); 

		try {
			List<Tuple> results = query.getResultList();
			List<ObjectNode> json = _toJson(results);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<ObjectNode> getUserTenderDetail(String t_status, int t_tender_stage, int updated_by, String fromDate,
			String toDate) {

		queryStr = "SELECT COUNT(a.`id`) AS data,c.`emp_first_name`,c.`emp_second_name` FROM `tenders` a \r\n" + 
				"LEFT JOIN `user_details` b ON a.`updated_by`=b.`id`\r\n" + 
				"LEFT JOIN `employee_details` c ON b.`emp_id`=c.id\r\n" + 
				"WHERE a.`status`= ?1 AND a.`tender_stage_id`= ?2 AND a.`updated_by`= ?3 \r\n" + 
				"AND a.`updated_on` BETWEEN ?4 AND ?5";

		query = entityManager.createNativeQuery(queryStr, Tuple.class);
		query.setParameter(1, t_status);
		query.setParameter(2, t_tender_stage);
		query.setParameter(3, updated_by);
		query.setParameter(4, fromDate);
		query.setParameter(5, toDate);

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

	public List<ObjectNode> getUserTotalTender(int updated_by, String fromDate, String toDate) { 
		queryStr = "SELECT COUNT(a.`id`) AS DATA FROM `tenders` a \r\n" + 
				"WHERE a.`updated_by`= ?1 AND a.`updated_on` BETWEEN ?2 AND ?3";

		query = entityManager.createNativeQuery(queryStr, Tuple.class);
		query.setParameter(1, updated_by);
		query.setParameter(2, fromDate);
		query.setParameter(3, toDate); 

		try {
			List<Tuple> results = query.getResultList();
			List<ObjectNode> json = _toJson(results);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ObjectNode> getTotalWinTender(String fromDate, String toDate) {
		queryStr = "SELECT a.`reference_no`,b.`name` AS organization,a.`bid_name`,a.`submission_date`,h.`amount`,e.`emp_first_name`,e.`emp_second_name` FROM `tenders` a \r\n" + 
				"LEFT JOIN `organization_types` g ON a.`organization_type_id`=g.id \r\n" + 
				"LEFT JOIN organizations b ON a.organization_id = b.id    \r\n" + 
				"LEFT JOIN user_details d ON a.added_by = d.id  \r\n" + 
				"LEFT JOIN employee_details e ON d.emp_id = e.id  \r\n" + 
				"LEFT JOIN divisions f ON e.division_id = f.id\r\n" + 
				"LEFT JOIN `t_quotation` h ON a.`id`=h.`tender_id`\r\n" + 
				"WHERE a.`status`='W' a.added_on  BETWEEN ?1 AND ?2 ";

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

	public List<ObjectNode> getTotalLostTender(String fromDate, String toDate) { 
		queryStr = "SELECT a.`reference_no`,b.`name` AS organization,a.`bid_name`,a.`submission_date`,h.`amount`,e.`emp_first_name`,e.`emp_second_name` FROM `tenders` a \r\n" + 
				"LEFT JOIN `organization_types` g ON a.`organization_type_id`=g.id \r\n" + 
				"LEFT JOIN organizations b ON a.organization_id = b.id    \r\n" + 
				"LEFT JOIN user_details d ON a.added_by = d.id  \r\n" + 
				"LEFT JOIN employee_details e ON d.emp_id = e.id  \r\n" + 
				"LEFT JOIN divisions f ON e.division_id = f.id\r\n" + 
				"LEFT JOIN `t_quotation` h ON a.`id`=h.`tender_id`\r\n" + 
				"WHERE a.`status`='W' a.added_on  BETWEEN ?1 AND ?2 ";

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

	public List<ObjectNode> getUserTotalTender(int division_id) {
		queryStr = "SELECT COUNT(a.`status`) AS total,a.`updated_by`,c.`emp_first_name`,c.`emp_second_name`,a.`status` FROM  `tenders` a \r\n" + 
				"LEFT JOIN `user_details` b ON a.`updated_by`=b.`id` \r\n" + 
				"LEFT JOIN `employee_details` c ON b.`emp_id`=c.id \r\n" + 
				"WHERE a.`status` IN ('Y','W','L') AND c.`division_id`=?1 GROUP BY a.`updated_by`";
		query = entityManager.createNativeQuery(queryStr, Tuple.class);
		query.setParameter(1, division_id); 

		try {
			List<Tuple> results = query.getResultList();
			List<ObjectNode> json = _toJson(results);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ObjectNode> getUserByDivisionIdLost(int division_id, String t_status) { 
		queryStr = "SELECT COUNT(a.`status`) AS lost,a.`updated_by`,c.`emp_first_name`,c.`emp_second_name`,a.`status` FROM  `tenders` a \r\n" + 
				"LEFT JOIN `user_details` b ON a.`updated_by`=b.`id` \r\n" + 
				"LEFT JOIN `employee_details` c ON b.`emp_id`=c.id \r\n" + 
				"WHERE a.`status`='L' AND c.`division_id`=?1 GROUP BY a.`updated_by`";
		query = entityManager.createNativeQuery(queryStr, Tuple.class);
		query.setParameter(1, division_id); 

		try {
			List<Tuple> results = query.getResultList();
			List<ObjectNode> json = _toJson(results);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
