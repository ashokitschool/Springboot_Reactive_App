package in.ashokit;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

	//@Test
	public void testMono() {
		
		Mono<?> mono = Mono.just("ashokit")
				.then(Mono.error(new RuntimeException("Exception")))
				.log();

		mono.subscribe(System.out::println, (e) -> System.out.print(e.getMessage()));
	}
	
	@Test
	public void testFlux() {
		Flux<String> flux = Flux.just("java", "devops", "aws")
								.concatWithValues("Python", "Django")
							    .log();
		flux.subscribe(System.out::println);
		     
	}

}
