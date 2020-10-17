package project.entity;

public class Role extends Entity {

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        //return String.format("Role [id=%s, name=%s]", getId(), name);

        return new StringBuilder("Role [id=").append(getId())
                .append(", name=`").append(name)
                .append("']").toString();
    }
}
