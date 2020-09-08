package club.datatables.serverside.javaversion.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class DatatablesDemoVo {

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

    @JsonProperty("DT_RowId")
    private String rowId;

    @JsonProperty("DT_RowClass")
    private String rowClass;

    @JsonProperty("DT_RowData")
    private Object rowData;

    @JsonProperty("DT_RowAttr")
    private Object rowAttr;
}
