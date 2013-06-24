package com.vartala.soulofw0lf.rpgapi.sqlapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class SQLHandler extends SQLOps {
    private String host, database, username, password;
    private Connection connection;
    private static final Logger SQLLogger = Logger.getLogger("SQLHandler");
    /**
     * Used for proper logging
     */
    public static void logSevere(String severe)
    {
        SQLLogger.severe(severe);
    }
    /**
     * Reopens the SQL connection if it is closed. This is invoked upon every
     * query.
     */
    public void refreshConnection() {
        if (connection == null) {
            initialise();
        }
    }

    /**
     * Manually close the connection.
     */
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialise a new connection using RPGApi settings
     *
     * @return
     */
    public boolean initialise() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + RpgAPI.dBURL, RpgAPI.dBUserName, RpgAPI.dBPassword);
            return true;
        } catch (ClassNotFoundException ex) {
            logSevere("Could not find MySQL driver class!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            logSevere("SQL Exception!");
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Any query which does not return a ResultSet object. Such as : INSERT,
     * UPDATE, CREATE TABLE...
     *
     * @param query
     */
    public void standardQuery(String query) throws SQLException {
        this.refreshConnection();
        super.standardQuery(query, this.connection);
    }

    /**
     * Check whether a field/entry exists in a database.
     *
     * @param query
     * @return Whether or not a result has been found in the query.
     * @throws SQLException
     */
    public boolean existanceQuery(String query) throws SQLException {
        this.refreshConnection();
        return super.sqlQuery(query, this.connection).next();
    }

    /**
     * Any query which returns a ResultSet object. Such as : SELECT Remember to
     * close the ResultSet object after you are done with it to free up
     * resources immediately. ----- ResultSet set =
     * sqlQuery("SELECT * FROM sometable;"); set.doSomething(); set.close();
     * -----
     *
     * @param query
     * @return ResultSet
     */
    public ResultSet sqlQuery(String query) throws SQLException {
        this.refreshConnection();
        return super.sqlQuery(query, this.connection);
    }

    /**
     * Check whether the table name exists.
     *
     * @param table
     * @return
     */
    public boolean doesTableExist(String table) throws SQLException {
        this.refreshConnection();
        return super.checkTable(table, this.connection);
    }

}
