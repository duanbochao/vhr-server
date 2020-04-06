##创建基本的工程
+ 注意springboot的版本的问题，该版本是2.0.4.RELEASE
+ mybatis-spring整合依赖
```
        <!--mybatis-spring-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>
```
> 注意不是下面的

```
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>RELEASE</version>
        </dependency>
```
## springboot单元测试
+ 引入测试依赖
```
        <!--spring-boot-starter-test-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```

+ 书写测试类
 ```
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAPITest {

      // 测试接口
}
```

## ObjectMapper的作用
+ 通过对比理解掌握该类的作用
```aidl
    @Test
    public void test1(){
        ObjectMapper om = new ObjectMapper();
        String hello = null;
        try {
            hello = om.writeValueAsString(RespBean.ok("hello"));
            System.out.println(RespBean.ok("hello")); //打印结果为,这个前提还要使用tostring RespBean{status=200, data=hello}
            System.out.println(hello);//打印结果为  {"status":200,"data":"hello"}
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
```

## 去除idea中代码重复的提示
```aidl
Setting--Editor--Inspections--General---Duplicated Code fragment ,把勾去掉即可。
还有去除mapper中的背景色，请参考https://www.cnblogs.com/lgjlife/p/10397261.html
```

## 后台异常处理
+ UsernameNotFoundException 用户名错误异常
+ 用户名或密码不对抛出的异常BadCredentialsException
+ 因为在hr中enabled被返回enabled而不是true，所以这个地方还有一个DisabledException异常
+ 如果想要添加其他的异常，可以自己先到hr中参考enable返回相应的属性，然后在设置相应的异常处理即可。
```aidl
   RespBean respBean = new RespBean();
                        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException){
                            respBean= respBean.err("用户名或密码错误，登录失败!");
                        }else if (e instanceof DisabledException){
                            respBean= respBean.err("账号被禁用，请联系管理员!");
                        }else{
                            respBean= respBean.err("登录失败!");
                        }

```

## 获取菜单和菜单对应的角色
```aidl
select m.*,r.`id` as rid,r.`name` as rname,r.`nameZh` as rnamezh from menu m 
left join menu_role mr on m.`id`=mr.`mid` 
left join role r on mr.`rid`=r.`id` 
WHERE m.`enabled`=true
order by m.`id` desc
```


## url访问的几种方式
> 详情请参考博客https://www.cnblogs.com/gfbzs/p/12642324.html

