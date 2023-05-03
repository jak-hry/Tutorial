package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateBestSellers() throws SQLException {

        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = 3";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement2.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 3";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }

        rs.close();
        statement.close();
        statement2.close();

        assertEquals(0, howMany);

    }

    @Test
    public void testUpdateVipLevels() throws SQLException {

        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);

        // Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        rs.close();
        statement.close();
        statement2.close();

        assertEquals(0, howMany);
    }
}
