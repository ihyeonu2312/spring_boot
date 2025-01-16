package site.unoeyhi.club.entity;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import site.unoeyhi.club.entity.composite.LikesId;

@Entity(name = "tbl_likes")
@EnableJpaRepositories
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(LikesId.class)
public class Likes extends BaseEntity{
@Id
@ManyToOne(fetch = FetchType.LAZY)
private Member member;
@Id
}
