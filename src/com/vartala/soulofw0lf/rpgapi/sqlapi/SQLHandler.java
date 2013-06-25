package com.vartala.soulofw0lf.rpgapi.sqlapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.util.RPGLogging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SQLHandler extends SQLOps {
    private String host, database, username, password;
    private Connection connection;
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
     * @return if connection was successfully established
     */
    public boolean initialise() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + RpgAPI.dBURL, RpgAPI.dBUserName, RpgAPI.dBPassword);
            return true;
        } catch (ClassNotFoundException ex) {
            RPGLogging.logSevere("Could not find MySQL driver class!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            RPGLogging.logSevere("SQL Exception!");
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Any query which does not return a ResultSet object. Such as : INSERT,
     * UPDATE, CREATE TABLE...
     *
     * @param query SQL statement to be executed
     */
    public void standardQuery(String query) throws SQLException {
        this.refreshConnection();
        super.standardQuery(query, this.connection);
    }

    /**
     * Check whether a field/entry exists in a database.
     *
     * @param query SQL statement to be executed
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
     * @param query SQL statement to be executed
     * @return ResultSet the resultset of the executed query
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
