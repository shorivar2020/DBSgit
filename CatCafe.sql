CREATE TABLE "public.CatCafe" (
 "venue" VARCHAR(55) NOT NULL,
 "workplace" VARCHAR(55) NOT NULL,
 "tables" integer(55) NOT NULL,
 "menu" VARCHAR(55) NOT NULL,
 "workers" integer(55) NOT NULL,
 "money" integer(55) NOT NULL,
 "cats" VARCHAR(55) NOT NULL,
 "customers" VARCHAR(55) NOT NULL,
 CONSTRAINT "CatCafe_pk" PRIMARY KEY ("venue")
) WITH (
 OIDS=FALSE
);
CREATE TABLE "public.Worker" (
 "id" serial(1) NOT NULL,
 "salary" integer(1) NOT NULL,
 "info_about_person" VARCHAR(55) NOT NULL,
 "workplace" VARCHAR(5) NOT NULL,
 "orders" DATETIME(55) NOT NULL,
 "care_about(cat)" VARCHAR(55) NOT NULL,
 CONSTRAINT "Worker_pk" PRIMARY KEY ("id")
) WITH (
 OIDS=FALSE
);
CREATE TABLE "public.Customer" (
 "number" serial(1) NOT NULL,
 "order" serial(1) NOT NULL,
 "play_with(cat)" serial(55) NOT NULL,
 "table" serial(1) NOT NULL,
 CONSTRAINT "Customer_pk" PRIMARY KEY ("number")
) WITH (
 OIDS=FALSE
);
CREATE TABLE "public.Cat" (
 "name" serial(1) NOT NULL,
 "tray" serial(1) NOT NULL,
 "bowl" serial(1) NOT NULL,
 "who_care(worker)" serial(55) NOT NULL,
 CONSTRAINT "Cat_pk" PRIMARY KEY ("name")
) WITH (
 OIDS=FALSE
);
CREATE TABLE "public.Order" (
 "time" DATETIME(1) NOT NULL,
 "cost" integer(1) NOT NULL,
 "table" integer(1) NOT NULL,
 "type_of_food" VARCHAR(55) NOT NULL,
 CONSTRAINT "Order_pk" PRIMARY KEY ("time")
 ) WITH (
 OIDS=FALSE
);
CREATE TABLE "public.Table" (
 "table_num" serial(1) NOT NULL,
 "free" integer(55) NOT NULL,
 "occupation" integer(55) NOT NULL,
 CONSTRAINT "Table_pk" PRIMARY KEY ("table_num")
) WITH (
 OIDS=FALSE
);
CREATE TABLE "public.Cafes" (
 "location_of_cafe" integer(55) NOT NULL
) WITH (
 OIDS=FALSE
);
ALTER TABLE "CatCafe" ADD CONSTRAINT "CatCafe_fk0" FOREIGN KEY ("venue")
REFERENCES "Cafes"("location_of_cafe");
ALTER TABLE "CatCafe" ADD CONSTRAINT "CatCafe_fk1" FOREIGN KEY ("customers")
REFERENCES "Customer"("number");
ALTER TABLE "Worker" ADD CONSTRAINT "Worker_fk0" FOREIGN KEY ("id")
REFERENCES "CatCafe"("workers");
ALTER TABLE "Worker" ADD CONSTRAINT "Worker_fk1" FOREIGN KEY ("salary")
REFERENCES "CatCafe"("money");
ALTER TABLE "Worker" ADD CONSTRAINT "Worker_fk2" FOREIGN KEY ("workplace")
REFERENCES "CatCafe"("workplace");
ALTER TABLE "Worker" ADD CONSTRAINT "Worker_fk3" FOREIGN KEY ("orders")
REFERENCES "Order"("time");
ALTER TABLE "Worker" ADD CONSTRAINT "Worker_fk4" FOREIGN KEY
("care_about(cat)") REFERENCES "Cat"("name");
ALTER TABLE "Customer" ADD CONSTRAINT "Customer_fk0" FOREIGN KEY ("order")
REFERENCES "Order"("time");
ALTER TABLE "Customer" ADD CONSTRAINT "Customer_fk1" FOREIGN KEY
("play_with(cat)") REFERENCES "Cat"("name");
ALTER TABLE "Customer" ADD CONSTRAINT "Customer_fk2" FOREIGN KEY ("table")
REFERENCES "Table"("table_num");
ALTER TABLE "Cat" ADD CONSTRAINT "Cat_fk0" FOREIGN KEY ("name") REFERENCES
"CatCafe"("cats");
ALTER TABLE "Cat" ADD CONSTRAINT "Cat_fk1" FOREIGN KEY ("who_care(worker)")
REFERENCES "Worker"("id");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk0" FOREIGN KEY ("cost")
REFERENCES "CatCafe"("money");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk1" FOREIGN KEY ("table")
REFERENCES "CatCafe"("tables");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk2" FOREIGN KEY ("type_of_food")
REFERENCES "CatCafe"("menu");
ALTER TABLE "Table" ADD CONSTRAINT "Table_fk0" FOREIGN KEY ("table_num")
REFERENCES "CatCafe"("tables");