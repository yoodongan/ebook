package ryu.ebook.member;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ryu.ebook.base.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    private String password;

    private String nickname;
    private String email;

}
