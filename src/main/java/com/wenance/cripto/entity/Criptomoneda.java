package com.wenance.cripto.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "criptomonedas")
public class Criptomoneda {

	@Id
	private String id;
	private double lprice;
    private String curr1;
    private String curr2;
	private double amnt;
	//@JsonInclude(JsonInclude.Include.NON_NULL)
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;
	
	public Criptomoneda(double lprice, String curr1, String curr2, double amnt, LocalDateTime date) {
		super();
		this.lprice = lprice;
		this.curr1 = curr1;
		this.curr2 = curr2;
		this.amnt = amnt;
		this.date = date;
	}
	
}
