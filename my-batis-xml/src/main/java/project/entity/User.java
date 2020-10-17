package project.entity;

import java.util.List;

public class User extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return new StringBuilder("User [id=").append(getId()).append(" name=").append(name).append(", roles=").append(roles).append("]").toString();
    }
}
