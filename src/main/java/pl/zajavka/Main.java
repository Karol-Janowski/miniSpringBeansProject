package pl.zajavka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.zajavka.configuration.ApplicationConfiguration;
import pl.zajavka.service.MainProcessor;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        MainProcessor mainProcessor = context.getBean(MainProcessor.class);

//        MainProcessor mainProcessor = new MainProcessor(
//                new DataRepository(),
//                new DataProcessingService(
//                        new StringPreparationService()
//                )
//        );
        mainProcessor.process();
    }

}
