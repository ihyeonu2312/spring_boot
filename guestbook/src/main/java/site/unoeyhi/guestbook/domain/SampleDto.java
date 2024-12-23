package site.unoeyhi.guestbook.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SampleDto {
  private long sno;
  private String first;  
  private String last;
  private LocalDateTime regTime;  
}
