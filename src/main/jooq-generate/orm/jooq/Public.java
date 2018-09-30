/*
 * This file is generated by jOOQ.
 */
package orm.jooq;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import orm.jooq.tables.Authors;
import orm.jooq.tables.Books;
import orm.jooq.tables.Projects;
import orm.jooq.tables.Tasks;
import orm.jooq.tables.UserToProject;
import orm.jooq.tables.Users;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 858003256;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>PUBLIC.authors</code>.
     */
    public final Authors AUTHORS = orm.jooq.tables.Authors.AUTHORS;

    /**
     * The table <code>PUBLIC.books</code>.
     */
    public final Books BOOKS = orm.jooq.tables.Books.BOOKS;

    /**
     * The table <code>PUBLIC.projects</code>.
     */
    public final Projects PROJECTS = orm.jooq.tables.Projects.PROJECTS;

    /**
     * The table <code>PUBLIC.tasks</code>.
     */
    public final Tasks TASKS = orm.jooq.tables.Tasks.TASKS;

    /**
     * The table <code>PUBLIC.user_to_project</code>.
     */
    public final UserToProject USER_TO_PROJECT = orm.jooq.tables.UserToProject.USER_TO_PROJECT;

    /**
     * The table <code>PUBLIC.users</code>.
     */
    public final Users USERS = orm.jooq.tables.Users.USERS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("PUBLIC", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Authors.AUTHORS,
            Books.BOOKS,
            Projects.PROJECTS,
            Tasks.TASKS,
            UserToProject.USER_TO_PROJECT,
            Users.USERS);
    }
}
