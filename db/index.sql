-- How to find a row in a table without an index
/*
  1. Pull a page into memory and search for the row
  2. Pull another page into memory and search for the row
  3. Repeat until row is found

    How indexes speed up the queries?

    Indexes are data structures that are stored on disk and act as a map and tell us
    where and on which page the items exist.

    When a new query comes, we first pull the index and then pull that particular page into 
    the memory to find the row which significantly reduces scanning throug all the pages.
*/