@Entity
public class Packlist {

    @Id
    private String packlistId;

    private BigDecimal amount;
    private String note;
    private Integer sortNo;
    private String todoNote;
    private boolean checked;
    private boolean extraEndCheck;

    @ManyToOne
    private Vacation vacation;

    @ManyToOne
    private Item item;

    private Timestamp creationTime;
    private Timestamp lastChange;
    private String surrogateKey;
}
