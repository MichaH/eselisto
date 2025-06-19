@Entity
public class User {

    @Id
    private String userId;

    private String userName;

    private Timestamp creationTime;
    private Timestamp lastChange;
    private String surrogateKey;
}
