package JavaIO;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Errol on 17/3/9.
 * 桌面上创建文件
 */
public class CreateFileOnDesktop {

    public static void main(String[] args) {
        try {
            //获取桌面路径
            FileSystemView fileSystemView = FileSystemView.getFileSystemView();
            System.out.print(fileSystemView.getHomeDirectory());
            //\r 回车 \n 换行
            System.out.print("\r\n");

            //java 反射机制
            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
            File file = constructor.newInstance(fileSystemView.getHomeDirectory()+"\\"+"test.txt");
//            file.createNewFile();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

}
