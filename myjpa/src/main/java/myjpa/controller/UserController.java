package myjpa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import myjpa.entity.BoardUser;
import myjpa.service.BoardUserService;
import myjpa.util.IntegerEditer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	@InitBinder
	public void Binder(ServletRequestDataBinder srdb) {
		srdb.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyy-MM-dd"), false));
		srdb.registerCustomEditor(int.class, new IntegerEditer());
	}

	@RequestMapping(value = "/delete/{userId}")
	public String Delete(@PathVariable int userId) {
		System.err.println(userId);
		userService.delete(userId);
		return "forward:findAll";
	}

	@RequestMapping(value = "/findAll")
	public String findAll(ModelMap map) {
		List<BoardUser> users = userService.findAll();
		map.put("users", users);
		return "welcome";
	}

	@RequestMapping(value = "/findbyid/{userId}", method = RequestMethod.GET)
	public String findById(@PathVariable Integer userId, ModelMap map) {
		BoardUser user = userService.findById(userId);
		map.put("user", user);
		return "update";
	}

	@RequestMapping(value = "/findbyname", method = RequestMethod.POST)
	public String findByUserName(@RequestParam String userName) {
		BoardUser user = userService.findByUserName(userName);
		if (user == null) {
			return "0";
		} else {
			return "1";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(ModelMap map, @RequestParam String userName,
			@RequestParam String userPassword) {
		BoardUser user = userService.findByUserNameAndUserPassword(userName,
				userPassword);
		if (user == null) {
			return "login";
		}
		map.put("userName", user.getUserName());
		return "forward:findAll";
	}

	/*
	 * @ModelAttribute public BoardUser getUser() { BoardUser user = new
	 * BoardUser(); return user; }
	 */

	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String reg(Map<String, Object> map) {
		BoardUser boardUser = new BoardUser();
		map.put("boardUser", boardUser);
		return "reg";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String reg(ModelMap map, @Validated BoardUser boardUser,
			BindingResult loginVal) {
		if (loginVal.getErrorCount() > 0) {
			for (FieldError fieldError : loginVal.getFieldErrors()) {
				System.out.println(fieldError.getField() + ":"
						+ fieldError.getDefaultMessage());
				return "reg";
			}
		}
		userService.save(boardUser);
		map.put("userName", boardUser.getUserName());
		return "forward:findAll";
	}

	@RequestMapping(value = "/tologin", method = RequestMethod.GET)
	public String tologin() {
		return "login";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String Update(
			@RequestParam(required = true) @Validated BoardUser user) {
		System.err.println("get from jsp was" + user);
		userService.save(user);
		return "forward:findAll";
	}

	@Autowired
	private BoardUserService userService;
}
