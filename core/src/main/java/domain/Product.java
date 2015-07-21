package domain;

import com.mysql.jdbc.Clob;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.datatransfer.StringSelection;

@Entity
@Table(name = "PRODUCT")
public class Product extends AbstractDomainObject {

    @NotNull
    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Lob
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Product code [%s], name [%s], description [%s]", code, name, description);
    }


}
