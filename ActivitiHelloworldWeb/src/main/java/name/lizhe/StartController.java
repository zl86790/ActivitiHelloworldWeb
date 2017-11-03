package name.lizhe;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StartController {
	
	@Autowired
	RuntimeService runtimeService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		System.out.println("running...");
		String pid = runtimeService.startProcessInstanceByKey("helloprocess").getId();
		return "helloworld" + pid;
	}
}
