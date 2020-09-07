package eu.fayder.restcountries.v2.domain;

import java.util.ArrayList;
import java.util.List;

public class CountryList {

  private List<Country> Countries;

  public CountryList() {
    Countries = new ArrayList<>();
  }

  public List<Country> getCountries() {
    return Countries;
  }

  public void setCountries(List<Country> countries) {
    Countries = countries;
  }
}
