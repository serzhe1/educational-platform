INSERT INTO courses (description, format, requirements, competencies, owner_id)
VALUES ('Course 1', 'Online', 'Basic knowledge of programming', 'Ability to write basic programs', 1),
       ('Course 2', 'In-person', 'Intermediate level of English', 'Communication skills', 2);

INSERT INTO modules (name, description, course_id)
VALUES ('Module 1', 'Introduction to programming', 1),
       ('Module 2', 'Programming fundamentals', 1),
       ('Module 3', 'Advanced programming concepts', 1),
       ('Module 4', 'English Grammar', 2),
       ('Module 5', 'Business communication', 2);

INSERT INTO lectures (name, content, module_id)
VALUES ('Lecture 1', 'Introduction to programming languages', 1),
       ('Lecture 2', 'Variables and data types', 2),
       ('Lecture 3', 'Control structures', 2),
       ('Lecture 4', 'Functions and arrays', 3),
       ('Lecture 5', 'Verbs and tenses', 4),
       ('Lecture 6', 'Nouns and pronouns', 4),
       ('Lecture 7', 'Email writing', 5),
       ('Lecture 8', 'Business writing structure', 5);

INSERT INTO tests (question, module_id)
VALUES ('What is a variable?', 2),
       ('What is a function?', 3),
       ('What is a pronoun?', 4),
       ('What is the recommended structure for a business email?', 5);

INSERT INTO test_answers (answer, is_right, test_id)
VALUES ('A named container for a value that can be changed', true, 1),
       ('A constant value', false, 1),
       ('A type of loop', false, 1),
       ('A block of code that performs a specific task', true, 2),
       ('A named container for a value that cannot be changed', false, 2),
       ('A type of array', false, 2),
       ('A part of speech that can replace a noun or noun phrase', true, 3),
       ('A type of verb', false, 3),
       ('A type of adjective', false, 3),
       ('Greeting, purpose, body, closing, signature', true, 4),
       ('Closing, greeting, signature, purpose, body', false, 4),
       ('Signature, greeting, body, purpose, closing', false, 4);