package testScripts;

import dataBase.OracleDataBase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TC_007_Lensway_OracleDataBase {

    @Test(enabled=true)

    public void testDataBase() throws SQLException, IOException, ClassNotFoundException {

       OracleDataBase.oracleConnect();

       OracleDataBase.showDataBase("select * from oe_order_headers_all ");
       OracleDataBase.closeDB();



    }



    }





