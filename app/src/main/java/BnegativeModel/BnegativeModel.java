package BnegativeModel;

public class BnegativeModel {
    String bloodBank_name, bloodBank_location;


    public BnegativeModel(String bloodBank_name, String bloodBank_location) {
        this.bloodBank_name = bloodBank_name;
        this.bloodBank_location = bloodBank_location;
    }

    public String getBloodBank_name() {
        return bloodBank_name;
    }

    public void setBloodBank_name(String bloodBank_name) {
        this.bloodBank_name = bloodBank_name;
    }

    public String getBloodBank_location() {
        return bloodBank_location;
    }

    public void setBloodBank_location(String bloodBank_location) {
        this.bloodBank_location = bloodBank_location;
    }
}
