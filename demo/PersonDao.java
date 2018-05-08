package com.example.demo;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
	@Autowired
	 private JdbcTemplate template;
	 
//	 public List<Person> listForBeanPropertyRowMapper() {
//	        String query = "SELECT * FROM person";
//	        return template.query(query, new BeanPropertyRowMapper(Person.class));
//	    }
	 public List<Person> listSearchByName(String name) {
	        String query = "SELECT * FROM person_table WHERE name='" + name + "'";
	        return template.query(query, new BeanPropertyRowMapper(Person.class));
	    }

	    public int insert(Person hello) {
	        String query = "INSERT INTO person_table(image, name, age, id_num, introduce, major, vote, sex) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	        
//	        if(SearchProperty(()))
//	        {
//	        	return 0;
//	        }
	        return template.update(query, hello.getImage(), hello.getName(), hello.getAge(), hello.getId_num(), hello.getIntroduce(), hello.getMajor(), hello.getVote(), hello.getSex());
	    }
	    
	    public List<Person> listBySex(int sex)
	    {
	    	String query = "SELECT * FROM person_table WHERE sex='" + sex + "'";
	    	List<Person> list_p = template.query(query, new BeanPropertyRowMapper(Person.class));
	    	
	    	Collections.sort(list_p, new Comparator<Person>() {
	    	    @Override
	    	    public int compare(Person o1,Person o2) {
	    	        return o1.getVote() > o2.getVote() ? -1 : o1.getVote() < o2.getVote() ? 1 : 0;
	    	    }
	    	});

	    	if(list_p.size() > 100)
	    		list_p = list_p.subList(0, 100);
	    	
	    	return list_p;
	    	
	    }
	    public int votePerson(int id)
	    {
	    	String query = "SELECT vote FROM person_table WHERE id='" + id + "'";
	        int _vote = template.queryForObject(query, Integer.class);
	        String query2 = "UPDATE person_table SET vote = ? WHERE id = ?";
	        return template.update(query2, _vote + 1, id);
	    }
//	 public Integer listForSearchProperty(String id, String pw){
//		 String query = "SELECT count(*) FROM user WHERE user_id = '" + id + "' AND user_pw = '"+pw + "'";
//		 if(template.queryForObject(query, Integer.class) <= 0)
//			 return -1;
//			 
//		 
//		 String query2 = "SELECT id FROM user WHERE user_id = '" + id + "' AND user_pw = '"+pw + "'";
//
//		 return template.queryForObject(query2, Integer.class);
//		 
//		 
//		 
//	 }
//	 public boolean SearchProperty(String id){
//		 String query = "SELECT count(*) FROM user WHERE user_id = '" + id + "'";
//
//		 int count = template.queryForObject(query, Integer.class);
//		 
//		 return count > 0;
//		 
//	 }
}
