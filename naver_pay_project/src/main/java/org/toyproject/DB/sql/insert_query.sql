show tables;

SELECT * FROM USER_INFO;

INSERT INTO USER_INFO (user_id, user_pw, user_name, user_ph, user_addr)
VALUES ('a1234','a123!@#','tester1','010-1111-1111','home1'),
       ('b1234','b123!@#','tester2','010-2222-2222','home2'),
       ('c1234','c123!@#','tester3','010-3333-3333','home3'),
       ('d1234','d123!@#','tester4','010-4444-4444','home4'),
       ('e1234','e123!@#','tester5','010-5555-5555','home5'),
       ('f1234','f123!@#','tester6','010-6666-6666','home6'),
       ('g1234','g123!@#','tester7','010-7777-7777','home7'),
       ('h1234','h123!@#','tester8','010-8888-8888','home8'),
       ('i1234','i123!@#','tester9','010-9999-9999','home9');

INSERT INTO COMPANY (COMPANY_NAME, COMPANY_TEL, COMPANY_STORE, BUSINESS_NUMBER)
VALUES ('배달의 민족','02-111-1111','URL',1111),
       ('당근 마켓','02-222-2222','URL',2222),
       ('마켓 컬리','02-333-3333','URL',3333),
       ('스마트 스토어1','02-444-4444','URL',4444),
       ('스마트 스토어2','02-555-5555','URL',5555),
       ('스마트 스토어3','02-666-6666','URL',6666);

INSERT INTO product(product_id,product_name, product_price, product_amount, company_id, supply_point)
VALUES (1,'testproductName',10000,1,1,500),
        (2, 'testproductName2',20000,1,2,100);

INSERT INTO PAYMENT(payment_id,PAYMENT_METHOD,USER_SERIAL_NUM,USED_POINT,PAYMENT_MONEY)
VALUES (1,'card',1,300,50000),
        (2, 'card',1,1,30000);

INSERT INTO ORDER_INFO(order_product_id, order_payment_id, order_date)
VALUES (1,1,'2022-11-10'),
       (2,2,'2021-5-5');

