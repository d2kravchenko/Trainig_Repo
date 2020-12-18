package screenobjects;

public enum Attribute {
    TEXT ("text"),
    SELECTED ("selected");
    private String value;

    Attribute(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
