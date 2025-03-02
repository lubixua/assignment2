package org.example;

import org.example.service.IShapeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        IShapeService primaryService = context.getBean(IShapeService.class);
        IShapeService qualifiedService = context.getBean("FullInfo", IShapeService.class);

        System.out.println();
        context.getBean(LazyBean.class);
        System.out.println();

        primaryService.addShape("Square", 7.77);
        primaryService.addShape("Circle", 7.77);

        System.out.println(primaryService.displayShape("Square"));
        System.out.println(primaryService.displayShape("Circle"));

        System.out.println(qualifiedService.displayShape("Square"));
        System.out.println(qualifiedService.displayShape("Circle"));

        context.getBean(LazyBean.class); // we won't see this bean
    }
}
