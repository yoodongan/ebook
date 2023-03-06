package ryu.ebook.productTag;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import ryu.ebook.base.BaseEntity;
import ryu.ebook.member.Member;
import ryu.ebook.product.Product;
import ryu.ebook.productKeyword.ProductKeyword;

@Entity
@NoArgsConstructor
public class ProductTag extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductKeyword productKeyword;

}
