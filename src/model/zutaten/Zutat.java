package model.zutaten;

public abstract class Zutat {
    private String name;
    private double kalorien;
    private double vitaminC;
    private double zucker;

    public Zutat(String pname,double kalorien, double vitaminC, double zucker) {
        this.name = pname;
        this.kalorien = kalorien;
        this.vitaminC = vitaminC;
        this.zucker = zucker;
    }

    public double getKalorien(){return kalorien;}
    public double getVitaminC() {return vitaminC;}
    public double getZucker() {return zucker;}
    public String getName() {
        return name;
    }
}
