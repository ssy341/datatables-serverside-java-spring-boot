package club.datatables.serverside.javaversion;

import club.datatables.serverside.javaversion.entity.DatatablesDemo;
import club.datatables.serverside.javaversion.mapper.DatatablesDemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("club.datatables.serverside.javaversion.mapper")
public class DatatablesDemoMapperTest {


        @Autowired
        private DatatablesDemoMapper datatablesDemoMapper;



        @Test
        public void testQuery() throws Exception {
            List<DatatablesDemo> datatablesDemoList = datatablesDemoMapper.getAllByFirstName("Tiger");
            System.out.println(datatablesDemoList.size());
        }




}
