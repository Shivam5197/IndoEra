package com.Indoera.ecomProject.BasicControllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return null;
	}
	@RequestMapping("/error")
	public String ErrorPage() {
		return "Error/error";
	}

}
