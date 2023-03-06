package ryu.ebook.postTag;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import ryu.ebook.base.BaseEntity;
import ryu.ebook.member.Member;
import ryu.ebook.post.Post;
import ryu.ebook.postKeyword.PostKeyword;

@Entity
@Getter
public class PostTag extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostKeyword postKeyword;
}
