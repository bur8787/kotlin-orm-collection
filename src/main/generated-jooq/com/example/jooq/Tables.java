/*
 * This file is generated by jOOQ.
 */
package com.example.jooq;


import com.example.jooq.tables.Authors;
import com.example.jooq.tables.Books;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in PUBLIC
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
     * The table <code>PUBLIC.authors</code>.
     */
    public static final Authors AUTHORS = com.example.jooq.tables.Authors.AUTHORS;

    /**
     * The table <code>PUBLIC.books</code>.
     */
    public static final Books BOOKS = com.example.jooq.tables.Books.BOOKS;
}
