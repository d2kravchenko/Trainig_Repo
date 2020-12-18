package steps;

public enum Endpoints  {
    POSTS("posts"),
    USERS("users");

    private final String value;

    Endpoints(String value){
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
