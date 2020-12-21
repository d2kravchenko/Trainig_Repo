package screenobjects.constants;

public enum Attribute {
    TEXT ("text");

    private final String value;

    Attribute(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}