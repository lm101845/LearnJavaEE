# MyBatis及MyBatis-Plus学习笔记

## MyBatis

## MyBatis-Plus

### selectList

`UserMapper.java`：

~~~java

~~~

`test.java`：

~~~java
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;
    //报红线，其实没事

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合,若没有条件，则可以设置参数为null
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
~~~

