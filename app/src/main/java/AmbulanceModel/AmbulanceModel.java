package AmbulanceModel;

public class AmbulanceModel {
    String ambulance_name;
    String ambulance_contact;

    public AmbulanceModel(String ambulance_name, String ambulance_contact) {
        this.ambulance_name = ambulance_name;
        this.ambulance_contact = ambulance_contact;
    }

    public String getAmbulance_name() {
        return ambulance_name;
    }

    public void setAmbulance_name(String ambulance_name) {
        this.ambulance_name = ambulance_name;
    }

    public String getAmbulance_contact() {
        return ambulance_contact;
    }

    public void setAmbulance_contact(String ambulance_contact) {
        this.ambulance_contact = ambulance_contact;
    }
}
