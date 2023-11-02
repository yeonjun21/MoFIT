package projectmofit.mofit.global.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"projectmofit.mofit.domain.user.dao", "projectmofit.mofit.domain.group.dao"})
public class DBConfig {
}
