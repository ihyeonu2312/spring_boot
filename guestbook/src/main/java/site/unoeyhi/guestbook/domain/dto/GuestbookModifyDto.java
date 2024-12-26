package site.unoeyhi.guestbook.domain.dto;

import site.unoeyhi.guestbook.domain.entity.Guestbook;
import site.unoeyhi.guestbook.domain.entity.GuestbookEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GuestbookModifyDto {
    private Long gno;
    private String title;
    private String content;
    private String writer;

    public Guestbook toEntity(){
        return new Guestbook().builder().gno(gno).title(title).content(content).writer(writer).build();
    }
}
