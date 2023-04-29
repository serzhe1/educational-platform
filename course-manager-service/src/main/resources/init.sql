drop table if exists courses;
create table courses
(
    id           serial primary key,
    description  varchar,
    format       varchar,
    requirements varchar,
    competencies varchar,
    owner_id     bigint,
    constraint user_fk
        foreign key (owner_id)
            references users (id)
);

drop table if exists modules;
create table modules
(
    id          serial primary key,
    name        varchar,
    description varchar,
    course_id   bigint,
    constraint course_fk
        foreign key (course_id)
            references courses (id)
);

drop table if exists lectures;
create table lectures
(
    id        serial primary key,
    content   varchar,
    module_id bigint,
    constraint module_fk
        foreign key (module_id)
            references modules (id)
);

drop table if exists tests;
create table tests
(
    id        serial primary key,
    question  varchar,
    module_id bigint,
    constraint module_fk
        foreign key (module_id)
            references modules (id)
);

drop table if exists test_answers;
create table test_answers
(
    id       serial primary key,
    answer   varchar,
    is_right boolean,
    test_id  bigint,
    constraint test_id
        foreign key (test_id)
            references tests (id)
);

drop table if exists users;
create table users
(
    id        serial primary key,
    username  varchar,
    full_name varchar
);

drop table if exists roles;
create table roles
(
    id   serial primary key,
    role varchar
);

drop table if exists user_roles;
create table user_roles
(
    user_id bigint,
    role_id bigint,
    primary key (user_id, role_id),
    constraint user_fk
        foreign key (user_id)
            references users (id),
    constraint role_fk
        foreign key (role_id)
            references roles (id)
);

drop table if exists user_courses;
create table user_courses
(
    user_id   bigint,
    course_id bigint,
    primary key (user_id, course_id),
    constraint user_fk
        foreign key (user_id)
            references users (id),
    constraint course_fk
        foreign key (course_id)
            references courses (id)
)