@Entity
public class Vacation {

    @Id
    private String vacationId;

    private String vacationName;
    private String description;
    private LocalDate startDate;

    @ManyToOne
    private User user;

    private Timestamp creationTime;
    private Timestamp lastChange;
    private String surrogateKey;
}
