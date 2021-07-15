package ua.lviv.lgs.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "bucket")
public class Bucket {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="user_id",referencedColumnName = "id")
    private  User user_id;

    @ManyToOne
    @JoinColumn(name ="product_id",referencedColumnName = "id")
    private  Product product_id;

    @Column(name = "purchase_date")
    private Date purchase_date;



    public Bucket(Integer userId, int i, Date date) {

    }

    public Bucket() {

    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return id.equals(bucket.id) && user_id.equals(bucket.user_id) && product_id.equals(bucket.product_id) && purchase_date.equals(bucket.purchase_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, product_id, purchase_date);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", purchase_date=" + purchase_date +
                '}';
    }
}
