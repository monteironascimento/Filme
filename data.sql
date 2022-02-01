CREATE OR replace VIEW produtor_max
AS 
 select  ROWNUM() as id , * from (select  f.producers as producer, min(year) as previousWin , max(year) as followingWin, (max(year)  - min(year) ) as interva 
  from filmes f  where  f.winner = true   group by f.producers order by interva desc)  
  where ROWNUM()  <= 2


CREATE OR replace VIEW produtor_min
AS 
 select  ROWNUM() as id , * from (select  f.producers as producer, min(year) as previousWin , max(year) as followingWin, (max(year)  - min(year) ) as interva 
  from filmes f  where  f.winner = true   group by f.producers order by interva asc)  
  where ROWNUM()  <= 2  