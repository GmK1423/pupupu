create table status
(
    id   serial,
    value varchar(10),
    primary key (id)
);

create table direction
(
    id   serial,
    name varchar(10) not null,
    primary key (id)
);

create table "group"
(
    id   serial,
    direction_id int not null,
    name varchar,
    primary key (id),
    foreign key (direction_id) references direction(id)
);

create table "user"
(
    id       serial,
    tg_id    int4,
    vk_id    int4,
    bot_state int4,
    status_id int,
    nickname varchar,
    first_name varchar(15),
    second_name varchar(20),
    email    varchar(319) not null unique,
    password varchar(80)  not null,
    group_id int,
    primary key (id),
    foreign key (group_id) references "group" (id),
    foreign key (status_id) references "status" (id)
);

create table test
(
    id   serial,
    topic varchar not null,
    status varchar(10) not null,
    primary key (id)
);

create table task
(
    id   serial,
    value varchar,
    primary key (id)
);

create table response
(
    id   serial,
    task_id int not null ,
    value varchar not null,
    status bool not null,
    primary key (id),
    foreign key (task_id) references task(id)
);

create table group_test
(
    group_id  int not null,
    test_id int not null,
    primary key (group_id, test_id),
    foreign key (group_id) references "group" (id),
    foreign key (test_id) references test (id)
);

create table test_task
(
    test_id  int not null,
    task_id int not null,
    primary key (test_id, task_id),
    foreign key (test_id) references test (id),
    foreign key (task_id) references task (id)
);

INSERT INTO status values ('1','SuperAdmin');
INSERT INTO status values ('2','Admin');
INSERT INTO status values ('3','Teacher');
INSERT INTO status values ('4','Student');