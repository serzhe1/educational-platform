create table course.public.users (
                                     id serial primary key,
                                     username varchar,
                                     email varchar,
                                     "password" varchar
);

create table course.public.courses (
                                       id serial primary key ,
                                       "name" varchar,
                                       description varchar
);

create table course.public.user_course (
                                           id serial primary key,
                                           user_id integer,
                                           course_id integer,

                                           constraint user_fk foreign key (user_id) references course.public.users(id),
                                           constraint course_fk foreign key (course_id) references course.public.courses(id)

);

create table course.public.theory_module (
                                             id serial primary key,
                                             "name" varchar,
                                             description varchar,
                                             course_id integer,

                                             constraint course_fk foreign key (course_id) references course.public.courses(id)
);

create table course.public.tasks (
                                     id serial primary key,
                                     description varchar,
                                     theory_module_id integer,

                                     constraint theory_module_fk foreign key (theory_module_id) references course.public.theory_module(id)
);

create table course.public.answers (
                                       id serial primary key,
                                       answer varchar,
                                       isCorrect bool,
                                       task_id integer,

                                       constraint task_fk foreign key (task_id) references course.public.tasks(id)
);

create table course.public.theory_part (
                                           id serial primary key ,
                                           title varchar,
                                           content varchar,
                                           theory_module_id integer,

                                           constraint theory_module_fk foreign key (theory_module_id) references course.public.theory_module
)