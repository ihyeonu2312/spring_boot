package site.unoeyhi.club.repository;

import java.lang.reflect.Member;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import site.unoeyhi.club.entity.Note;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class NoteRepositoryTests {
  @Autowired
  private NoteRepository repository;

  @Test
  public void testExist(){
    log.info(repository);
  }
  @Test
  public void testOne(){
    log.info(repository.findByNum(1L));
  }
  @Test
  @Rollback(false)
  public void testSave(){
    // LongStream.rangeClosed(1, 5).boxed().map(l-> 
    //   Note.builder()
    //   .title("제목"+l)
    //   .content("내용"+l)
    //   .member(Member.builder()
    //   .mno(100L)
    //   .build()
    //   ).build()).forEach(repository::save);
  }
  @Test
  public void testList(){
    repository.findByMemberMno(100L).forEach(log::info);
  }

  @Test
  public void testList2(){
    repository.findByMemberEmail("user100@sangwon97.com").forEach(log::info);
  }
}
