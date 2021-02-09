USE authors;

-- 1
SELECT author_id, work_id, name
FROM work_author,
     authors
WHERE work_author.author_id = authors.id
  AND authors.name LIKE '%Tolkien%';

-- 2
SELECT author_id, work_id, name
FROM work_author,
     authors
WHERE work_author.author_id = authors.id
  AND authors.name = 'J.R.R. Tolkien';

-- 3
SELECT author_id, work_id, name
FROM work_author,
     authors
WHERE work_author.author_id = authors.id
  AND authors.id = '/authors/OL26320A';


-- 4
SELECT author_id, work_id, name
FROM work_author
         INNER JOIN authors ON work_author.author_id = authors.id
WHERE authors.name = 'J.R.R. Tolkien';


-- 5
SELECT author_id, work_id, name
FROM authors
         INNER JOIN work_author ON authors.id = work_author.author_id
WHERE authors.name = 'J.R.R. Tolkien';


-- 6
SELECT author_id, work_id, name, title
FROM authors
         INNER JOIN work_author ON authors.id = work_author.author_id
         INNER JOIN works ON work_author.work_id = works.id
WHERE authors.name = 'J.R.R. Tolkien';


-- 7
SELECT author_id, work_id, name, title, no_pages, isbn13
FROM authors
         INNER JOIN work_author ON authors.id = work_author.author_id
         INNER JOIN works ON work_author.work_id = works.id
         INNER JOIN editions ON works.id = editions.works_id
WHERE authors.name = 'J.R.R. Tolkien';