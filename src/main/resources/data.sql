Drop table CURRENCYCONVERTER if exists;

Create table CURRENCYCONVERTER
(countrycode integer not null,countryname varchar(255),currency varchar(255),conversionfactor number);

Insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values
('91','India','INR','1.0'),
('1684','America','USD','71.8'),
('33','France','EURO','79.1'),
('81','Japan','YEN','0.6'),
('60','Malaysia','MYR','17.4'),
('971','United Arab Emirates','AED','19.6'),
('41','Switzerland','CHF','74.5'),
('43','Switzerland2','CHF','74.5');