DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;


CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    email    VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE user_roles
(
    user_id INTEGER REFERENCES users (id),
    role_id INTEGER REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles (role)
VALUES ('ADMIN'),
       ('TEACHER'),
       ('OWNER'),
       ('STUDENT');
-- -----------------------------------------------------------------------------------------------
create table courses
(
    id          serial primary key,
    "name"      varchar,
    description varchar
);

create table user_course
(
    id        serial primary key,
    user_id   integer,
    course_id integer,

    constraint user_fk foreign key (user_id) references users (id),
    constraint course_fk foreign key (course_id) references courses (id)

);

create table theory_module
(
    id          serial primary key,
    "name"      varchar,
    description varchar,
    course_id   integer,

    constraint course_fk foreign key (course_id) references courses (id)
);

create table tasks
(
    id               serial primary key,
    description      varchar,
    theory_module_id integer,

    constraint theory_module_fk foreign key (theory_module_id) references theory_module (id)
);

create table answers
(
    id        serial primary key,
    answer    varchar,
    isCorrect bool,
    task_id   integer,

    constraint task_fk foreign key (task_id) references tasks (id)
);

create table theory_part
(
    id               serial primary key,
    title            varchar,
    "content"          varchar,
    theory_module_id integer,

    constraint theory_module_fk foreign key (theory_module_id) references theory_module
)