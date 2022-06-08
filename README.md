# auctionRepo

Access H2 DB: 
http://localhost:8080/h2-ui and use DataSource: "jdbc:h2:mem:testdb"

Swagger UI:

http://localhost:8080/swagger-ui.html

While creating auction request please use Id's from below table. Else you will be thrown Data integrity Error.

Insert Auction Items as Prerequisite:

INSERT INTO ITEM VALUES(1, 'Mobile');

INSERT INTO ITEM VALUES(2, 'Laptop');

INSERT INTO ITEM VALUES(3, 'Desktop');
