package InnerClasses;

import enums.EyeColor;
import enums.HairColor;
import enums.Country;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Поле не может быть null
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null

    public Person(String name, String passportID, EyeColor eyeColor, HairColor hairColor, Country nationality) {
        this.name = name;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }
    public Person(){}

    public boolean setName(String name) {
        if(name == null || name.isEmpty()){
            return false;
        }
        this.name = name;
        return true;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public boolean setPassportID(String passportID) {
        if(passportID == null){
            return false;
        }
        this.passportID = passportID;
        return true;
    }
}
