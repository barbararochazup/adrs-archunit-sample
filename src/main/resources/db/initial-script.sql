CREATE TABLE contact (
        "id"           	UUID        NOT NULL,
        "name"          VARCHAR(200) NOT NULL,
        "nickname"      VARCHAR(200),
        "phone"         VARCHAR(12) NOT NULL,
        "email"         VARCHAR(200),
        "birthday"      VARCHAR(25),
        "type"      	VARCHAR(25),
        "active"		BOOLEAN,

        CONSTRAINT contact_pk
            PRIMARY KEY ("id")
)