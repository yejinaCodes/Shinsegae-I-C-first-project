package dto.request;

import library.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeRequestDto {
    private int id;
    private int author;
    private String title;
    private String content;
    private int view_count;
    private String created_at;
    private String updated_at;

    /**
     * 공지사항 생성
     */
    public NoticeRequestDto(int author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.created_at = LocalDateTime.getTime();
    }

    /**
     * 공지사항 수정
     */
    public NoticeRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
        this.updated_at = LocalDateTime.getTime();
    }
}

