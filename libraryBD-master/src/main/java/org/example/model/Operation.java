package org.example.model;

public enum Operation {
    TAKE("Взял"),
    RETURN("Вернул");

    private String operation;
    Operation(String operation){this.operation = operation;}

    public String getOperation(){return operation;}

    public static Operation fromOperation(String operation){
        for (Operation operation1:Operation.values()){
            if (operation1.operation.equals(operation)){
                return operation1;
            }
        }
        return null;
    }
}
