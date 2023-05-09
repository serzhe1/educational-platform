drop table if exists user_roles;
drop table if exists user_courses;
drop table if exists student_answers;
drop table if exists roles;
drop table if exists test_answers;
drop table if exists tests;
drop table if exists courses;
drop table if exists users;
drop table if exists modules;
drop table if exists lectures;

create table users
(
    id        serial primary key,
    username  varchar,
    full_name varchar
);

create table roles
(
    id   serial primary key,
    role varchar
);

create table user_roles
(
    user_id bigint,
    role_id bigint,
    primary key (user_id, role_id),
    constraint user_fk
        foreign key (user_id)
            references users (id) on delete cascade,
    constraint role_fk
        foreign key (role_id)
            references roles (id) on delete cascade
);

create table courses
(
    id           serial primary key,
    name         varchar,
    description  varchar,
    format       varchar,
    requirements varchar,
    competencies varchar,
    owner_id     bigint,
    constraint user_fk
        foreign key (owner_id)
            references users (id) on delete cascade
);

create table user_courses
(
    user_id   bigint,
    course_id bigint,
    primary key (user_id, course_id),
    constraint user_fk
        foreign key (user_id)
            references users (id) on delete cascade,
    constraint course_fk
        foreign key (course_id)
            references courses (id) on delete cascade
);

create table modules
(
    id          serial primary key,
    name        varchar,
    description varchar,
    course_id   bigint,
    constraint course_fk
        foreign key (course_id)
            references courses (id) on delete cascade
);

create table tests
(
    id        serial primary key,
    question  varchar,
    module_id bigint,
    constraint module_fk
        foreign key (module_id)
            references modules (id) on delete cascade
);


create table test_answers
(
    id       serial primary key,
    answer   varchar,
    is_right boolean,
    test_id  bigint,
    constraint test_id
        foreign key (test_id)
            references tests (id) on delete cascade
);

create table student_answers
(
    student_id bigint,
    answer_id  bigint,
    primary key (student_id, answer_id),
    constraint student_fk
        foreign key (student_id)
            references users (id) on delete cascade,
    constraint answer_fk
        foreign key (answer_id)
            references test_answers (id) on delete cascade
);
create table lectures
(
    id        serial primary key,
    name      varchar,
    content   varchar,
    module_id bigint,
    constraint module_fk
        foreign key (module_id)
            references modules (id) on delete cascade
);