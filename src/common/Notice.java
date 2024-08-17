package common;

public enum Notice {
    TITLE("제목: "),
    CONTENT("내용: ");

    private final String text;

    Notice(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
