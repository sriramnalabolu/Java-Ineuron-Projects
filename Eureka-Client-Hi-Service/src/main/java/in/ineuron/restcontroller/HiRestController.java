package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiRestController {

	@GetMapping("/hi/{name}")
	public String sayHiee(@PathVariable("name") String name) {

		String hieeMsg = "hiee";
		
		return hieeMsg + "---- " + " " + name + " how r u ?";
	}
}

