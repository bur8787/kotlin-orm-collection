/*
 * This file is generated by jOOQ.
 */
package orm.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import orm.jooq.tables.UserToProject;


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
public class UserToProjectRecord extends UpdatableRecordImpl<UserToProjectRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 425458541;

    /**
     * Setter for <code>PUBLIC.user_to_project.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.user_to_project.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>PUBLIC.user_to_project.project_id</code>.
     */
    public void setProjectId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.user_to_project.project_id</code>.
     */
    public Integer getProjectId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return UserToProject.USER_TO_PROJECT.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UserToProject.USER_TO_PROJECT.PROJECT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getProjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getProjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserToProjectRecord value1(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserToProjectRecord value2(Integer value) {
        setProjectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserToProjectRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserToProjectRecord
     */
    public UserToProjectRecord() {
        super(UserToProject.USER_TO_PROJECT);
    }

    /**
     * Create a detached, initialised UserToProjectRecord
     */
    public UserToProjectRecord(Integer userId, Integer projectId) {
        super(UserToProject.USER_TO_PROJECT);

        set(0, userId);
        set(1, projectId);
    }
}
