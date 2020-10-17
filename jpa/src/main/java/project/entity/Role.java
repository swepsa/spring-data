package project.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NamedQuery(name = "findUsersRoles", query = " SELECT U.roles FROM project.entity.User U where U.id = :id")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder("Role [id=").append(getId()).append(", name=`").append(name).append("']").toString();
    }

}
