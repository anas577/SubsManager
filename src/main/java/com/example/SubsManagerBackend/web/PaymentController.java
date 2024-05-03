package com.example.SubsManagerBackend.web;

import com.example.SubsManagerBackend.dao.entities.Payment;
import com.example.SubsManagerBackend.dao.entities.Subscription;
import com.example.SubsManagerBackend.service.PaymentManager;
import com.example.SubsManagerBackend.service.SubscriptionManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentManager paymentManager;
    private SubscriptionManager subscriptionManager;

    public PaymentController(PaymentManager paymentManager, SubscriptionManager subscriptionManager) {
        this.paymentManager = paymentManager;
        this.subscriptionManager = subscriptionManager;
    }

    @GetMapping
    public List<Payment> payments(){
        return (List<Payment>) paymentManager.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Integer id){
        return paymentManager.getPaymentById(id);
    }

    @PostMapping()
    public Payment createPayment(@RequestBody Payment payment){
        Subscription subscription = subscriptionManager.getSubscriptionById(payment.getSubscription().getId());
        payment.setSubscription(subscription);
        return paymentManager.addPayment(payment);

    }
}
