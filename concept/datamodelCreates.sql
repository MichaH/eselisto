
CREATE TABLE user (
    user_id        VARCHAR(36)  NOT NULL PRIMARY KEY,
    user_name      VARCHAR(80) NOT NULL,

    creation_time  TIMESTAMP    NOT NULL,
    last_change    TIMESTAMP    NOT NULL,
    surrogate_key  VARCHAR(255) NOT NULL
);

CREATE TABLE vacation (
    vacation_id    VARCHAR(36)  NOT NULL PRIMARY KEY,
    vacation_name  VARCHAR(80) NOT NULL,
    description    VARCHAR(255),
    start_date     DATE,
    user_id        VARCHAR(36)  NOT NULL,

    FOREIGN KEY (user_id) REFERENCES user(user_id),

    creation_time  TIMESTAMP    NOT NULL,
    last_change    TIMESTAMP    NOT NULL,
    surrogate_key  VARCHAR(255) NOT NULL
);

CREATE TABLE category (
    category_id    VARCHAR(36)  NOT NULL PRIMARY KEY,
    category_name  VARCHAR(80) NOT NULL,
    user_id        VARCHAR(36)  NOT NULL,

    FOREIGN KEY (user_id) REFERENCES user(user_id),

    creation_time  TIMESTAMP    NOT NULL,
    last_change    TIMESTAMP    NOT NULL,
    surrogate_key  VARCHAR(255) NOT NULL
);

CREATE TABLE item (
    item_id        VARCHAR(36)  NOT NULL PRIMARY KEY,
    item_name      VARCHAR(120) NOT NULL,
    picture        LONGBLOB,
    color          VARCHAR(50),
    description    TEXT,
    weight         DECIMAL(10),
    amount_unit    VARCHAR(50),
    consumeable    BOOLEAN      NOT NULL,
    tags           VARCHAR(255),
    branding       VARCHAR(255),
    container      BOOLEAN      NOT NULL,
    sort_no        INTEGER,
    priority       VARCHAR(50),
    price          DECIMAL(10,2),
    active         BOOLEAN      NOT NULL,
    category_id    VARCHAR(36)  NOT NULL,
    user_id        VARCHAR(36)  NOT NULL,

    FOREIGN KEY (category_id) REFERENCES category(category_id),
    FOREIGN KEY (user_id)     REFERENCES user(user_id),

    creation_time  TIMESTAMP    NOT NULL,
    last_change    TIMESTAMP    NOT NULL,
    surrogate_key  VARCHAR(255) NOT NULL
);

CREATE TABLE packlist (
    packlist_id       VARCHAR(36)  NOT NULL PRIMARY KEY,
    vacation_id       VARCHAR(36)  NOT NULL,
    item_id           VARCHAR(36)  NOT NULL,
    amount            DECIMAL(10,2) NOT NULL,
    note              VARCHAR(255),
    sort_no           INTEGER,
    todo_note         VARCHAR(255),
    checked           BOOLEAN      NOT NULL,
    extra_end_check   BOOLEAN      NOT NULL,

    FOREIGN KEY (vacation_id) REFERENCES vacation(vacation_id),
    FOREIGN KEY (item_id)     REFERENCES item(item_id),

    creation_time      TIMESTAMP    NOT NULL,
    last_change        TIMESTAMP    NOT NULL,
    surrogate_key      VARCHAR(255) NOT NULL
);

CREATE TABLE nesting (
    nesting_id         VARCHAR(36)  NOT NULL PRIMARY KEY,
    container_item_id  VARCHAR(36)  NOT NULL,
    content_item_id    VARCHAR(36)  NOT NULL,
    amount             DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (container_item_id) REFERENCES item(item_id),
    FOREIGN KEY (content_item_id)   REFERENCES item(item_id),

    creation_time      TIMESTAMP    NOT NULL,
    last_change        TIMESTAMP    NOT NULL,
    surrogate_key      VARCHAR(255) NOT NULL
);
