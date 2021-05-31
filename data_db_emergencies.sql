\connect db_emergencias;

INSERT INTO "institution" (name) VALUES ('OugrŽe'),('Bunbury'),('Birmingham'),('Chicago'),('Shikarpur'),('Roccamena'),('Wadgassen'),('Guirsch'),('Ramenskoye'),('Jhelum');

INSERT INTO "skill" (name) VALUES ('organizacion'),('informatico'),('manual'),('comunicador');

INSERT INTO "voluntary" (name,disponibilidad) VALUES ('Thomás','true'),('Mia','false'),('Juanita','false'),('Antonieta','false'),('Salomé','true'),('Naiara','false'),('Jacobo','false'),('Jhon','true'),('Eduar','false'),('Mia','true');
INSERT INTO "voluntary" (name,disponibilidad) VALUES ('Lilian','true'),('Agustina','false'),('Giselle','false'),('Jordan','true'),('Faloon','false'),('Aleli','false'),('Jeremías','true'),('Yostin','true'),('Branko','false'),('Agustin','true');
INSERT INTO "voluntary" (name,disponibilidad) VALUES ('Yenifer','true'),('Macarena','true'),('Yohans','true'),('Cristian','false'),('Dailyn','true'),('Byron','true'),('Deivid','true'),('Cristóbal','true'),('Milan','false'),('Valentino','false');

INSERT INTO "status_task" (status) VALUES ('true'), ('false');

INSERT INTO "ranking" (numRanking,id_voluntary) VALUES (82,1),(83,2),(52,3),(35,4),(81,5),(55,6),(45,7),(25,8),(42,9),(49,10);
INSERT INTO "ranking" (numRanking,id_voluntary) VALUES (67,11),(99,12),(35,13),(59,14),(80,15),(8,16),(46,17),(79,18),(23,19),(55,20);
INSERT INTO "ranking" (numRanking,id_voluntary) VALUES (21,21),(11,22),(88,23),(66,24),(37,25),(96,26),(83,27),(97,28),(38,29),(51,30);

INSERT INTO "emergency" (name,estado,id_institution) VALUES ('fuego','true',5),('tierra','false',10),('hambruna','true',2),('hambruna','false',4),('sequia','true',4),('accidente','true',5),('hambruna','false',7),('accidente','false',7),('accidente','false',5),('apagon','false',3);
INSERT INTO "emergency" (name,estado,id_institution) VALUES ('accidente','true',7),('fuego','true',9),('sequia','false',10),('asalto','true',6),('sequia','false',5),('apagon','true',6),('accidente','true',6),('asalto','false',5),('apagon','false',9),('tierra','false',1);

INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('magnis dis parturient',1,3),('enim. Curabitur massa.',2,3),('rutrum urna, nec',2,19),('turpis. Nulla aliquet.',2,16),('placerat. Cras dictum',2,3),('arcu eu odio',2,2),('a neque. Nullam',1,19),('Sed pharetra, felis',2,4),('dignissim tempor arcu.',2,11),('augue. Sed molestie.',1,14);
INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('Nunc mauris sapien,',2,3),('dolor dapibus gravida.',2,13),('nunc nulla vulputate',2,8),('vulputate mauris sagittis',1,5),('tincidunt aliquam arcu.',1,10),('Aliquam nec enim.',1,9),('Nullam suscipit, est',1,19),('Curae; Phasellus ornare.',1,13),('Cum sociis natoque',2,11),('urna. Nullam lobortis',2,12);
INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('Sed nunc est,',1,3),('enim consequat purus.',2,14),('placerat, augue. Sed',2,17),('libero lacus, varius',2,9),('Praesent interdum ligula',2,20),('et pede. Nunc',2,8),('ad litora torquent',2,3),('diam vel arcu.',2,13),('Pellentesque ut ipsum',2,8),('mauris, rhoncus id,',1,19);
INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('Donec non justo.',1,10),('fringilla mi lacinia',1,18),('nec metus facilisis',2,10),('Suspendisse commodo tincidunt',2,17),('morbi tristique senectus',2,6),('Fusce mi lorem,',1,9),('Duis cursus, diam',2,4),('molestie. Sed id',1,9),('Duis risus odio,',1,2),('Integer aliquam adipiscing',2,5);

INSERT INTO "eme_skill" (id_emergency,id_skill) VALUES (7,2),(6,2),(2,3),(5,2),(14,4),(6,3),(18,4),(18,3),(11,1),(3,1);
INSERT INTO "eme_skill" (id_emergency,id_skill) VALUES (1,4),(5,1),(13,1),(17,2),(12,3),(8,1),(19,1),(4,3),(3,2),(15,1);

INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (11,12),(14,10),(30,19),(6,14),(18,12),(6,12),(24,6),(15,15),(25,6),(6,4);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (11,3),(21,4),(12,14),(23,9),(30,16),(4,9),(1,5),(27,3),(22,19),(10,6);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (40,14),(10,12),(29,12),(37,11),(13,5),(22,8),(4,4),(27,18),(24,8),(16,7);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (35,13),(14,20),(37,13),(23,4),(33,8),(22,1),(1,18),(20,14),(14,13),(28,2);

INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (1,3),(2,4),(3,1),(4,2),(5,1),(6,4),(7,1),(8,4),(9,2),(10,2);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (11,4),(12,3),(13,2),(14,3),(15,4),(16,1),(17,2),(18,3),(19,3),(20,2);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (21,1),(22,3),(23,3),(24,2),(25,4),(26,3),(27,3),(28,2),(29,1),(30,3);

--Create User

CREATE USER dbusr_grupo2 WITH PASSWORD 'grupo2';

-- Grant connect to my data base

GRANT CONNECT ON DATABASE db_emergencias TO dbusr_grupo2;

-- Grant all table for SELECT, INSERT, UPDATE, DELETE

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO dbusr_grupo2;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO dbusr_grupo2;;
