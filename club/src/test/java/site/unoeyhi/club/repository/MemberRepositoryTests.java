package site.unoeyhi.club.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import site.unoeyhi.club.entity.Member;
import site.unoeyhi.club.entity.MemberRole;

@SpringBootTest
public class MemberRepositoryTests {

  @Autowired
  private MemberRepository repository;
  private PasswordEncoder encoder;
  
  @Test
  public void testInsert(){

    IntStream.rangeClosed(1, 100).forEach(i -> {
      Member member = Member.builder().email("user"+i +"@sangwon97 "+ i + ".com").name("USER" + i).password(encoder.encode("1234")).build();
      member.addMemberRole(MemberRole.USER);

      if(i > 80) {
        member.addMemberRole(MemberRole.MANAGER);
      }
      if(i > 90){
        member.addMemberRole(MemberRole.ADMIN);
      }

      repository.save(member);
    });
  }
  
}
