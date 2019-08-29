-- begin PRACTICE_ALGORITHM
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
    TYPE_ integer,
    INFO varchar(50),
    TIME_ double precision,
    MEMORY double precision,
    --
    primary key (ID)
)^
-- end PRACTICE_ALGORITHM
