package site.unoeyhi.club.entity.dto;

import site.unoeyhi.club.entity.BaseEntity;
import site.unoeyhi.club.entity.Note;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "tbl_attach")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "note")
public class Attach extends BaseEntity{
  @Id
  private String uuid;

  private String origin;
  private boolean image;
  private String path;

  private long size;
  private String mime;
  private String fileName;
  private String ext;
  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  private Note note;
}