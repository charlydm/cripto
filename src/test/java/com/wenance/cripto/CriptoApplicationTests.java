package com.wenance.cripto;

import static org.mockito.Mockito.when;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.wenance.cripto.controller.CriptoController;
import com.wenance.cripto.entity.Criptomoneda;
import com.wenance.cripto.service.CriptoService;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(CriptoController.class)
class CriptoApplicationTests {
	
	@Autowired
    private WebTestClient webTestClient;
	
	@MockBean
	private CriptoService service;

	@Test
	void addCriptoTest() {
		Mono<Criptomoneda> criptomonedaMono=Mono.just(new Criptomoneda(66922.4, "BTC", "USD", 2.2, LocalDateTime.now()));
		Criptomoneda criptomoneda = new Criptomoneda(66922.4, "BTC", "USD", 2.2, LocalDateTime.now());
		when(service.saveCripto(criptomoneda)).thenReturn(criptomonedaMono);

		webTestClient.post().uri("/cripto")
				.body(Mono.just(criptomoneda),Criptomoneda.class)
				.exchange()
				.expectStatus().isOk();//200
	}

}
