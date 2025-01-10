package site.unoeyhi.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.unoeyhi.club.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
  Member findByEmail(String email);
  Member findByEmailAndFromSocial(String email, boolean fromSocial);
}