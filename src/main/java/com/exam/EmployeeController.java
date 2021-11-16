package com.exam;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao empdao;
	@Autowired
	AddressDao adddao;

	@RequestMapping(value = "/saveForm")
	public String saveForm(@ModelAttribute() Employee e, Model m) {

		return "form";
	}
//working ok
//	@RequestMapping(value = "/save")
//	public String save(@ModelAttribute() Employee e, @RequestParam() String roadno, @RequestParam() String streetno, @RequestParam() String pobox, Model m) {
//		e.address = new Address(roadno,streetno,pobox);
//		System.out.println(e.address);
//		 adddao.save(e.address);
//		 empdao.save(e);
//		m.addAttribute("roadno", roadno);
//		return "success";
//	}
	
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute() Employee e, @RequestParam() String roadno, @RequestParam() String streetno, @RequestParam() String pobox, Model m) {
		e.address = new Address(roadno,streetno,pobox);
		System.out.println(e.address);
		 adddao.save(e.address);
		 empdao.save(e);
		m.addAttribute("roadno", roadno);
		return "success";
	}

}
