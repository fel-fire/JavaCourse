package edu.baykov.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext("edu.baykov.spring");
        System.out.println(new Date());
        System.out.println(context.getBean("hello"));
        System.out.println(context.getBean("randomInt"));
        System.out.println(context.getBean("randomInt"));
        System.out.println(context.getBean("randomInt"));
        Thread.sleep(5000);
        System.out.println(context.getBean("date"));
        System.out.println(context.getBean("date"));
        System.out.println(context.getBean("date"));
        System.out.println(context.getBean("date"));
        Predicate<Integer> predicate = (Predicate<Integer>) context.getBean("2to5");
        System.out.println(predicate.test(4));
        System.out.println(context.getBean("minimum"));
        System.out.println(context.getBean("max"));
        System.out.println();


        System.out.println("Trying with XML...");
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext(
                "edu/baykov/spring/applicationContext.xml");
        System.out.println(new Date());
        System.out.println(xmlContext.getBean("hello"));
        System.out.println(xmlContext.getBean("RandomInt"));
        System.out.println(xmlContext.getBean("RandomInt"));
        System.out.println(xmlContext.getBean("RandomInt"));
        Thread.sleep(5000);
        System.out.println(xmlContext.getBean("xmlDate"));
        System.out.println(xmlContext.getBean("DateFromXML"));
        System.out.println(xmlContext.getBean("xmlDate"));
        Predicate<Integer> xmlPredicate = (Predicate<Integer>) xmlContext.getBean("2to5");
        System.out.println(xmlPredicate.test(4));
        System.out.println(xmlContext.getBean("max"));
        System.out.println(xmlContext.getBean("min"));





    }
}
