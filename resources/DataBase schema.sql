--------------------------------------------------------
--  File created - Monday-June-16-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ADDRESS_SQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "ADDRESS_SQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 201 CACHE 100 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COMPANY_SQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "COMPANY_SQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 201 CACHE 100 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ADDRESS
--------------------------------------------------------

  CREATE TABLE "ADDRESS" 
   (	"ADD_ID" NUMBER, 
	"STREET" VARCHAR2(255 BYTE), 
	"HOUSENO" VARCHAR2(255 BYTE), 
	"POSTALCODE" VARCHAR2(255 BYTE), 
	"CITY" VARCHAR2(255 BYTE), 
	"COUNTRY" VARCHAR2(255 BYTE), 
	"ACTIVE" NUMBER, 
	"COM_ID" NUMBER, 
	"MODIFYDATE" TIMESTAMP (6)
   );
--------------------------------------------------------
--  DDL for Table COMPANY
--------------------------------------------------------

  CREATE TABLE "COMPANY" 
   (	"COM_ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE)
   ) ;


--------------------------------------------------------
--  Constraints for Table ADDRESS
--------------------------------------------------------

  ALTER TABLE "ADDRESS" ADD CONSTRAINT "ADDRESS_SQUENCE" PRIMARY KEY ("ADD_ID");
--------------------------------------------------------
--  Constraints for Table COMPANY
--------------------------------------------------------

  ALTER TABLE "COMPANY" ADD CONSTRAINT "COMPANY_SQUENCE" PRIMARY KEY ("COM_ID");
 
  ALTER TABLE "COMPANY" MODIFY ("COM_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ADDRESS
--------------------------------------------------------

  ALTER TABLE "ADDRESS" ADD CONSTRAINT "ADDRESS_COMPANY_FK1" FOREIGN KEY ("COM_ID")
	  REFERENCES "COMPANY" ("COM_ID") ENABLE;
