@Entity
public class Item {

    @Id
    private String itemId;

    private String itemName;
    @Lob
    private byte[] picture;

    private String color;
    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal weight;
    private String amountUnit;
    private boolean consumeable;

    private String tags;
    private String branding;
    private boolean container;

    private Integer sortNo;
    private String priority;
    private BigDecimal price;
    private boolean active;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    private Timestamp creationTime;
    private Timestamp lastChange;
    private String surrogateKey;
}
