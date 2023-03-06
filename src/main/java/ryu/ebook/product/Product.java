package ryu.ebook.product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ryu.ebook.base.BaseEntity;
import ryu.ebook.member.Member;
import ryu.ebook.postKeyword.PostKeyword;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    private String subject;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;
    @ManyToOne(fetch = FetchType.LAZY)
    private PostKeyword postKeyword;

}
