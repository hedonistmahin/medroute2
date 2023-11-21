package HospitalModel;

public class Hospital {

    private int logoResourceId;
    private String name;
    private String information;

    public Hospital(int logoResourceId, String name, String information) {
        this.logoResourceId = logoResourceId;
        this.name = name;
        this.information = information;
    }

    public int getLogoResourceId() {
        return logoResourceId;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }
}
