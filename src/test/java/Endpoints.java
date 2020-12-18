public enum Endpoints {
    posts("posts"),
    users("users");

    private String value;

    Endpoints(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
