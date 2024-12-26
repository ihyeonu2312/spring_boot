package site.unoeyhi.guestbook.service;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import site.unoeyhi.guestbook.domain.dto.GuestbookDto;
import site.unoeyhi.guestbook.domain.dto.GuestbookListDto;
import site.unoeyhi.guestbook.domain.dto.GuestbookModifyDto;
import site.unoeyhi.guestbook.domain.dto.GuestbookViewDto;
import site.unoeyhi.guestbook.domain.dto.GuestbookWriteDto;
import site.unoeyhi.guestbook.domain.dto.PageRequestDto;
import site.unoeyhi.guestbook.domain.dto.PageResultDto;
import site.unoeyhi.guestbook.domain.entity.Guestbook;

public interface GuestbookService {
    Long writer(GuestbookDto dto);
    PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto);

    void modify(GuestbookModifyDto dto);
    void remove(Long gno);

    GuestbookViewDto get(Long gno);

    // dto >>> entity 변환 메서드 정의
    default Guestbook toEntity(GuestbookDto dto){
        return Guestbook.builder()
        .gno(dto.getGno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();
    }

    // entity >>> dto 변환 메서드 정의
    default GuestbookDto toDto(Guestbook en) {
        return GuestbookDto.builder()
        .gno(en.getGno())
        .title(en.getTitle())
        .content(en.getContent())
        .writer(en.getWriter())
        .regDate(en.getRegDate())
        .modDate(en.getModDate())
        .build();
    }
}
