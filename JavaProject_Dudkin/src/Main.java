import Data.*;
import Database.Operator;
import Database.OperatorConstants;
import Parsing.ParserCSV;

// Для парсинга
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] arguments) throws IOException {
        // Парсинг
        String filePath = "data.csv";
        List<CountryData> countries = ParserCSV.ParseCountryCsv(filePath);

        // Создание оператора для оперирования базой данных
        Operator databaseOperator = new Operator();
        // Подключение к базе данных
        databaseOperator.open();
        // Создание таблиц
        databaseOperator.executeQuery(OperatorConstants.CREATE_TABLE_GENERAL);
        databaseOperator.executeQuery(OperatorConstants.CREATE_TABLE_WHISKER);
        databaseOperator.executeQuery(OperatorConstants.CREATE_TABLE_COUNTRY_PARAMETERS);
        // Вставка данных
        databaseOperator.insertValues_General(countries);
        databaseOperator.insertValues_Whisker(countries);
        databaseOperator.insertValues_Country_Parameters(countries);
        // Вывод полученных данных в консоль
        databaseOperator.selectValues_General();
        databaseOperator.selectValues_Whisker();
        databaseOperator.selectValues_Country_Parameters();
        // Разрыв соединения с базой данных
        databaseOperator.close();
    }
}
