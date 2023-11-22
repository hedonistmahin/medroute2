package BedModel;

public class BedModel {
    int hospital_img_bed;
    String hospital_name_bed;

    public BedModel(int hospital_img_bed, String hospital_name_bed) {
        this.hospital_img_bed = hospital_img_bed;
        this.hospital_name_bed = hospital_name_bed;

    }

    public int getHospital_img_bed() {
        return hospital_img_bed;
    }

    public void setHospital_img_bed(int hospital_img_bed) {
        this.hospital_img_bed = hospital_img_bed;
    }

    public String getHospital_name_bed() {
        return hospital_name_bed;
    }

    public void setHospital_name_bed(String hospital_name_bed) {
        this.hospital_name_bed = hospital_name_bed;
    }
}
