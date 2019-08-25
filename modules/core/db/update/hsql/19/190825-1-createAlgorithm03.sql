create table PRACTICE_ALGORITHM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    INFO varchar(50),
    TIME_ bigint,
    MEMORY double precision,
    --
    primary key (ID)
);