package club.datatables.serverside.javaversion.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Datatables中文网 http://datatables.club
 * @date 2020年09月08日14:37:27
 *
 * 实体类
 */
@Entity
@Table(name = "tb_datatables_demo")
@Data
public class DatatablesDemo {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String office;
    private Timestamp startDate;
    private Integer age;
    private Integer salary;
    private Integer seq;
    private String extn;
}
