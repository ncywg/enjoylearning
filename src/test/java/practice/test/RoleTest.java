package practice.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import practice.App;
import practice.mapper.RoleMapper;
import practice.persistence.Role;

import javax.annotation.Resource;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class RoleTest {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 测试就测试 干嘛整的这么不要脸
     * 啊哈哈哈哈
     */
    @Test
    public void testInsert(){
        Role role = new Role();
        role.setDescription("女朋友");
        role.setName("王冠");
        roleMapper.insert(role);
    }
    @Test
    public void testGet(){
        Role role = new Role();
        role =  roleMapper.getRoleByName("王冠");
        System.out.println(role);
    }
    @Test
    public void test() throws InterruptedException {
        Long begin = System.currentTimeMillis();
        System.out.println();
        Thread.currentThread().sleep(1000);
        System.out.println(System.currentTimeMillis()-begin);
    }
}
