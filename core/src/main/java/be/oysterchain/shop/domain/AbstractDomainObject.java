package be.oysterchain.shop.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * peter
 * 21.07.15
 */
@MappedSuperclass
public abstract class AbstractDomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
