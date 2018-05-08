package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
	@Autowired
	 private JdbcTemplate template;
	 
	 public List<Comment> listForBeanPropertyRowMapper() {
	        String query = "SELECT * FROM comment_table";
	        return template.query(query, new BeanPropertyRowMapper(Comment.class));
	    }

	    public int insertComment(Comment hello) {
	        String query = "INSERT INTO comment_table(id, value) VALUES(?, ?)";
	        
	       /* if(SearchProperty(hello.getUser_id()))
	        {
	        	return 0;
	        }*/
	        return template.update(query, hello.getId(), hello.getValue());
	    }
	    
//	 public Integer listForSearchProperty(String id){
//		 String query = "SELECT count(*) FROM comment_table WHERE id = '" + id + "'";
//		 if(template.queryForObject(query, Integer.class) <= 0)
//			 return -1;
//			 
//		 
//		 String query2 = "SELECT id FROM user_table WHERE user_id = '" + id + "' AND user_pw = '"+pw + "'";
//
//		 return template.queryForObject(query2, Integer.class);
//		 
//		 
//		 
//	 }
	 public List<Comment> SearchComment(String id){
		 String query = "SELECT * FROM comment_table WHERE id = '" + id + "'";

		return template.query(query, new BeanPropertyRowMapper(Comment.class));
		 
	 }
}
