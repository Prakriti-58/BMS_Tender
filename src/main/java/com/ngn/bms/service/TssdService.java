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
import com.ngn.bms.model.UserList;

@Service
public class TssdService {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<ObjectNode> getNumberOfTaskAssigned() {
	
		String queryStr = "SELECT a.`emp_first_name`,a.`emp_second_name`,COUNT(c.`status`) AS task FROM employee_details a " + 
				"LEFT JOIN `user_details` b ON a.`id`=b.`emp_id` " + 
				"LEFT JOIN `t_service` c ON b.`id`=c.`assigned_to` " + 
				"WHERE c.`status` = 'Y' OR c.`status` = 'S'" + 
				"GROUP BY c.`assigned_to`";
		Query query = entityManager.createNativeQuery(queryStr, Tuple.class);
		
		try {
			List<Tuple> results = query.getResultList();
			List<ObjectNode> json = _toJson(results);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<ObjectNode> getTechician() {
		String queryStr = "SELECT a.`emp_first_name`,a.`emp_second_name`,COUNT(c.`status`) AS task FROM employee_details a   \r\n" + 
				"LEFT JOIN `user_details` b ON a.`id`=b.`emp_id`   \r\n" + 
				"LEFT JOIN `t_service` c ON b.`id`=c.`assigned_to`  \r\n" + 
				"LEFT JOIN `designation` d ON a.`designation_id`=d.`id` \r\n" + 
				"WHERE d.`id`=7 GROUP BY c.`assigned_to`";
		Query query = entityManager.createNativeQuery(queryStr, Tuple.class);
		
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
