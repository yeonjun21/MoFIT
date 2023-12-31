package projectmofit.mofit.global.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"projectmofit.mofit.domain.user.dao",
        "projectmofit.mofit.domain.group.dao",
        "projectmofit.mofit.domain.board.dao",
        "projectmofit.mofit.domain.notice.dao",
        "projectmofit.mofit.domain.gallery.dao"})
public class DBConfig {
}
