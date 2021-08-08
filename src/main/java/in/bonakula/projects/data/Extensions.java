package in.bonakula.projects.data;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Entity
public class Extensions {

    @Id
    private BigInteger id;
    @Column
    private String extname;

    @Column
    private String dep;

    @Column
    private String ver;

    @Column
    private String info;

    @Column
    private String path;
}
