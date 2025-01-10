package com.in28minutes.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	//"say-hello => "Hello What are you learning today?"
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First Web Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My First html page with body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	//say-hello-jsp => sayHelloController =>sayHelloJsp method => sayHello.jsp
	//say-hello-jsp url is hit on browser which takes to sayHellojsp method which returns the name of jsp
	//then spring uses veiw resolver(suffix and prefix are used) present in app. properties to redirect request to the jsp file
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
