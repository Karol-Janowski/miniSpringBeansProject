package pl.zajavka.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.zajavka.Main;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class ApplicationConfiguration {

}
