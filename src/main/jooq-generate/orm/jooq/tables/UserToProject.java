/*
 * This file is generated by jOOQ.
 */
package orm.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import orm.jooq.Indexes;
import orm.jooq.Keys;
import orm.jooq.Public;
import orm.jooq.tables.records.UserToProjectRecord;


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
public class UserToProject extends TableImpl<UserToProjectRecord> {

    private static final long serialVersionUID = 2025209813;

    /**
     * The reference instance of <code>PUBLIC.user_to_project</code>
     */
    public static final UserToProject USER_TO_PROJECT = new UserToProject();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserToProjectRecord> getRecordType() {
        return UserToProjectRecord.class;
    }

    /**
     * The column <code>PUBLIC.user_to_project.user_id</code>.
     */
    public final TableField<UserToProjectRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.user_to_project.project_id</code>.
     */
    public final TableField<UserToProjectRecord, Integer> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>PUBLIC.user_to_project</code> table reference
     */
    public UserToProject() {
        this(DSL.name("user_to_project"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.user_to_project</code> table reference
     */
    public UserToProject(String alias) {
        this(DSL.name(alias), USER_TO_PROJECT);
    }

    /**
     * Create an aliased <code>PUBLIC.user_to_project</code> table reference
     */
    public UserToProject(Name alias) {
        this(alias, USER_TO_PROJECT);
    }

    private UserToProject(Name alias, Table<UserToProjectRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserToProject(Name alias, Table<UserToProjectRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserToProject(Table<O> child, ForeignKey<O, UserToProjectRecord> key) {
        super(child, key, USER_TO_PROJECT);
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
        return Arrays.<Index>asList(Indexes.CONSTRAINT_INDEX_C, Indexes.CONSTRAINT_INDEX_C4, Indexes.PRIMARY_KEY_C4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserToProjectRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_C4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserToProjectRecord>> getKeys() {
        return Arrays.<UniqueKey<UserToProjectRecord>>asList(Keys.CONSTRAINT_C4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UserToProjectRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserToProjectRecord, ?>>asList(Keys.CONSTRAINT_C4A, Keys.CONSTRAINT_C4A8);
    }

    public Users users() {
        return new Users(this, Keys.CONSTRAINT_C4A);
    }

    public Projects projects() {
        return new Projects(this, Keys.CONSTRAINT_C4A8);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserToProject as(String alias) {
        return new UserToProject(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserToProject as(Name alias) {
        return new UserToProject(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserToProject rename(String name) {
        return new UserToProject(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserToProject rename(Name name) {
        return new UserToProject(name, null);
    }
}