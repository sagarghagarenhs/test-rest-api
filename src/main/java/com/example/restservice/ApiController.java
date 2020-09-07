package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import eu.fayder.restcountries.v2.domain.Country;
import eu.fayder.restcountries.v2.domain.Currency;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ApiController {

  private static Country[] allCountries = null;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/borderInfo")
  public Object greeting(@RequestParam(value = "currency", defaultValue = "AAA") String currency) {
    log.info("currency {} ", currency);

    if (allCountries == null) {
      allCountries =
          restTemplate.getForObject("https://restcountries.eu/rest/v2/all", Country[].class);
    }
    log.info("allCountries {} ", allCountries.length);

    return new BorderInfo(getCountriesByCurrencyCode(allCountries, currency),
        getCountriesByBorder1AndNotCurrencyCode(allCountries, currency));
  }

  private List<String> getCountriesByCurrencyCode(Country[] allCountries, String currency) {
    List<String> countriesISO3166_1_3LetterCodes = new ArrayList<String>();
    for (Country country : allCountries) {
      List<Currency> currencies = country.getCurrencies();
      boolean flag = false;
      if (currencies != null) {
        for (Currency currencyCode : currencies) {
          if (currencyCode != null && currencyCode.getCode() != null
              && currencyCode.getCode().equalsIgnoreCase(currency) && !flag) {
            countriesISO3166_1_3LetterCodes.add(country.getAlpha3Code());
            flag = true;
          }
        }
      }
    }
    return countriesISO3166_1_3LetterCodes;
  }

  private List<String> getCountriesByBorder1AndNotCurrencyCode(Country[] allCountries,
      String currency) {
    List<String> countriesISO3166_1_3LetterCodes = new ArrayList<String>();
    for (Country country : allCountries) {
      if (country.getBorders().size() == 1) {
        List<Currency> currencies = country.getCurrencies();
        boolean flag = false;
        if (currencies != null) {
          for (Currency currencyCode : currencies) {
            if (currencyCode != null && currencyCode.getCode() != null
                && !currencyCode.getCode().equalsIgnoreCase(currency) && !flag) {
              countriesISO3166_1_3LetterCodes.add(country.getAlpha3Code());
              flag = true;
            }
          }
        }
      }
    }
    return countriesISO3166_1_3LetterCodes;
  }
}
