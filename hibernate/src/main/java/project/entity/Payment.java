package project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment extends project.entity.Entity {

    private static final long serialVersionUID = 5414138964096325700L;

    @Column(name = "amount")
    private float sum;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return new StringBuilder("Payment [sum=").append(sum).append(", getId()=").append(getId()).append("]")
                .toString();
    }
}
