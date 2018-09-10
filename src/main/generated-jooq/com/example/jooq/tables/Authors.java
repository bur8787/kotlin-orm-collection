/*
 * This file is generated by jOOQ.
 */
package com.example.jooq.tables;


import com.example.jooq.Indexes;
import com.example.jooq.Keys;
import com.example.jooq.Public;
import com.example.jooq.tables.records.AuthorsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Authors extends TableImpl<AuthorsRecord> {

    private static final long serialVersionUID = -1019621959;

    /**
     * The reference instance of <code>PUBLIC.authors</code>
     */
    public static final Authors AUTHORS = new Authors();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorsRecord> getRecordType() {
        return AuthorsRecord.class;
    }

    /**
     * The column <code>PUBLIC.authors.id</code>.
     */
    public final TableField<AuthorsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.authors.name</code>.
     */
    public final TableField<AuthorsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * Create a <code>PUBLIC.authors</code> table reference
     */
    public Authors() {
        this(DSL.name("authors"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.authors</code> table reference
     */
    public Authors(String alias) {
        this(DSL.name(alias), AUTHORS);
    }

    /**
     * Create an aliased <code>PUBLIC.authors</code> table reference
     */
    public Authors(Name alias) {
        this(alias, AUTHORS);
    }

    private Authors(Name alias, Table<AuthorsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Authors(Name alias, Table<AuthorsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Authors(Table<O> child, ForeignKey<O, AuthorsRecord> key) {
        super(child, key, AUTHORS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CONSTRAINT_INDEX_D);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AuthorsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_AUTHORS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authors as(String alias) {
        return new Authors(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authors as(Name alias) {
        return new Authors(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Authors rename(String name) {
        return new Authors(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Authors rename(Name name) {
        return new Authors(name, null);
    }
}
