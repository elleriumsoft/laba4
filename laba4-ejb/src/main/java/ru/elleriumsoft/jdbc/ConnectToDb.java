package ru.elleriumsoft.jdbc;

import org.apache.log4j.Logger;
import ru.elleriumsoft.printstructure.PrintStructureBean;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dmitriy on 18.03.2017.
 */
public class ConnectToDb
{
    public final static String PATH_APP = "./";
    public final static String JNDI_ROOT = "java:global/laba4-ear-1.0/laba4-ejb-1.0/";

    private static final Logger logger = Logger.getLogger(PrintStructureBean.class.getName());

    public Connection getConnection()
    {
        try
        {
            //DataSource dataSource = (DataSource) ic.lookup("java:jboss/laba3");
            try
            {
                File file = new File("");
                logger.info("путь=" + file.getAbsolutePath());
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }

            return DriverManager.getConnection("jdbc:sqlite:lababase.s3db");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(Connection connection)
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

