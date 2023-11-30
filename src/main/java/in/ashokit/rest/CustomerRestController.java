package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.dto.Customer;
import in.ashokit.service.CustomerService;
import reactor.core.publisher.Flux;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public List<Customer> getAllCustomers() throws InterruptedException {
		return service.loadAllCustomers();
	}

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getAllCustomersStream() throws InterruptedException {
		return service.loadAllCustomersStream();
	}
}
