

public enum Endpoints {
    POSTS("posts"),
    users("users");

    private String value;

    Endpoints(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public String format(String... uris) {
        StringBuilder fullUri = new StringBuilder(this.value);
        for (String uri : uris) {
            fullUri.append(String.format("/%s", uri));
        }
        return fullUri.toString();
    }
}
