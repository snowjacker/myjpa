package myjpa.controller;

import java.util.List;

import myjpa.entity.BoardUser;
import myjpa.service.BoardUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ju")
public class JsonUser {
	@Autowired
	private BoardUserService userService;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public BoardUser login(@RequestBody BoardUser user){
		user=userService.findByUserNameAndUserPassword(user.getUserName(),user.getUserPassword());
		if(user==null){
			return null;
		}
		return user;
	}
	@RequestMapping(value = "/findAll")
	public List<BoardUser> findAll(ModelMap map) {
		List<BoardUser> users = userService.findAll();
		map.put("users", users);
		return users;
	}
	
}
