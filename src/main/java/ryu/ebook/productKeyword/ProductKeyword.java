package ryu.ebook.productKeyword;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import ryu.ebook.base.BaseEntity;

@Entity
@NoArgsConstructor
public class ProductKeyword extends BaseEntity {

    private String content;
}
