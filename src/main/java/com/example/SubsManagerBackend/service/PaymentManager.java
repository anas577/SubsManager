package com.example.SubsManagerBackend.service;



import com.example.SubsManagerBackend.dao.entities.Payment;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface PaymentManager {
    public Payment addPayment(Payment payment);
    public Payment updatePayment(Payment payment);
    public boolean deletePayment(Payment payment);
    public boolean deletePaymentById(Integer id);
    public Collection<Payment> getAllPayments();
    public Payment getPaymentById(Integer id);

}
