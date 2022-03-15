package com.jd.customer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

	@RequestMapping("/viewReport")
	public String viewReport() {
		System.out.println("viewReport : Adding customer viewReport ");
		System.out.println("");
		
		return "viewReport";


	}
	
}
