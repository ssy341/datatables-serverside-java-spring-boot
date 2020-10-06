package club.datatables.serverside.javaversion.mapper;

import club.datatables.serverside.javaversion.entity.DatatablesDemo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DatatablesDemoMapper {

    List<DatatablesDemo> getAllByFirstName(@Param("firstName") String firstName);
}
