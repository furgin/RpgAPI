package com.vartala.soulofw0lf.rpgapi.sqlapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SQLHandler {
    public static String user = "", password = "", url = "";
    public static Properties properties;

    /* initialize the static sqlhandler and properties */
    public SQLHandler(String username, String passwordd, String urll) {
        user = username;
        password = passwordd;
        url = "jdbc:mysql://" + url;
        properties = new Properties();
        properties.put("user", RpgAPI.dBUserName);
        properties.put("password", RpgAPI.dBPassword);
        properties.put("characterEncoding", RpgAPI.dBEncoding);
        properties.put("useUnicode", RpgAPI.uniCode);
    }

    /* url should be as follows tennysonholloway.com not http://www.tennysonholloway.com */
    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection c = DriverManager.getConnection(url, properties);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            RpgAPI.logger.severe("Unable to open the sql connection...make sure your settings are correct");
        }
        return null;
    }

}
