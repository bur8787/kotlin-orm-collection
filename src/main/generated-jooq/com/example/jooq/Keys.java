/*
 * This file is generated by jOOQ.
 */
package com.example.jooq;


import com.example.jooq.tables.Authors;
import com.example.jooq.tables.Books;
import com.example.jooq.tables.records.AuthorsRecord;
import com.example.jooq.tables.records.BooksRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AuthorsRecord, Integer> IDENTITY_AUTHORS = Identities0.IDENTITY_AUTHORS;
    public static final Identity<BooksRecord, Integer> IDENTITY_BOOKS = Identities0.IDENTITY_BOOKS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AuthorsRecord, Integer> IDENTITY_AUTHORS = Internal.createIdentity(Authors.AUTHORS, Authors.AUTHORS.ID);
        public static Identity<BooksRecord, Integer> IDENTITY_BOOKS = Internal.createIdentity(Books.BOOKS, Books.BOOKS.ID);
    }
}