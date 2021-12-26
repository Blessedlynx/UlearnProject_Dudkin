package Parsing;

import Data.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParserCSV {
    public static List<CountryData> ParseCountryCsv(String filePath) throws IOException {
        List<CountryData> countries = new ArrayList<CountryData>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines.subList(1, fileLines.size())) {
            String[] splittedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<String>();
            for (int i = 0; i < splittedText.length; i++) {
                if (IsColumnPart(splittedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + "," + splittedText[i]);
                } else {
                    columnList.add(splittedText[i]);
                }
            }
            CountryData countryData = new CountryData(columnList);
            countries.add(countryData);
        }
        return countries;
    }

    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        // Если в тексте одна ковычка и текст на нее заканчивается значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
}
