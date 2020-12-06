package ru.geekbrains.javacore.lesson7.testrunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestRunner {


    public static void start(String className)
            throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class cls = Class.forName(className);
        start(cls);
    }

    public static void start(Class clazz)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Object instance = getInstance(clazz);

        Method[] methods = clazz.getDeclaredMethods();
        Method beforeSuite = getUniqueAnnotated(methods, BeforeSuite.class);
        Method afterSuite = getUniqueAnnotated(methods, AfterSuite.class);

        if (beforeSuite != null) beforeSuite.invoke(instance);

        List<Method> testAnnotatedMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted((o1, o2) -> o2.getAnnotation(Test.class).priotity().compareTo(o1.getAnnotation(Test.class).priotity()))
                .collect(Collectors.toList());
        for (Method method : testAnnotatedMethods) {
            method.invoke(instance);
        }

        if (afterSuite != null) afterSuite.invoke(instance);
    }

    private static Object getInstance(Class clazz)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor constructor = clazz.getConstructor(new Class[]{});
        Object instance = constructor.newInstance();
        return instance;
    }

    public static Method getUniqueAnnotated(Method[] methods, Class annotationClass) {
        int counter = 0;
        Method result = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                counter++;
                if (counter > 1)
                    throw new RuntimeException("Only one @" + annotationClass.getSimpleName() + " annotated method supported");
                result = method;
            }
        }
        return result;
    }

}
