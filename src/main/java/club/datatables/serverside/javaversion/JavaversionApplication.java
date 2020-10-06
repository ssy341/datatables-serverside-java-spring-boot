package club.datatables.serverside.javaversion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Datatables中文网 http://datatables.club
 * @date 2020年09月08日14:37:27
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
@MapperScan("club.datatables.serverside.javaversion.mapper")
public class JavaversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaversionApplication.class, args);
    }

}
