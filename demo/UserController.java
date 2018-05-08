package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserDao dao;
	
//	@RequestMapping("/")
//    public List getAllListForBeanPropertyRowMapper() {
//        return dao.listForBeanPropertyRowMapper();
//    }
	@RequestMapping("/addUser")
	public boolean addUser(@RequestParam("id")String id,@RequestParam("pw")String pw)
	{
		User u = new User();
		u.setUser_id(id);
		u.setUser_pw(pw);
		return dao.insert(u) > 0;
	}

    @RequestMapping("/loginUser")
    public String serachbytypeandrange(@RequestParam("id")String id,@RequestParam("pw")String pw){
    	Integer i = dao.listForSearchProperty(id, pw);
    	return i.toString();
    	
    }
//    @RequestMapping("/getdata")
//    public String getData(@RequestParam("id")String id)
//    {
//    	return dao.getData(id);
//    }
//    @RequestMapping("/senddata")
//    public int sendData(HttpServletRequest request)
//    {
//    	return dao.sendData(request.getParameter("id"), request.getParameter("data"));
//    }
}
