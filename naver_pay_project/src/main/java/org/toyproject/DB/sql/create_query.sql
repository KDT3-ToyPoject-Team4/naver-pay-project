show tables;

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
                        primary key (payment_id),
                        foreign key (user_serial_num) references user_info(user_serial_num)
);

CREATE TABLE order_info(
                           order_id LONG NOT NULL AUTO_INCREMENT,
                           order_product_id LONG,
                           order_payment_id LONG,
                           order_date DATE,
                           used_point int,
                           order_money int,
                           user_serial_num LONG,
                           PRIMARY KEY (order_id),
                           FOREIGN KEY (order_product_id) REFERENCES product(product_id),
                           FOREIGN KEY (order_payment_id) REFERENCES payment(payment_id),
                           FOREIGN KEY (user_serial_num) REFERENCES user_info(user_serial_num)
);

show tables;