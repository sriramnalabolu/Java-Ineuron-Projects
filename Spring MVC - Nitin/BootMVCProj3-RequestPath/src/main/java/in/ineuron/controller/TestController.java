package in.ineuron.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@GetMapping(value="/report")
	public String showReport(Map<String, Object> model) {
	    System.out.println("TestController.showReport()");
	    return "display";
	}
	
	

	/*
	 * @RequestMapping public String showHome() { return "home"; }
	 */
	
	/*
	 * @GetMapping(value = "report") public String showReport(Map<String, Object>
	 * model) { System.out.println("TestController.showReport()"); return "display";
	 * }
	 * 
	 * @PostMapping(value = "report") public String showReport1(Map<String, Object>
	 * model) { System.out.println("TestController.showReport1()"); return
	 * "display"; }
	 */

	
	/*
	 * @PostMapping(value="/report") //@RequestMapping(value = "/report", method =
	 * RequestMethod.POST) public String showReport(Map<String, Object> model) {
	 * System.out.println("TestController.showReport()"); return "display"; }
	 * 
	 * @GetMapping(value="/report") //@RequestMapping(value = "/report", method =
	 * RequestMethod.GET) public String showReport1(Map<String, Object> model) {
	 * System.out.println("TestController.showReport1()"); return "display1"; }
	 */
    
	
	/*
	 * @GetMapping(value = {"/report","/report1","/report2"}) public String
	 * showReport(Map<String, Object> model) {
	 * System.out.println("TestController.showReport()"); return "display"; }
	 */
	
}
