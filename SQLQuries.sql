create table users(user_id number(5) not null,password varchar(20),role varchar(20));

create table customer(customer_id number(5),firstName varchar(20),lastName varchar(20),mobileNumber varchar(12),address_id number(5),email varchar(20));

alter table customer add cust_pk primary key(customer_id);

alter table customer add foreign key(address_id) references address(address_id);

alter table customer add foreign key(user_id) references users(user_id);

create table address(address_id number(5) primary key,streetNo varchar(20),buildingName varchar(20),city varchar(10),state varchar(10),country varchar(20),pincode number(8));

create table orders(order_id number(5) primary key,order_date date,order_status varchar(10),customer_id number(5));

alter table orders add foreign key(customer_id) references customer(customer_id);

create table product(product_id number(5)primary key,productName varchar(20),price float(10),color varchar(10),dimension varchar(10),specification varchar(20),manufacturer varchar(20),quantity number(5),category_id number(5));

alter table product add foreign key(category_id) references category(category_id);

create table product_order(product_order_id number(5), product_id number(5) ,foreign key(product_id) references product(product_id),order_id number(5) ,foreign key(order_id) references order1(order_id));

create sequence customers start with 1;

create sequence address_id start with 1;

create sequence order_id start with 1;

create sequence product_order_id start with 1;

create sequence user_id start with 1;

create sequence customer_id start with 1;

create sequence product_id start with 1;