package com.wenance.cripto.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wenance.cripto.entity.Criptomoneda;
import com.wenance.cripto.service.CriptoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cripto")
public class CriptoController {
	
	@Autowired
	private CriptoService service;
	
	@GetMapping("/symbol/{symbol}")
    public Flux<Criptomoneda> getCriptoSymbol(@PathVariable String symbol){
		return service.getSymbolCripto(symbol);
	}
	
	@GetMapping
    public Flux<Criptomoneda> getCriptomonedas(){
		return service.getAllCriptomoneda();
	}
	
	@GetMapping("/{date}")
    public Flux<Criptomoneda> getCriptoTimer(@PathVariable String date){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		TemporalAccessor ta = dtf.parse(date);
		LocalDateTime ldt = LocalDateTime.from(ta);
		return service.getDateCripto(ldt);
	}
	
	@PostMapping
    public Mono<Criptomoneda> saveCripto(@RequestBody Criptomoneda Criptomoneda){
        return service.saveCripto(Criptomoneda);
    }
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteCripto(@PathVariable String id){
		return service.deleteCripto(id);
	}
	
	@GetMapping("/calculate")
    public Flux<Criptomoneda> getCriptoCalculate(@RequestParam("desde") String desde, @RequestParam("hasta") String hasta){
		return service.calculate(desde, hasta);
	}
	
	@GetMapping("/convert/{symbol}")
    public Flux<Criptomoneda> convert(@PathVariable String symbol){
		return service.getSymbolCripto(symbol);
	}

}
