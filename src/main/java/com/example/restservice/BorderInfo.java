package com.example.restservice;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorderInfo {

  private List<String> countriesWithMatchingCurrencyCode;
  private List<String> countriesWithBorder1AndNotMatchingCurrencyCode;
}
