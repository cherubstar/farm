package com.roper.controller;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.roper.api.UserService;
import com.roper.entity.DataTableReturnObject;
import com.roper.entity.Regist;
import com.roper.entity.User;
import com.roper.surface.UserSurface;
import com.roper.utils.UnicodeUtil;

@Controller
public class LoginController {

	@SuppressWarnings("unchecked")
	@Autowired
	public UserService userService;

	Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("login.action")
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		System.out.println("============================");
		System.out.println("||         用户登录输入                   ||");
		System.out.println("============================");
		System.out.println("||     用户名 :　" +username);
		System.out.println("||     密码 : " +password);
		System.out.println("============================");
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (IncorrectCredentialsException ice) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("message", "password error!");
			return mv;
		} catch (UnknownAccountException uae) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("message", "username error!");
			return mv;
		} catch (ExcessiveAttemptsException eae) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("message", "times error");
			return mv;
		}

		return new ModelAndView("main");
	}

	@RequestMapping("LoginServlet.action")
	@ResponseBody
	public String loginServlet(String account, String password) {
		JSONObject jsonObecjt = new JSONObject();
		JSONObject jsonObecjt1 = new JSONObject();
		User user = null;
		if (org.apache.commons.lang.StringUtils.isNotBlank(account)) {
			user = new UserSurface<User>(User.class, account).queryByUserName();
		} else {
			jsonObecjt.accumulate("code", 201);
			jsonObecjt.accumulate("msg", "There is have not Account");
			jsonObecjt.accumulate("data", 0);
			return jsonObecjt.toString();
		}
		if (user != null) {
			if (user.getUsername().equals(UnicodeUtil.toUnicode(account)) && user.getPassword().equals(UnicodeUtil.toUnicode(password))) {
				jsonObecjt.accumulate("code", 200);
				jsonObecjt.accumulate("msg", "Login Success");
				jsonObecjt1.accumulate("name", user.getUsername());
				jsonObecjt.accumulate("data", jsonObecjt1);
			} else {
				jsonObecjt.accumulate("code", 201);
				jsonObecjt.accumulate("msg", "Login failed");
				jsonObecjt.accumulate("data", 0);
			}

		} else {
			jsonObecjt.accumulate("code", 201);
			jsonObecjt.accumulate("msg", "Unable to find this user");
			jsonObecjt.accumulate("data", 0);
		}

		return jsonObecjt.toString();
	}
	
	@RequestMapping("RegistServlet.action")
	@ResponseBody
	public String regist(String account, String password, String permission, String department, String name) {
		JSONObject jsonObecjt = new JSONObject();
		
		System.out.println("============================");
		System.out.println("||         又一个新用户                 ||");
		System.out.println("============================");
		System.out.println("||     account:  " +account);
		System.out.println("||     password:  " +password);
		System.out.println("||     permission:  " +permission);
		System.out.println("||     department:  " +department);
		System.out.println("||     name:  " +name);
		System.out.println("============================");
		System.out.println("||        热烈欢迎新用户                 ||");
		System.out.println("============================");
		
		if (org.apache.commons.lang.StringUtils.isNotBlank(account)) {
			//根据输入的用户名查找是否有该用户信息
			User user = new UserSurface<User>(User.class, account).queryByUserName();
			//判断是否查询到
			if (user != null) {
				jsonObecjt.accumulate("code", 201);
				jsonObecjt.accumulate("msg", "There already existsed Account");
				jsonObecjt.accumulate("data", 0);
				return jsonObecjt.toString();
			} else {
				Regist regist = new UserSurface<Regist>(Regist.class, account).queryByUserName();
				if(regist != null){
					jsonObecjt.accumulate("code", 201);
					jsonObecjt.accumulate("msg", "The acount already formed");
					jsonObecjt.accumulate("data", account);
					return jsonObecjt.toString();
				} else {
					userService.regist(account, password, permission, department, name);
					jsonObecjt.accumulate("code", 200);
					jsonObecjt.accumulate("msg", "success");
				}
			}
			jsonObecjt.accumulate("data", account);
		} else {
			jsonObecjt.accumulate("code", 201);
			jsonObecjt.accumulate("msg", "There is not insert Account");
			jsonObecjt.accumulate("data", 0);
			return jsonObecjt.toString();
		}

		return jsonObecjt.toString();
	}

	/**
	 * 查询所有用户
	 */
	@RequestMapping("queryUser.action")
	@ResponseBody
	public String UserQuery() {
		
		DataTableReturnObject user = userService.findAllUser();
		String str = JSON.toJSONString(user);
		str = str.replace("\\", "").replace("\"[", "[").replace("]\"", "]");
		
		return str;
	}
	
	/**
	 * 查询所有注册用户
	 */
	@RequestMapping("queryRegister.action")
	@ResponseBody
	public String queryRegister() throws IOException {

		DataTableReturnObject user = userService.findAllRegiser();
		JSONObject json = JSONObject.fromObject(user);
		String str = json.toString();
		str = str.replace("\\", "").replace("\"[", "[").replace("]\"", "]");

		return str;
	}

	/**
	 * 添加用戶
	 */
	@RequestMapping("addUser.action")
	@ResponseBody
	public String addUser(String username) {
		if (StringUtils.isNotBlank(username)) {
			userService.addUser(username);
		} else {
			return "username为空";
		}
		return "成功添加" + username;
	}

	/**
	 * 拒绝添加
	 */
	@RequestMapping("refuse.action")
	@ResponseBody
	public void refuse(String username) {
		/*if (StringUtils.isNotBlank(username)) {
			userService.refuse(username);
		} else {
			return "username为空";
		}
		return "已经拒绝" + username;*/
		System.out.println("删除的用户: " +username);
		userService.refuse(username);
	}
	
	/**
	 * 删除已存在用户
	 */
	@RequestMapping("delete.action")
	public String delete(Integer id){
		userService.delete(id);
		return "1";
	}
}