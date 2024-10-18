package cw.resturent.dto;


public class PaymentDTO {
    private Long id;
    private Long itemId;
    private double amount;

    // Constructors, Getters, and Setters
    public PaymentDTO() {}

    public PaymentDTO(Long id, Long itemId, double amount) {
        this.id = id;
        this.itemId = itemId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}