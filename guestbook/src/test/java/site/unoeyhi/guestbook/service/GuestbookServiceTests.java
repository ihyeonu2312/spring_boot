package site.unoeyhi.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import site.unoeyhi.guestbook.domain.dto.GuestbookDto;
import site.unoeyhi.guestbook.domain.dto.PageRequestDto;
import site.unoeyhi.guestbook.domain.dto.PageResultDto;
import site.unoeyhi.guestbook.domain.entity.Guestbook;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTests {
  @Autowired
  private GuestbookService service;

  @Test
  public void restWrite(){
    GuestbookDto dto = GuestbookDto.builder()
    .title("서비스 테스트 제목")
    .content("서비스 내용")
    .writer("서비스 작성자")
    .build();

    Long gno = service.writer(dto);
    assertNotNull(gno);
  }

  @Test
  public void testList() {
    PageResultDto<GuestbookDto, Guestbook> dto = service.list(new PageRequestDto(2, 10));
    log.info(dto);
    dto.getPageList().forEach(log::info);
  }

  @Test
  public void testResultDto() {

  }

}
