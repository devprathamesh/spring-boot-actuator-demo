package dev.learnx.spring.publicenum;

public enum StatusEnum {
    ACTIVE("active"), INACTIVE("inactive");

    String status;

    public String getStatus(){
        return this.status;
    }

    private StatusEnum(String status){
        this.status= status;
    }
}
