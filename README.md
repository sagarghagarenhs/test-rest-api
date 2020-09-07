# test-rest-api

## Introduction
At Healthcare Gateway, our interoperability services communicate with a variety of systems using a range of APIs. In this programming exercise, you will develop a REST API which processes data retrieved from another REST API.

## Task
Your API should support requests of the form
	/borderInfo?currency=AAA
where AAA is an ISO 4217 alphabetic currency code.

Requests should return a JSON data structure containing:
1.	a list of countries which use that currency
2.	a list of countries which border the countries in 1 but do not use the currency.

Countries should be represented using their ISO 3166-1 3-letter codes.
Your service should make use of the REST API provided by 

	https://restcountries.eu/#rest-countries


## Build project

mvn clean install

## Run 
mvn spring-boot:run

## Sample Request & Response

http://localhost:8909/borderInfo?currency=EUR

{
   "countriesWithMatchingCurrencyCode":[
      "ALA",
      "AND",
      "AUT",
      "BEL",
      "CYP",
      "EST",
      "FIN",
      "FRA",
      "GUF",
      "ATF",
      "DEU",
      "GRC",
      "GLP",
      "VAT",
      "IRL",
      "ITA",
      "LVA",
      "LTU",
      "LUX",
      "MLT",
      "MTQ",
      "MYT",
      "MCO",
      "MNE",
      "NLD",
      "PRT",
      "KOS",
      "REU",
      "BLM",
      "MAF",
      "SPM",
      "SMR",
      "SVK",
      "SVN",
      "ESP",
      "ZWE"
   ],
   "countriesWithBorder1AndNotMatchingCurrencyCode":[
      "BRN",
      "CAN",
      "DNK",
      "DOM",
      "GMB",
      "GIB",
      "HTI",
      "HKG",
      "LSO",
      "MAC",
      "PNG",
      "QAT",
      "SXM",
      "KOR",
      "LKA",
      "TLS",
      "GBR"
   ]
} 