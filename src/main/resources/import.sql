insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'collections');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'four pillars');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'data types');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'generics');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'TDD');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'constructors');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'SOLID');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'week one');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'week two');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'week three');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'access modifiers');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'loops');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'methods');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'classes');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'dependencies');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'static keyword');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'comparisons');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'exceptions');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'File IO');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'generics');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'test driven development');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'mockito');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'JSON');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'lambda');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'optionals');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'streams');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'threading');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'JPA');
insert into Tag(TAG_ID, NAME) values (TAG_SEQ.nextval, 'spring boot');

insert into QUESTION (QUESTION_ID, CORRECT_ANSWER, QUESTION_TEXT, APPROVED) VALUES (QUESTION_SEQ.nextval, 'B', 'Which of the following collections does not allow duplicates?', false);

insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'ArrayList');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Set');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Map');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Tree');

insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (1,1);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (1,2);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (1,3);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (1,4);

insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (1,1);
insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (1,3);


insert into QUESTION (QUESTION_ID, CORRECT_ANSWER, QUESTION_TEXT, APPROVED) VALUES (QUESTION_SEQ.nextval, 'C', 'What is the default value of a String?', false);

insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, '""');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Set');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'null');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'String');

insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (2,5);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (2,6);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (2,7);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (2,8);

insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (2,3);
insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (2,8);

insert into QUESTION (QUESTION_ID, CORRECT_ANSWER, QUESTION_TEXT, APPROVED) VALUES (QUESTION_SEQ.nextval, 'D', 'If the final modifier is applied to a method what happens?', true);

insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'It can\t be changed');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'The method can only be used statically');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'nothing changes');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'The method can\t be overriden');


insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (3,9);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (3,10);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (3,11);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (3,12);

insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (3,11);
insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (3,8);

insert into QUESTION (QUESTION_ID, CORRECT_ANSWER, QUESTION_TEXT, APPROVED) VALUES (QUESTION_SEQ.nextval, 'B', 'What are the four pillars of OOD?', true);

insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Interfaces, abstraction, encapsulation, polymorphism');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Inheritance, abstraction, encapsulation, polymorphism');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Inheritance, abstraction, SOLID, polymorphism');
insert into ANSWER (ANSWER_ID, ANSWER_TEXT) values (ANSWER_SEQ.nextval, 'Interface, abstraction, encapsulation, dependencies');


insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (4,13);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (4,14);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (4,15);
insert into QUESTION_ANSWERS(question_question_id, answers_answer_id) values (4,16);

insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (4,8);
insert into QUESTION_TAGS (QUESTION_QUESTION_ID, TAGS_TAG_ID) VALUES (4,2);
