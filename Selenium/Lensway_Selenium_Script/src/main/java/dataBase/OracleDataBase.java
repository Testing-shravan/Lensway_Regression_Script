package dataBase;

import com.sun.istack.internal.NotNull;
import driverUtility.DBconfiguration;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OracleDataBase {

    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static ResultSetMetaData rsmd = null;
    static PreparedStatement preparedStatement = null;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.555");


     public static Connection oracleConnect()  {

        System.out.println("System connecting to database..." + "\n" + df.format(new Date()) + "" + "\n-----------------------------------------------------------------------");

        try {

           Class.forName(DBconfiguration.getDriver());
            connection = DriverManager.getConnection(DBconfiguration.getconnectionString(), DBconfiguration.getusername(), DBconfiguration.getpassword());
            System.out.println("Connected to Oracle Database");

        } catch (ClassNotFoundException |IOException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }


    public static Statement getStatement()

    {
        try {
            statement = connection.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;

    }


    public static void showDataBase(String sql_Query)
    {

        try
        {
            System.out.println("******************************************************Showing Records***********************************************************");
            resultSet = getStatement().executeQuery(sql_Query);
            rsmd=resultSet.getMetaData();
            int columnNumber=rsmd.getColumnCount();
            while(resultSet.next())
            {
                for(int i=1; i<=columnNumber; i++)
                {
                    System.out.println(resultSet.getString(i)  +"\t");
                }
                    System.out.println(); //Printing next line
            }

        }

        catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void deleteDatabase(String sql_Query)
    {

        try {
            preparedStatement = connection.prepareStatement(sql_Query);
            int rows=preparedStatement.executeUpdate(sql_Query);
            System.err.println(rows+ "Rows successfully deleted from database");


        }

        catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static ResultSet getDataBase(String sql_Query)
    {

        try
        {
            resultSet=getStatement().executeQuery(sql_Query);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
            return resultSet;
    }

    public static void closeDB() throws SQLException
    {

        if(connection!=null && !connection.isClosed())
        {
           connection.commit();
           connection.close();
           System.out.println("/n***************************************************************************************"+""+"\n"+df.format(new Date()));
           System.out.println("Disconnected from oracle database");

        }

    }

}





