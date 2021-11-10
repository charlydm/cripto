package com.wenance.cripto.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wenance.cripto.entity.Criptomoneda;
import com.wenance.cripto.repository.CriptoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CriptoService {

	@Autowired
	private CriptoRepository repository;
	
	public Flux<Criptomoneda> getAllCriptomoneda(){
		 return repository.findAll();
	}
	 
	public Flux<Criptomoneda> getSymbolCripto(String symbol){
		 return repository.findByCurr1(symbol);
	}
	 
	public Mono<Criptomoneda> saveCripto(Criptomoneda criptomoneda){
		 return repository.insert(criptomoneda);
	}
	
	public Flux<Criptomoneda> getDateCripto(LocalDateTime date){
		return repository.findByDate(date);
	}
	
	public Mono<Void> deleteCripto(String id){
        return repository.deleteById(id);
    }
	
	public Flux<Criptomoneda> calculate(String desde, String hasta){
		return repository.findAll();
	}
	
}
