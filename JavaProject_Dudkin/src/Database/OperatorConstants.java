package Database;

import Data.CountryData;

public class OperatorConstants {
    public static final String CREATE_TABLE_GENERAL = String.format(
            "CREATE TABLE General (\n" +
                    "NAME VARCHAR(20) PRIMARY KEY,\n" +
                    "REGION VARCHAR(20) NOT NULL,\n" +
                    "RANK INT NOT NULL,\n" +
                    "SCORE DECIMAL(3,4) NOT NULL);"
    );
    public static final String CREATE_TABLE_WHISKER = String.format(
            "CREATE TABLE Whisker (\n" +
            "NAME VARCHAR(20) PRIMARY KEY,\n" +
            "HIGH_VALUE DECIMAL(3,4) NOT NULL,\n" +
            "LOW_VALUE DECIMAL(3,4) NOT NULL);"
    );
    public static final String CREATE_TABLE_COUNTRY_PARAMETERS = String.format(
            "CREATE TABLE Country_Parameters (\n" +
            "NAME VARCHAR(20) PRIMARY KEY,\n" +
            "Economy_GDP_per_capita DECIMAL(3,4) NOT NULL,\n" +
            "FAMILY DECIMAL(3,4) NOT NULL,\n" +
            "HEALTH_LIFE_EXPECTANCY DECIMAL(3,4) NOT NULL,\n" +
            "FREEDOM DECIMAL(3,4) NOT NULL,\n" +
            "GENEROSITY DECIMAL(3,4) NOT NULL,\n" +
            "TRUST_GOVERNMENT_CORRUPTION DECIMAL(3,4) NOT NULL,\n" +
            "DYSTOPIA_RESIDUAL DECIMAL(3,4) NOT NULL);"
    );

    public static String formQuery_insert_General(CountryData dataUnit) {
        String query = String.format(
                "INSERT INTO General VALUES\n" +
                "('%s', '%s', %s, %s);",
                dataUnit.getName(),
                dataUnit.getRegion(),
                dataUnit.getHappiness().getRank(),
                dataUnit.getHappiness().getScore()
        );
        return query;
    }

    public static String formQuery_insert_Whisker(CountryData dataUnit) {
        String query = String.format(
                "INSERT INTO Whisker VALUES\n" +
                "('%s', %s, %s);",
                dataUnit.getName(),
                dataUnit.getWhisker().getHighValue(),
                dataUnit.getWhisker().getLowValue()
        );
        return query;
    }

    public static String formQuery_insert_Country_Parameters(CountryData dataUnit) {
        String query = String.format(
                "INSERT INTO Country_Parameters VALUES\n" +
                "('%s', %s, %s, %s, %s, %s, %s, %s);",
                dataUnit.getName(),
                dataUnit.getData().getEconomyGDPperCapita(),
                dataUnit.getData().getFamily(),
                dataUnit.getData().getHealthLifeExpectancy(),
                dataUnit.getData().getFreedom(),
                dataUnit.getData().getGenerosity(),
                dataUnit.getData().getTrustGovernmentCorruption(),
                dataUnit.getData().getDystopiaResidual()
        );
        return query;
    }
}
