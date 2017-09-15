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
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private BoardUserService userService;
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
		return "redirect:/user/findAll";
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
	public String Update(@Validated BoardUser user) {
		System.err.println("get from jsp was" + user);
		userService.save(user);
		return "redirect:/user/findAll";
	}
	@RequestMapping("/pageAll")
	public String pageAll(@RequestParam(required=false,defaultValue="1")String pageNumberStr,Map<String,Object> map){
			int pageNumber = 1;
			try {
				pageNumber=Integer.parseInt(pageNumberStr);
				if(pageNumber<1){
					pageNumber=1;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			Page<BoardUser> page=userService.getPage(pageNumber, 5);
			map.put("page",page);
		return "page/pageAll";
	}

}
