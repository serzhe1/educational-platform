drop table if exists user_courses;
drop table if exists student_answers;
drop table if exists test_answers;
drop table if exists tests;
drop table if exists lectures;
drop table if exists modules;
drop table if exists courses;

create table courses
(
    id           serial primary key,
    name         varchar,
    description  varchar,
    format       varchar,
    requirements varchar,
    competencies varchar,
    owner_uuid varchar
);

create table user_courses
(
    id serial primary key ,
    user_uuid   varchar,
    course_id bigint,
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
    student_uuid bigint,
    answer_id  bigint,
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