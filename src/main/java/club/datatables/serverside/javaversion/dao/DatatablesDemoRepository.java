package club.datatables.serverside.javaversion.dao;

import club.datatables.serverside.javaversion.entity.DatatablesDemo;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Datatables中文网 http://datatables.club
 * @date 2020年09月08日14:37:27
 *
 * 持久层
 */
public interface DatatablesDemoRepository
        extends DataTablesRepository<DatatablesDemo,Long>, JpaRepository<DatatablesDemo,Long> {

}
