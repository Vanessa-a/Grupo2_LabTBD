CREATE DATABASE db_emergencias;

\connect db_emergencias;

CREATE TABLE institution (
    id_institution integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name text
);

CREATE TABLE skill (
    id_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name text
);

CREATE TABLE voluntary (
    id_voluntary integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name text,
    disponibilidad boolean
);

CREATE TABLE status_task (
    id_status_task integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    status boolean
);

CREATE TABLE ranking (
    id_ranking integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    numRanking integer,
    id_voluntary integer REFERENCES voluntary
);

CREATE TABLE emergency (
    id_emergency integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name text,
    estado boolean,
    id_institution integer REFERENCES institution
);

CREATE TABLE task (
    id_task integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name text,
    id_status_task integer REFERENCES status_task,
    id_emergency integer REFERENCES emergency
);

CREATE TABLE eme_skill (
    id_eme_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_emergency integer REFERENCES emergency,
    id_skill integer REFERENCES skill
);

CREATE TABLE task_skill (
    id_task_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_task integer REFERENCES task,
    id_eme_skill integer REFERENCES eme_skill
);

CREATE TABLE vol_skill (
    id_vol_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_voluntary integer REFERENCES voluntary,
    id_skill integer REFERENCES skill
);

CREATE FUNCTION get_active_task1()
RETURNS TABLE(
	f_id integer,
        f_name text,
        f_total bigint
    
)
language plpgsql
as
$$
begin
return query
    select E.id_emergency AS f_id, E.name AS f_name, count(*) AS f_total
    from emergency as E, task as T, status_task as S
    where E.id_emergency = T.id_emergency and T.id_status_task = S.id_status_task and S.status = TRUE
    group by E.name, E.id_emergency
    UNION
    select E.id_emergency, E.name, 0
    from emergency as E, task as T, status_task as S
    where E.id_emergency = T.id_emergency and T.id_status_task = S.id_status_task and E.id_emergency not in (select E.id_emergency
        from emergency as E, task as T, status_task as S
        where E.id_emergency = T.id_emergency and T.id_status_task = S.id_status_task and S.status = TRUE

    )UNION
    select id_emergency, name, 0
    from emergency
    where id_emergency not in (select E.id_emergency
        from emergency as E, task as T
        where E.id_emergency = T.id_emergency
    );
end;
$$;;
