package com.test.pds;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserController {
	@RequestMapping(value="idCheck",method = RequestMethod.POST)
	public String idcheck(@RequestParam(value="id") String id) {
		System.out.println("idCheck : "+id);
		return "T"; // 사용가능하면 T, 불가능하면 F
	}
}
