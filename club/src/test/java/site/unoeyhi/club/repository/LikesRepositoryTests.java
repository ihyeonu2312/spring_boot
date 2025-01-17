package site.unoeyhi.club.repository;

import org.junit.jupiter.api.Test;

import site.unoeyhi.club.entity.Member;
import site.unoeyhi.club.entity.Note;

public class LikesRepositoryTests {
  

  @Test
  public void testDelete() {
    repository.delete(Likes.builder().member(Member.builder().mno(100L).build()).note(Note.builder().num(1L).build()).build());
  }
}
