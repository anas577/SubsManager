package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.PaymentRepository;
import com.example.SubsManagerBackend.dao.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class PaymentService implements PaymentManager{
    @Autowired
    private  PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        try{
            return paymentRepository.save(payment);
        }catch(Exception exception){
            System.out.println(exception);
            return null;
        }
    }

    @Override
    public Payment updatePayment(Payment payment) {
        try{
            return paymentRepository.save(payment);
        }catch(Exception exception){
            System.out.println(exception);
            return null;
        }
    }

    @Override
    public boolean deletePayment(Payment notification) {
        try{
            paymentRepository.delete(notification);
            return true;
        }catch(Exception exception){
            System.out.println(exception);
            return false;
        }
    }

    @Override
    public boolean deletePaymentById(Integer id) {
        try{
            paymentRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            System.out.println(exception);
            return false;
        }
    }

    @Override
    public Collection<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id).get();
    }
}
