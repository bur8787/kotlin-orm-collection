/*
 * This file is generated by jOOQ.
 */
package com.example.jooq;


import com.example.jooq.tables.Authors;
import com.example.jooq.tables.Books;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CONSTRAINT_INDEX_D = Indexes0.CONSTRAINT_INDEX_D;
    public static final Index CONSTRAINT_INDEX_5 = Indexes0.CONSTRAINT_INDEX_5;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index CONSTRAINT_INDEX_D = Internal.createIndex("constraint_index_d", Authors.AUTHORS, new OrderField[] { Authors.AUTHORS.ID }, true);
        public static Index CONSTRAINT_INDEX_5 = Internal.createIndex("constraint_index_5", Books.BOOKS, new OrderField[] { Books.BOOKS.AUTHOR_ID }, false);
    }
}