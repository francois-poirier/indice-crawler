# indice-crawler
This is the repository for the example of using Spring Integration and JSoup java HTML Parser


## Requirements to build this project

1.    Java 8
2.    Maven


## Setup Instructions

Clone or fork the repo
```
     git clone https://github.com/francois-poirier/indice-crawler.git
     cd indice-crawler
```
Build all projects
```
     mvn -DskipTests=true clean package
```

### Running Spring Boot application ###

java -jar ./target/indice-crawler-0.0.1-SNAPSHOT.jar

### Output console ###

2018-02-19 14:48:49.593  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=Canada, indice=S&P/TSX, last=15 074.25 (c), var=-2.16%, eve=15 407.66, varJanuaryFirst=0.00%]
2018-02-19 14:48:49.598  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=Canada, indice=S&P/TSX 60 INDEX, last=889.51 (c), var=-2.24%, eve=909.86, varJanuaryFirst=0.00%]
2018-02-19 14:48:49.602  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=États-Unis, indice=DOW JONES INDUSTRIAL AVERAGE, last=25 219.38 (c), var=0.08%, eve=25 200.37, varJanuaryFirst=2.02%]
2018-02-19 14:48:49.608  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=États-Unis, indice=NASDAQ Composite, last=7 239.47 (c), var=-0.23%, eve=7 256.43, varJanuaryFirst=4.87%]
2018-02-19 14:48:49.612  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=États-Unis, indice=NASDAQ 100 INDEX, last=6 770.66 (c), var=-0.36%, eve=6 794.92, varJanuaryFirst=5.85%]
2018-02-19 14:48:49.615  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=Chili, indice=Santiago IGPA, last=20 863.58, var=-0.09%, eve=20 881.67, varJanuaryFirst=1.20%]
2018-02-19 14:48:49.617  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=Argentine, indice=BUENOS AIRES MERVAL, last=32 677.25, var=0.00%, eve=32 677.25, varJanuaryFirst=8.69%]
2018-02-19 14:48:49.620  INFO 18073 --- [ask-scheduler-4] org.poc.IndiceCrawlerApplication         : entry=IndiceEntry [country=Allemagne, indice=DAX, last=12 412.45, var=-0.32%, eve=12 451.96, varJanuaryFirst=-3.91%]



