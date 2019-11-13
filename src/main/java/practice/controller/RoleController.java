package practice.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import practice.mapper.RoleMapper;
import practice.persistence.Role;

import javax.annotation.Resource;


//restController 没什么好说的 就是controller 加上了个 @ResponseBody
@RestController
public class RoleController {
    private static Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private RoleMapper roleMapper;

    @GetMapping("/hello")
    public Role hello() {
        //return new Role();
        return roleMapper.getRoleByName("王冠");
    }
    @Transactional
    @PostMapping("/createRoles/{name1}/{name2}")
    @ResponseBody
    public int createRoles(@PathVariable(name = "name1") String name1,@PathVariable(name = "name2") String name2){
        int affectRows;
        Role role1 = new Role();
        role1.setName(name1);
        role1.setDescription("测试1");
        affectRows = roleMapper.insert(role1);
        System.out.println(1/0);
        Role role2 = new Role();
        role2.setName(name2);
        role2.setDescription("测试1");
        affectRows += roleMapper.insert(role2);
        return affectRows;
    }
    @ApiOperation(value = "灵魂拷问",notes = "最让你瞎想的一个字是什么")
    @ApiImplicitParam(name = "对于某个人",value = "人名",required = true,dataType = "string")
    @PostMapping("/onEarthWho")
    public Object soulQuesion(String toPerson){
        if("王冠".equals(toPerson)){
            return "一诺千金";
        }
       return "没有";
    }

}
