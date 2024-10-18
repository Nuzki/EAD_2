package cw.resturent.controllers;

import cw.resturent.Service.PaymentService;
import cw.resturent.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping
    public PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.savePayment(paymentDTO);
    }

    @PutMapping("/{id}")
    public PaymentDTO updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
        return paymentService.updatePayment(id, paymentDTO);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Deleted";
    }

    @GetMapping("/{id}")
    public PaymentDTO getPayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }
}
