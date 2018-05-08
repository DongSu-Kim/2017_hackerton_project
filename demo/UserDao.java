package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	 private JdbcTemplate template;
	 
	 public List<User> listForBeanPropertyRowMapper() {
	        String query = "SELECT * FROM user_table";
	        return template.query(query, new BeanPropertyRowMapper(User.class));
	    }

	    public int insert(User hello) {
	        String query = "INSERT INTO user_table(user_id, user_pw) VALUES(?, ?)";
	        
	        if(SearchProperty(hello.getUser_id()))
	        {
	        	return 0;
	        }
	        return template.update(query, hello.getUser_id(), hello.getUser_pw());
	    }
	    
	 public Integer listForSearchProperty(String id, String pw){
		 String query = "SELECT count(*) FROM user_table WHERE user_id = '" + id + "' AND user_pw = '"+pw + "'";
		 if(template.queryForObject(query, Integer.class) <= 0)
			 return -1;
			 
		 
		 String query2 = "SELECT id FROM user_table WHERE user_id = '" + id + "' AND user_pw = '"+pw + "'";
 
		 return template.queryForObject(query2, Integer.class);
		 
		 
		 
	 }
	 public boolean SearchProperty(String id){
		 String query = "SELECT count(*) FROM user_table WHERE user_id = '" + id + "'";

		 int count = template.queryForObject(query, Integer.class);
		 
		 return count > 0;
		 
	 }
//	 public String getData(String id)
//	 {
//		 String query = "SELECT count(*) FROM data_table WHERE id = '" + id + "'";
//		 if(template.queryForObject(query, Integer.class) <= 0)
//			 return "-1";
//			 
//		 
//		 String query2 = "SELECT data FROM data_table WHERE id = '" + id +"'";
// 
//		 return template.queryForObject(query2, String.class);
//	 }
//	 public int sendData(String id, String _data){
//		 
//		 if(getData(id) == "-1")
//		 {
//			 String query = "INSERT INTO data_table(id, data) VALUES(?, ?)";
//		        
//		     return template.update(query, Integer.parseInt(id), _data);
//		 }
//		 else{
//			 String query = "UPDATE data_table SET data = '" + _data + "' WHERE id = '" + Integer.parseInt(id) +"'";
//		        
//		     return template.update(query);
//		 }
//		 
//	 }
}
