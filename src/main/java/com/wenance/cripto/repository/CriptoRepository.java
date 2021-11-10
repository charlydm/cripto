package com.wenance.cripto.repository;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.wenance.cripto.entity.Criptomoneda;

import reactor.core.publisher.Flux;

@Repository
public interface CriptoRepository extends ReactiveMongoRepository<Criptomoneda,String> {
	
	Flux<Criptomoneda> findByCurr1(String symbol);
	
	Flux<Criptomoneda> findByDate(LocalDateTime date);
	
	//Flux<Criptomoneda> findByLpriceBetween(Range<Double> priceRange);
	
}
