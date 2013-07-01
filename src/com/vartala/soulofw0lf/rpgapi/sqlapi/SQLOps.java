package com.vartala.soulofw0lf.rpgapi.sqlapi;

import java.sql.*;

/**
 * Created by: tennyson.holloway
 * Date: 6/24/13
 * Time: 1:25 PM
 * <p/>
 * This file is part of the Rpg Suite Created by Soulofw0lf and Linksy.
 * <p/>
 * The Rpg Suite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * The Rpg Suite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with The Rpg Suite Plugin you have downloaded.  If not, see <http://www.gnu.org/licenses/>.
 */
public class SQLOps {
    protected synchronized int standardQuery(String query, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        int rowsUpdated = statement.executeUpdate(query);
        statement.close();
        return rowsUpdated;
    }

    protected synchronized ResultSet sqlQuery(String query, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }

    protected synchronized boolean checkTable(String table, Connection connection) throws SQLException {
        DatabaseMetaData dbm;
        dbm = connection.getMetaData();
        ResultSet tables = dbm.getTables(null, null, table, null);
        return tables.next();
    }

}
