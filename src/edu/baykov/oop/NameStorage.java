package edu.baykov.oop;

public class NameStorage extends Storage<String> {

   private final ENameParameter parameter;


    public NameStorage(String obj, ENameParameter parameter) {
        super(obj);
        this.parameter = parameter;
    }

    public String getName() {
        return super.getObj("");
    }

    public ENameParameter getNameParameter() {
        return parameter;
    }
}
