package Data;

public class GeneralData {
    private float economyGDPperCapita;
    private float family;
    private float healthLifeExpectancy;
    private float freedom;
    private float generosity;
    private float trustGovernmentCorruption;
    private float dystopiaResidual;

    public GeneralData(float economyGDPperCapita, float family, float healthLifeExpectancy,
                       float freedom, float generosity, float trustGovernmentCorruption, float dystopiaResidual) {
        this.economyGDPperCapita = economyGDPperCapita;
        this.family = family;
        this.healthLifeExpectancy = healthLifeExpectancy;
        this.freedom = freedom;
        this.generosity = generosity;
        this.trustGovernmentCorruption = trustGovernmentCorruption;
        this.dystopiaResidual = dystopiaResidual;
    }

    public float getEconomyGDPperCapita() {
        return economyGDPperCapita;
    }

    public float getFamily() {
        return family;
    }

    public float getHealthLifeExpectancy() {
        return healthLifeExpectancy;
    }

    public float getFreedom() {
        return freedom;
    }

    public float getGenerosity() {
        return generosity;
    }

    public float getTrustGovernmentCorruption() {
        return trustGovernmentCorruption;
    }

    public float getDystopiaResidual() {
        return dystopiaResidual;
    }

    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s", economyGDPperCapita, family, healthLifeExpectancy,
                freedom, generosity, trustGovernmentCorruption, dystopiaResidual);
    }
}
