package site.unoeyhi.guestbook.domain.dto;

import java.time.LocalDateTime;

import site.unoeyhi.guestbook.domain.entity.Guestbook;
import site.unoeyhi.guestbook.domain.entity.GuestbookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookViewDto {
    private Long gno;
    private String title;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public GuestbookViewDto(Guestbook entity){
        this.gno = entity.getGno();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.regDate = entity.getRegDate();
        this.modDate = entity.getModDate();

    }
    // public GuestbookEntitiy toEntitiy(){
  //   return new GuestbookEntitiy().builder().title(title).content(content).writer(writer).build();
  // }
}
