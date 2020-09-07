# test-rest-api

## build project

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