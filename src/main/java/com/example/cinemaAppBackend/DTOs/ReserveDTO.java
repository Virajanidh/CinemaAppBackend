package com.example.cinemaAppBackend.DTOs;

public class ReserveDTO {

    private String nic;
    private String message;

    private long paymentId;

    public ReserveDTO(String nic, String message, long paymentId) {
        this.nic = nic;
        this.message = message;
        this.paymentId = paymentId;
    }


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }
}
