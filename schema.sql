create table hibernate_sequence
(
    next_val bigint null
);

create table user
(
    user_id   bigint       not null
        primary key,
    created   datetime     null,
    email     varchar(255) null,
    enabled   bit          not null,
    password  varchar(255) null,
    user_name varchar(255) null
);

create table subreddit
(
    id           bigint       not null
        primary key,
    created_date datetime     null,
    description  varchar(255) null,
    name         varchar(255) null,
    user_user_id bigint       null,
    constraint FKqye4s0ll7xwj74d7irovyhbvg
        foreign key (user_user_id) references user (user_id)
);

create table post
(
    post_id      bigint       not null
        primary key,
    created_date datetime     null,
    description  longtext     null,
    post_name    varchar(255) null,
    url          varchar(255) null,
    vote_count   int          null,
    subreddit    bigint       null,
    user_id      bigint       null,
    constraint FK3hlixjckxntthc3o02w1h0ku7
        foreign key (subreddit) references subreddit (id),
    constraint FK72mt33dhhs48hf9gcqrq4fxte
        foreign key (user_id) references user (user_id)
);

create table comment
(
    id      bigint       not null
        primary key,
    text    varchar(255) null,
    post_id bigint       null,
    user_id bigint       null,
    constraint FK8kcum44fvpupyw6f5baccx25c
        foreign key (user_id) references user (user_id),
    constraint FKs1slvnkuemjsq2kj4h3vhx7i1
        foreign key (post_id) references post (post_id)
);

create table subreddit_posts
(
    subreddit_id  bigint not null,
    posts_post_id bigint not null,
    constraint UK_ih17w4fa2em7w3u1tt8gqv2wh
        unique (posts_post_id),
    constraint FK1plpyiqs72shw84g90q0fes5r
        foreign key (subreddit_id) references subreddit (id),
    constraint FKl27wc8sin3rt45ayge7fanx10
        foreign key (posts_post_id) references post (post_id)
);

create table token
(
    id           bigint       not null
        primary key,
    employee     datetime     null,
    token        varchar(255) null,
    user_user_id bigint       null,
    constraint FK79keudebybjlldk2o4i0nwqev
        foreign key (user_user_id) references user (user_id)
);

create table vote
(
    vote_id   bigint not null
        primary key,
    vote_type int    null,
    post_id   bigint null,
    user_id   bigint null,
    constraint FKcsaksoe2iepaj8birrmithwve
        foreign key (user_id) references user (user_id),
    constraint FKl3c067ewaw5xktl5cjvniv3e9
        foreign key (post_id) references post (post_id)
);

