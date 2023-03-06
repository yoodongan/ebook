package ryu.ebook.postKeyword;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import ryu.ebook.base.BaseEntity;

@Entity
@NoArgsConstructor
public class PostKeyword extends BaseEntity {
    private String content;
}
