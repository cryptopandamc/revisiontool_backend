;              
CREATE USER IF NOT EXISTS "SA" SALT '73e82438e18ece66' HASH '09f80de4975dbe0b9dfee8c7369e98bd860a5ee9d02cf714d787d656e6aa5093' ADMIN;          
CREATE SEQUENCE "PUBLIC"."TAG_SEQ" START WITH 32;              
CREATE SEQUENCE "PUBLIC"."ANSWER_SEQ" START WITH 17;           
CREATE SEQUENCE "PUBLIC"."QUESTION_SEQ" START WITH 5;          
CREATE MEMORY TABLE "PUBLIC"."ANSWER"(
    "ANSWER_ID" BIGINT NOT NULL,
    "ANSWER_TEXT" VARCHAR(255)
);      
ALTER TABLE "PUBLIC"."ANSWER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7" PRIMARY KEY("ANSWER_ID"); 
-- 16 +/- SELECT COUNT(*) FROM PUBLIC.ANSWER;  
INSERT INTO "PUBLIC"."ANSWER" VALUES
(1, 'ArrayListsdf'),
(2, 'Set'),
(3, 'Map'),
(4, 'Tree'),
(5, '""'),
(6, 'Set'),
(7, 'null'),
(8, 'String'),
(9, 'It can\t be changed'),
(10, 'The method can only be used statically'),
(11, 'nothing changes'),
(12, 'The method can\t be overriden'),
(13, 'Interfaces, abstraction, encapsulation, polymorphism'),
(14, 'Inheritance, abstraction, encapsulation, polymorphism'),
(15, 'Inheritance, abstraction, SOLID, polymorphism'),
(16, 'Interface, abstraction, encapsulation, dependencies'); 
CREATE MEMORY TABLE "PUBLIC"."QUESTION"(
    "QUESTION_ID" BIGINT NOT NULL,
    "APPROVED" BOOLEAN,
    "CORRECT_ANSWER" VARCHAR(255),
    "QUESTION_TEXT" VARCHAR(255)
);     
ALTER TABLE "PUBLIC"."QUESTION" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("QUESTION_ID");             
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.QUESTION; 
INSERT INTO "PUBLIC"."QUESTION" VALUES
(1, FALSE, 'C', 'update this question'),
(2, FALSE, 'C', 'What is the default value of a String?'),
(3, TRUE, 'D', 'If the final modifier is applied to a method what happens?'),
(4, TRUE, 'B', 'What are the four pillars of OOD?');  
CREATE MEMORY TABLE "PUBLIC"."QUESTION_ANSWERS"(
    "QUESTION_QUESTION_ID" BIGINT NOT NULL,
    "ANSWERS_ANSWER_ID" BIGINT NOT NULL
);        
-- 16 +/- SELECT COUNT(*) FROM PUBLIC.QUESTION_ANSWERS;        
INSERT INTO "PUBLIC"."QUESTION_ANSWERS" VALUES
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(4, 13),
(4, 14),
(4, 15),
(4, 16),
(1, 1),
(1, 2),
(1, 3),
(1, 4);          
CREATE MEMORY TABLE "PUBLIC"."QUESTION_TAGS"(
    "QUESTION_QUESTION_ID" BIGINT NOT NULL,
    "TAGS_TAG_ID" BIGINT NOT NULL
); 
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.QUESTION_TAGS;            
INSERT INTO "PUBLIC"."QUESTION_TAGS" VALUES
(2, 3),
(2, 8),
(3, 11),
(3, 8),
(2, 8),
(2, 2),
(1, 30),
(1, 31); 
CREATE MEMORY TABLE "PUBLIC"."TAG"(
    "TAG_ID" BIGINT NOT NULL,
    "NAME" VARCHAR(255)
);   
ALTER TABLE "PUBLIC"."TAG" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("TAG_ID");       
-- 31 +/- SELECT COUNT(*) FROM PUBLIC.TAG;     
INSERT INTO "PUBLIC"."TAG" VALUES
(1, 'collections'),
(2, 'four pillars'),
(3, 'data types'),
(4, 'generics'),
(5, 'TDD'),
(6, 'constructors'),
(7, 'SOLID'),
(8, 'week one'),
(9, 'week two'),
(10, 'week three'),
(11, 'access modifiers'),
(12, 'loops'),
(13, 'methods'),
(14, 'classes'),
(15, 'dependencies'),
(16, 'static keyword'),
(17, 'comparisons'),
(18, 'exceptions'),
(19, 'File IO'),
(20, 'generics'),
(21, 'test driven development'),
(22, 'mockito'),
(23, 'JSON'),
(24, 'lambda'),
(25, 'optionals'),
(26, 'streams'),
(27, 'threading'),
(28, 'JPA'),
(29, 'spring boot'),
(30, 'collections'),
(31, 'generics');       
ALTER TABLE "PUBLIC"."QUESTION_ANSWERS" ADD CONSTRAINT "PUBLIC"."UK_PQTU314FUA658GIJGV1O0FKB3" UNIQUE("ANSWERS_ANSWER_ID");    
ALTER TABLE "PUBLIC"."QUESTION_TAGS" ADD CONSTRAINT "PUBLIC"."FKQFVO538XR4B7ET07VT8TK8M8E" FOREIGN KEY("QUESTION_QUESTION_ID") REFERENCES "PUBLIC"."QUESTION"("QUESTION_ID") NOCHECK;          
ALTER TABLE "PUBLIC"."QUESTION_ANSWERS" ADD CONSTRAINT "PUBLIC"."FKT7ENOHSHUB7LPBJX5B6MQC8EV" FOREIGN KEY("ANSWERS_ANSWER_ID") REFERENCES "PUBLIC"."ANSWER"("ANSWER_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."QUESTION_TAGS" ADD CONSTRAINT "PUBLIC"."FKTBE4EIG0V6TFM2IPY5BKTEVHW" FOREIGN KEY("TAGS_TAG_ID") REFERENCES "PUBLIC"."TAG"("TAG_ID") NOCHECK;             
ALTER TABLE "PUBLIC"."QUESTION_ANSWERS" ADD CONSTRAINT "PUBLIC"."FKOIRFWV5QFAP3S57YWAO12S2EH" FOREIGN KEY("QUESTION_QUESTION_ID") REFERENCES "PUBLIC"."QUESTION"("QUESTION_ID") NOCHECK;       
