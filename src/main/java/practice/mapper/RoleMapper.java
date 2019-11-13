package practice.mapper;

import practice.persistence.Role;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {
    Role getRoleByName(String name);
}
