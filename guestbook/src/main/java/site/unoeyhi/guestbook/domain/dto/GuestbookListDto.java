package site.unoeyhi.guestbook.domain.dto;

import java.time.LocalDateTime;

import site.unoeyhi.guestbook.domain.entity.Guestbook;
import site.unoeyhi.guestbook.domain.entity.GuestbookEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestbookListDto {
    private Long gno;
    private String title;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public GuestbookListDto(Guestbook entity){
        gno = entity.getGno();
        title = entity.getTitle();
        writer = entity.getWriter();
        regDate = entity.getRegDate();
        modDate = entity.getModDate();

    }
     // public GuestbookEntitiy toEntitiy(){
  //   return new GuestbookEntitiy().builder().title(title).content(content).writer(writer).build();
  // }
}
