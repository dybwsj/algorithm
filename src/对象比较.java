import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 对象比较 {
    //对象比较可以通过使对象实现comparable接口，实现comparaTo方法实现
    //也可以通过实现Comparator接口实现，通常接口lambda表达式和Collections.sort方法使用
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        String a = "1";

        list.add(new User(1, "a"));
        list.add(new User(4, "d"));
        list.add(new User(3, "c"));
        list.add(new User(5, "e"));
        list.add(new User(2, "b"));
        list.add(new User(6, "f"));
        list.add(new User(7, "g"));
        Collections.sort(list, (x, y) -> y.id - x.id);   //倒序
        Collections.sort(list, Comparator.comparingInt(x -> x.id));   //正序
        System.out.println(list);
    }
    static class User {
        int id;
        String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }
}
