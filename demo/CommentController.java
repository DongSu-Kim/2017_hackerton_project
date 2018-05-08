package com.example.demo;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	@Autowired
	private CommentDao dao;
	
//	@RequestMapping("/")
//    public List getAllListForBeanPropertyRowMapper() {
//        return dao.listForBeanPropertyRowMapper();
//    }
	@RequestMapping("/insertComment")
	public boolean insertComment(@RequestParam("id")String id,@RequestParam("value")String value)
	{
		if(value.isEmpty())
			return false;
		Comment c = new Comment();
		c.setId(Integer.parseInt(id));
		c.setValue(value);
		
		return dao.insertComment(c) > 0;
	}

    @RequestMapping("/searchComment")
    public List serachbytypeandrange(@RequestParam("id")String id){
    	return dao.SearchComment(id);
    	
    }
}
