package in.ineuron.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.ineuron.service.IWishMessageService;

@Controller
public class WishMessageController {

	@Autowired
	private IWishMessageService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {
		return "home";// String---> LVN
	}

	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public ModelAndView showWishMessage() {
	    String msg = service.generateWishMessage();
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("msg", msg);
	    mav.setViewName("display");
	    return mav;
	}


	/*
	 * @RequestMapping(value = "/wish", method = RequestMethod.GET) public String
	 * showWishMessage(Model model) {
	 * System.out.println("Implemenation class name is :: " +
	 * model.getClass().getName()); String msg = service.generateWishMessage();
	 * model.addAttribute("msg", msg); return "display"; }
	 */

	/*
	 * @RequestMapping(value = "/wish", method = RequestMethod.GET) public String
	 * showWishMessage(Map<String,Object> model) {
	 * System.out.println("Implemenation class name is :: " +
	 * model.getClass().getName()); String msg = service.generateWishMessage();
	 * model.put("msg", msg); return "display"; }
	 */

	/*
	 * @RequestMapping(value = "/wish", method = RequestMethod.GET) public void
	 * showWishMessage(Map<String,Object> model) {
	 * System.out.println("Implemenation class name is :: " +
	 * model.getClass().getName()); String msg = service.generateWishMessage();
	 * model.put("msg", msg); return ; }
	 */

	/*
	 * @RequestMapping(value="/wish",method = RequestMethod.GET) public void
	 * generateMessage(HttpServletResponse response) throws Exception{ String wmg =
	 * service.generateWishMessage(); response.setContentType("text/html");
	 * PrintWriter out = response.getWriter();
	 * out.println("<b>WishMessage :: "+wmg+"</b>"); }
	 */

	/*
	 * @RequestMapping(value = "/wish", method = RequestMethod.GET) public
	 * Map<String, Object> generateMessage() throws Exception { String wmg =
	 * service.generateWishMessage(); Map<String, Object> map = new HashMap<String,
	 * Object>(); map.put("msg", wmg); return map; }
	 */
}
