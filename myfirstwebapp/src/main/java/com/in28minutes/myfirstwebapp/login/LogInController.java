package com.in28minutes.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LogInController {
	
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	private AuthenticationService authenticationService;
//	
//	
//	public LogInController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

//	@RequestMapping("login")
//	public String goToLogInPage(@RequestParam String name,ModelMap model) {
//		model.put("date", new Date());
//		model.put("name", name);
//		//if logging level is not set to debug in app.properties file this log will not be printed as it is at debug level
//		logger.debug("Request Param is {}",name);
//		logger.info("I want this printed at info level");
//		logger.warn("I want this printed at warn level");
////		System.out.println("Request Param is "+name);
//		return "login";
//	}
	
//	@RequestMapping(value="login",method = RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}
	
	@RequestMapping(value="/")
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	//when RequestMethod type is post this method is called
//	@RequestMapping(value="login",method = RequestMethod.POST)
//	public String gotoWelcomePage(ModelMap model,@RequestParam String name,@RequestParam String password) {
//		
//		if(authenticationService.authenticate(name,password)) {
//			model.put("name",name);
//			model.put("password", password);
//			return "welcome";
//		}
//		model.put("errorMessage","Invalid Credentials");
//		return "login";
//		
//	}
	
}
