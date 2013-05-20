package mia.chat.controller;

import java.util.HashMap;
import java.util.Map;

import mia.core.model.MiaUser;
import mia.core.service.MiaUserServiceLocal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/*")
public class AuthenticateController {
	
	@Autowired
	private MiaUserServiceLocal miaUserService;

	@RequestMapping("auth/login")
	public @ResponseBody
	Map<String, Object> login(@RequestParam(required = false) String username, 
			@RequestParam(required = false) String password) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("username", username);
		
		MiaUser user = miaUserService.getUserByUserLogin(username);
		
		if (user != null && user.getPassword().equals(password)) {
			data.put("auth", "success");
		} else {
			data.put("auth", "failed");
		}
		
		return data;
	}
}
