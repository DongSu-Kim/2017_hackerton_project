package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonDao dao;
	
//	@RequestMapping("/")
//    public List getAllListForBeanPropertyRowMapper() {
//        return dao.listForBeanPropertyRowMapper();
//    }
	@RequestMapping("/addPerson")
	public int addPerson(
			@RequestParam("name")String name,
			@RequestParam(value="image", defaultValue = "")String image,
			@RequestParam(value="age", defaultValue = "")String age,
			@RequestParam(value="id_num", defaultValue = "")String id_num,
			@RequestParam(value="introduce", defaultValue = "")String introduce,
			@RequestParam(value="major", defaultValue = "")String major,
			@RequestParam(value="sex", defaultValue = "1")int sex
			)
	{
		Person p = new Person();
		p.setName(name);
		p.setImage(image);
		p.setAge(age);
		p.setId_num(id_num);
		p.setIntroduce(introduce);
		p.setMajor(major);
		p.setSex(sex);
		p.setVote(0);
				
		return dao.insert(p);
	}

    @RequestMapping("/searchPerson")
    public List serarchPersonByName(@RequestParam("name")String name){
    	return dao.listSearchByName(name);
    }
    @RequestMapping("/listPerson")
    public List listPerson(
    		@RequestParam("sex")int sex)
    {
    	return dao.listBySex(sex);
    }
    @RequestMapping("/votePerson")
    public int votePerson(
    		@RequestParam("id")int id)
    {
    	return dao.votePerson(id);
    }
}
