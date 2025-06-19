@Entity
public class Nesting {

    @Id
    private String nestingId;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "containerItemId")
    private Item containerItem;

    @ManyToOne
    @JoinColumn(name = "contentItemId")
    private Item contentItem;

    private Timestamp creationTime;
    private Timestamp lastChange;
    private String surrogateKey;
}
