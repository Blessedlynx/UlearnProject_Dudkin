package Database;

import java.sql.*;
import java.util.List;

import Data.CountryData;

public class Operator {
    Connection connection;

    public void open() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:sqlite\\countries.db"
            );
            System.out.println("Connected");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropTable(String tableName) {
        String query = "DROP TABLE " + tableName + ";";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertValues_General(List<CountryData> countries) {
        for (CountryData dataUnit : countries) {
            executeQuery(OperatorConstants.formQuery_insert_General(dataUnit));
        }
    }

    public void insertValues_Whisker(List<CountryData> countries) {
        for (CountryData dataUnit : countries) {
            executeQuery(OperatorConstants.formQuery_insert_Whisker(dataUnit));
        }
    }

    public void insertValues_Country_Parameters(List<CountryData> countries) {
        for (CountryData dataUnit : countries) {
            executeQuery(OperatorConstants.formQuery_insert_Country_Parameters(dataUnit));
        }
    }

    public void selectValues_General() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT NAME, REGION, RANK, SCORE FROM General;";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("NAME | REGION | RANK | SCORE");
            while (rs.next()) {
                String name = rs.getString("NAME");
                String region = rs.getString("REGION");
                int rank = rs.getInt("RANK");
                float score = rs.getFloat("SCORE");
                System.out.println(name + " | " + region + " | " + rank + " | " + score);
            }
            System.out.println();
            rs.close();
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectValues_Whisker() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT NAME, HIGH_VALUE, LOW_VALUE FROM Whisker;";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("NAME | HIGH_VALUE | LOW_VALUE");
            while (rs.next()) {
                String name = rs.getString("NAME");
                float highValue = rs.getFloat("HIGH_VALUE");
                float lowValue = rs.getFloat("LOW_VALUE");
                System.out.println(name + " | " + highValue + " | " + lowValue);
            }
            System.out.println();
            rs.close();
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectValues_Country_Parameters() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT NAME, Economy_GDP_per_capita, FAMILY, HEALTH_LIFE_EXPECTANCY," +
                    " FREEDOM, GENEROSITY, TRUST_GOVERNMENT_CORRUPTION, DYSTOPIA_RESIDUAL FROM Country_Parameters;";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("NAME | Economy_GDP_per_capita | FAMILY | HEALTH_LIFE_EXPECTANCY" +
                    " | FREEDOM | GENEROSITY | TRUST_GOVERNMENT_CORRUPTION | DYSTOPIA_RESIDUAL");
            while (rs.next()) {
                String name = rs.getString("NAME");
                float economyGDPperCapita = rs.getFloat("Economy_GDP_per_capita");
                float family = rs.getFloat("FAMILY");
                float healthLifeExpectancy = rs.getFloat("HEALTH_LIFE_EXPECTANCY");
                float freedom = rs.getFloat("FREEDOM");
                float generosity = rs.getFloat("GENEROSITY");
                float trustGovernmentCorruption = rs.getFloat("TRUST_GOVERNMENT_CORRUPTION");
                float dystopiaResidual = rs.getFloat("DYSTOPIA_RESIDUAL");
                System.out.println(name + " | " + economyGDPperCapita + " | " + family + " | " + healthLifeExpectancy + " | " +
                        freedom + " | " + generosity + " | " + trustGovernmentCorruption + " | " + dystopiaResidual);
            }
            System.out.println();
            rs.close();
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
