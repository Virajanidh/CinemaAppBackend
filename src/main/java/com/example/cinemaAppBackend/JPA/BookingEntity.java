package com.example.cinemaAppBackend.JPA;

import org.springframework.security.access.method.P;

import javax.persistence.*;

@Entity
@Table(name="booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long bookingId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "payment_id")
//    private PaymentEntity paymentEntity;

    private long paymentId;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private ShowEntity showEntity;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seatEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    private int noOfBookedSeats;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaUserEntity cinemaUserEntity;

    public CinemaUserEntity getCinemaUserEntity() {
        return cinemaUserEntity;
    }

    public void setCinemaUserEntity(CinemaUserEntity cinemaUserEntity) {
        this.cinemaUserEntity = cinemaUserEntity;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public ShowEntity getShowEntity() {
        return showEntity;
    }

    public void setShowEntity(ShowEntity showEntity) {
        this.showEntity = showEntity;
    }

    public SeatEntity getSeatEntity() {
        return seatEntity;
    }

    public void setSeatEntity(SeatEntity seatEntity) {
        this.seatEntity = seatEntity;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public int getNoOfBookedSeats() {
        return noOfBookedSeats;
    }

    public void setNoOfBookedSeats(int noOfBookedSeats) {
        this.noOfBookedSeats = noOfBookedSeats;
    }
}
