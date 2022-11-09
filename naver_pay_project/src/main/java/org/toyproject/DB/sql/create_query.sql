show tables;


SELECT A.user_id,
       A.user_point,
       C.order_id,
       C.order_date,
       D.product_name,
       D.product_price,
       E.company_name,
       E.company_tel
FROM USER_INFO A
        LEFT OUTER JOIN
    PAYMENT B on A.user_serial_num = B.user_serial_num
        LEFT OUTER JOIN
     order_info C on B.payment_id = C.order_payment_id
        LEFT OUTER JOIN
     Product D on C.order_product_id = D.product_id
        LEFT OUTER JOIN
     Company E on E.company_id = D.company_id

WHERE user_id = 'a1234' ORDER BY order_date DESC;

CREATE TABLE user_info(
                          user_serial_num LONG NOT NULL AUTO_INCREMENT,
                          user_id varchar(128) NOT NULL,
                          user_pw varchar(255) NOT NULL,
                          user_name varchar(255) NOT NULL,
                          user_ph char(13),
                          user_addr varchar(255),
                          user_point int DEFAULT 0,
                          PRIMARY KEY (user_serial_num)
);

CREATE TABLE company(
                        company_id LONG NOT NULL AUTO_INCREMENT,
                        company_name varchar(255) NOT NULL,
                        company_tel char(12) NOT NULL,
                        company_store varchar(255) NOT NULL,
                        business_number int NOT NULL,
                        PRIMARY KEY (company_id)
);

CREATE TABLE product(
                        product_id LONG NOT NULL AUTO_INCREMENT,
                        product_name varchar(255) NOT NULL,
                        product_price LONG NOT NULL,
                        product_amount int NOT NULL,
                        company_id LONG NOT NULL ,
                        supply_point int NOT NULL ,
                        PRIMARY KEY (product_id),
                        FOREIGN KEY (company_id) REFERENCES company(company_id)
);

CREATE TABLE payment(
                        payment_id LONG NOT NULL AUTO_INCREMENT,
                        payment_method varchar(255) NOT NULL,
                        user_serial_num LONG NOT NULL ,
                        used_point int ,
                        payment_money int NOT NULL ,
                        primary key (payment_id),
                        foreign key (user_serial_num) references user_info(user_serial_num)
);

CREATE TABLE order_info(
                           order_id LONG NOT NULL AUTO_INCREMENT,
                           order_product_id LONG,
                           order_payment_id LONG,
                           order_user_serial_num LONG,
                           order_date DATE,
                           PRIMARY KEY (order_id),
                           FOREIGN KEY (order_product_id) REFERENCES product(product_id),
                           FOREIGN KEY (order_payment_id) REFERENCES payment(payment_id),
                           FOREIGN KEY (order_user_serial_num) REFERENCES user_info(user_serial_num)
);
