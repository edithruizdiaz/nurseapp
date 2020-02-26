package com.health.vitalsignsrange;
import java.time.LocalDateTime;

public class VitalSignsRange {

//    id serial NOT NULL,
//    id_patient int4 NULL,
//    registered_date varchar NULL,
//    bp_min varchar NULL,
//    bp_max varchar NULL,
//    hr_min varchar NULL,
//    hr_max varchar NULL,

    private int id;
    private int patientID;
    private String bpMin;
    private String bpMax;
    private String hrMin;
    private String hrMax;
    private int minAge;
    private int maxAge;
    private String gender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getBpMin() {
        return bpMin;
    }

    public void setBpMin(String bpMin) {
        this.bpMin = bpMin;
    }

    public String getBpMax() {
        return bpMax;
    }

    public void setBpMax(String bpMax) {
        this.bpMax = bpMax;
    }

    public String getHrMin() {
        return hrMin;
    }

    public void setHrMin(String hrMin) {
        this.hrMin = hrMin;
    }

    public String getHrMax() {
        return hrMax;
    }

    public void setHrMax(String hrMax) {
        this.hrMax = hrMax;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "VitalSignsRange{" +
                "id=" + id +
                ", patientID=" + patientID +
                ", bpMin='" + bpMin + '\'' +
                ", bpMax='" + bpMax + '\'' +
                ", hrMin='" + hrMin + '\'' +
                ", hrMax='" + hrMax + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", gender='" + gender + '\'' +
                '}';
    }
}
