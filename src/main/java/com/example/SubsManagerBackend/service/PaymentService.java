package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.PaymentRepository;
import com.example.SubsManagerBackend.dao.Repositories.SubscriptionRepository;
import com.example.SubsManagerBackend.dao.entities.Payment;
import com.example.SubsManagerBackend.dao.entities.RenewalFrequency;
import com.example.SubsManagerBackend.dao.entities.Subscription;
import com.example.SubsManagerBackend.dao.entities.SubscriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Service
public class PaymentService implements PaymentManager{
    @Autowired
    private  PaymentRepository paymentRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
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
    @Scheduled(cron = "0 57 14 * * *")
    @Override
    public void processActiveSubscriptions() {
        System.out.println("Processing active subscriptions");
        List<Subscription> activeSubscriptions = subscriptionRepository.findByStatus(SubscriptionStatus.ACTIVE);

        for (Subscription subscription : activeSubscriptions) {
            LocalDate startDate = subscription.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate now = LocalDate.now();

            if (startDate.getDayOfMonth() == now.getDayOfMonth()) {
                int months = Period.between(startDate, now).getMonths();

                // Create a new payment
                Payment payment = new Payment();
                payment.setDate(new Date());
                payment.setAmount(subscription.getPaymentCost());
                payment.setSubscription(subscription);

                // Save the payment to the database
                paymentRepository.save(payment);
            }
        }
    }
}
