package ICUmodel;

public class ICUmodel {
    int hospital_img_icu;
    String hospital_name_icu;

    public ICUmodel(int hospital_img_icu, String hospital_name_icu) {
        this.hospital_img_icu = hospital_img_icu;
        this.hospital_name_icu = hospital_name_icu;
    }

    public int getHospital_img_icu() {
        return hospital_img_icu;
    }

    public void setHospital_img_icu(int hospital_img_icu) {
        this.hospital_img_icu = hospital_img_icu;
    }

    public String getHospital_name_icu() {
        return hospital_name_icu;
    }

    public void setHospital_name_icu(String hospital_name_icu) {
        this.hospital_name_icu = hospital_name_icu;
    }
}
