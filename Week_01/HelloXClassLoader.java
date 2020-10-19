import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description: 自定义ClassLoader加载Hello.xlass文件
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @FileName: HelloXClassLoader
 * Copyright (C), 2015-2020
 */
public class HelloXClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloXClassLoader().findClass("Hello");
            Object obj = helloClass.newInstance();
            Method method = helloClass.getMethod("hello");
            method.invoke(obj);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获取文件路径
        Path path = Paths.get(Paths.get(".").toAbsolutePath().getParent().toString(), "\\Week_01\\Hello.xlass");
        //打印路径，检查路径是否正确
        System.out.println(path);
        byte[] bytes;
        try {
            //读取文件全部字节，如果文件过大则不建议采用该方法
            bytes = Files.readAllBytes(path);
            //转换字节码
            convertByte(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        }
        //把字节码转换成Class
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 转换字节码
     *
     * @param bytes
     */
    private void convertByte(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ~bytes[i];
        }
    }
}
