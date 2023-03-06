package ryu.ebook.post;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ryu.ebook.base.BaseEntity;
import ryu.ebook.member.Member;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {

    private String subject;
    private String content;
    private String contentHtml;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

}
