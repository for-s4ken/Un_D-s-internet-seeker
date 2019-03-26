package model;

public class Variable {
    String key;
    String value;
    public Variable(String key, String value){
        this.key = key; this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
