/*
 * This file is generated by jOOQ.
 */
package jooq;


import javax.annotation.Generated;

import jooq.tables.Authors;
import jooq.tables.Books;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.authors</code>.
     */
    public static final Authors AUTHORS = jooq.tables.Authors.AUTHORS;

    /**
     * The table <code>public.books</code>.
     */
    public static final Books BOOKS = jooq.tables.Books.BOOKS;
}