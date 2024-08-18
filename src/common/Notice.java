package common;

public enum Notice {
    ID("공지사항 번호: "),
    AUTHOR("작성자: "),
    TITLE("제목: "),
    CONTENT("내용: "),
    VIEW_COUNT("조회수: "),
    CREATED_AT("게시글 등록일: "),
    UPDATED_AT("게시글 수정일: "),
    BORDER_LINE("+----+------------+-------------+-------------+-----------------------+"),
    NOTICE_LIST("| id |    작성자    |     제목     |     조회수    |          등록일         |");

    private final String description;

    Notice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
