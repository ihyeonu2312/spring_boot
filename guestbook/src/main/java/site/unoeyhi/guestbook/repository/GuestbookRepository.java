package site.unoeyhi.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import site.unoeyhi.guestbook.domain.entity.Guestbook;
import site.unoeyhi.guestbook.domain.entity.GuestbookEntity;

// @Repository
public interface GuestbookRepository extends JpaRepository<Guestbook,Long>
      , QuerydslPredicateExecutor<Guestbook> {
            
}
