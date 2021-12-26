package Data;

import java.util.ArrayList;

public class CountryData {
    private String name;
    private String region;
    private Happiness happiness;
    private Whisker whisker;
    private GeneralData data;

    public CountryData(String name, String region, Happiness happiness, Whisker whisker, GeneralData generalData) {
        this.name = name;
        this.region = region;
        this.happiness = happiness;
        this.whisker = whisker;
        this.data = generalData;
    }

    public CountryData(ArrayList<String> unitCSV) {
        this(
                unitCSV.get(0),
                unitCSV.get(1),
                new Happiness(Integer.parseInt(unitCSV.get(2)), Float.parseFloat(unitCSV.get(3))),
                new Whisker(Float.parseFloat(unitCSV.get(4)), Float.parseFloat(unitCSV.get(5))),
                new GeneralData(
                        Float.parseFloat(unitCSV.get(6)),
                        Float.parseFloat(unitCSV.get(7)),
                        Float.parseFloat(unitCSV.get(8)),
                        Float.parseFloat(unitCSV.get(9)),
                        Float.parseFloat(unitCSV.get(10)),
                        Float.parseFloat(unitCSV.get(11)),
                        Float.parseFloat(unitCSV.get(12))
                )
        );
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public Happiness getHappiness() {
        return happiness;
    }

    public Whisker getWhisker() {
        return whisker;
    }

    public GeneralData getData() {
        return data;
    }

    public String toString() {
        return String.format("%s, %s, %s, %s, %s", name, region, happiness.toString(), whisker.toString(), data.toString());
    }
}
