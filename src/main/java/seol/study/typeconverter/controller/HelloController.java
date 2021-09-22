package seol.study.typeconverter.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seol.study.typeconverter.type.IpPort;

@RestController
public class HelloController {

	@GetMapping("/hello-v1")
	public String helloV1(HttpServletRequest request) {
		String data = request.getParameter("data");
		Integer intValue = Integer.valueOf(data);
		System.out.println("intValue = " + intValue);
		return "ok";
	}

	@GetMapping("/hello-v2")
	public String helloV2(@RequestParam Integer data) {
		System.out.println("data = " + data);
		return "ok";
	}

	@GetMapping("/ip-port")
	public String stringToIpPort(@RequestParam IpPort ipPort) {
		System.out.println("ipPort.getIp() = " + ipPort.getIp());
		System.out.println("ipPort.getPort() = " + ipPort.getPort());
		return "ok";
	}

}
