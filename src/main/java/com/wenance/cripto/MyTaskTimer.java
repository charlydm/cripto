package com.wenance.cripto;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.wenance.cripto.entity.Criptomoneda;
import com.wenance.cripto.http.CriptoResponseImpl;

public class MyTaskTimer extends TimerTask {
	
	CriptoResponseImpl response = new CriptoResponseImpl();
	
	@Override
	public void run() {
		HttpResponse<String> httpResponseBTC = response.lastPriceResponse("BTC");
		if (httpResponseBTC.statusCode()==200) {
			saveCripto(FormatObject(httpResponseBTC));
		}
		HttpResponse<String> httpResponseETH = response.lastPriceResponse("ETH");
		if (httpResponseETH.statusCode()==200) {
			saveCripto(FormatObject(httpResponseETH));
		}
	}
	
	private void saveCripto(String body) {
		response.saveCripto(body);
	}
	
	private String FormatObject(HttpResponse<String> httpResponse) {
		Gson gson = new Gson();
		Criptomoneda criptomoneda = gson.fromJson(httpResponse.body(), Criptomoneda.class);
		criptomoneda.setAmnt(2.2);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String stringDate = LocalDateTime.now().format(dtf);
		criptomoneda.setDate(LocalDateTime.parse(stringDate, dtf));
		return JSONObject.wrap(criptomoneda).toString();
	}

}
