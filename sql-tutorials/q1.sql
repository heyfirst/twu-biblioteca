/* 1. Who checked out the book 'The Hobbit’? */
select m.name as memberWhoCheckedOutHobbit
from book b
inner join checkout_item ci on ci.book_id = b.id
inner join member m on m.id = ci.member_id
where title = "The Hobbit";

/* 2.How many people have not checked out anything? */
select count(id) as numberOfUserHasNoCheckout
from member
where id not in (
	select member.id
	from checkout_item ci
	join member on ci.member_id = member.id
)

/* What books and movies aren't checked out? */
select title as UnCheckedOutBook
from book
where book.id not in (select book_id from checkout_item ci where ci.book_id is not null)
union
select title as UnCheckedOutBook
from movie
where movie.id not in (select movie_id from checkout_item ci where ci.movie_id is not null)


/* Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database. */
insert into book (id, title) values (11, "The Pragmatic Programmer");
insert into member (id, name) values (11, "Kanisorn Sutham");
insert into checkout_item (member_id, book_id, movie_id) values (11, 11, 0);

/* 
Who has checked out more that 1 item? 
Tip: Research the GROUP BY syntax.
*/
select m.name as CheckOutOwner, count(m.name) as countOfBooks
from member m
join checkout_item ci on m.id = ci.member_id
where ci.book_id is not null
group by m.name

