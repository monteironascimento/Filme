DROP TABLE IF EXISTS produtor_max;

create table filmes (id IDENTITY NOT NULL PRIMARY KEY, producers varchar(255), studios varchar(255), title varchar(255), winner boolean, year integer);

CREATE OR replace VIEW produtor_max
AS 
 select  ROWNUM() as id , * from (select  f.producers as producer, min(year) as previous_Win , max(year) as following_Win, (max(year)  - min(year) ) as interva 
  from filmes f  where  f.winner = true   group by f.producers order by interva desc)  
  where ROWNUM()  <= 2 and interva > 0;


CREATE OR replace VIEW produtor_min
AS 
 select  ROWNUM() as id , * from (select  f.producers as producer, min(year) as previous_Win , max(year) as following_Win, (max(year)  - min(year) ) as interva 
  from filmes f  where  f.winner = true   group by f.producers order by interva asc)  
  where ROWNUM()  <= 2 and interva > 0;

