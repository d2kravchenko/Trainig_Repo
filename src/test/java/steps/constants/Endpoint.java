package steps.constants;

public enum Endpoint {
    POSTS("posts"),
    USERS("users");

    private final String value;

    Endpoint(String value){
        this.value = value;
    }

    public String format(String... uris) {
        StringBuilder fullUri = new StringBuilder(this.value);
        for (String uri : uris) {
            fullUri.append(String.format("/%s", uri));
        }
        return fullUri.toString();
    }
}
