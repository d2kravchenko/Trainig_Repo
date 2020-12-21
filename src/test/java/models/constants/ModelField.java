package models.constants;

public enum ModelField {
    POST_USER_ID("userId"),
    POST_ID("id"),
    POST_TITLE("title"),
    POST_BODY("body");

    private final String value;

    ModelField(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }


}