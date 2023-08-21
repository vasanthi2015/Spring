package com.example.micro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currencyconverter/from/{from}/to/{to}/{quantity}")
    public CurrencyConverter getCurrencyCoversion(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConverter> response = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}",
                CurrencyConverter.class, uriVariables);
        CurrencyConverter ce = response.getBody();
        return new CurrencyConverter(ce.getId(), ce.getFrom(), ce.getTo(), quantity,ce.getConversionMultiple(),
                ce.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)));

    }

    @GetMapping("/currencyconverter-feign/from/{from}/to/{to}/{quantity}")
    public CurrencyConverter calculateCurrencyConversionFeign( @PathVariable String from, @PathVariable String to,
                                                               @PathVariable Integer quantity) {
        CurrencyConverter currencyConverter=  proxy.retrieveExchangeValue(from, to);
        currencyConverter.setAmount(currencyConverter.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)));
        return currencyConverter;
    }
}
