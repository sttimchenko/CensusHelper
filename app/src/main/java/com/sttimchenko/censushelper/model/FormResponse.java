package com.sttimchenko.censushelper.model;

public class FormResponse {
    private String gender;
    private int age;
    private long birthday;
    private String birthplace;
    private String familyStatus;
    private String ethnicity;
    private String language;
    private String nationality;
    private String education;
    private String incomes;
    private String workStatus;
    private String livingConditions;

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public long getBirthday() {
        return birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getLanguage() {
        return language;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEducation() {
        return education;
    }

    public String getIncomes() {
        return incomes;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public String getLivingConditions() {
        return livingConditions;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setIncomes(String incomes) {
        this.incomes = incomes;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public void setLivingConditions(String livingConditions) {
        this.livingConditions = livingConditions;
    }
}
