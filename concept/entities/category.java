@Entity
public class Category {

    @Id
    private String categoryId;

    private String categoryName;

    @ManyToOne
    private User user;

    private Timestamp creationTime;
    private Timestamp lastChange;
    private String surrogateKey;
}
