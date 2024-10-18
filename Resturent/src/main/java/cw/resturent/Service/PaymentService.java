package cw.resturent.Service;

import cw.resturent.Entity.Payment;
import cw.resturent.Repository.PaymentRepository;
import cw.resturent.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(payment -> new PaymentDTO(payment.getId(), payment.getItemId(), payment.getAmount()))
                .collect(Collectors.toList());
    }

    public PaymentDTO savePayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment(paymentDTO.getItemId(), paymentDTO.getAmount());
        Payment savedPayment = paymentRepository.save(payment);
        return new PaymentDTO(savedPayment.getId(), savedPayment.getItemId(), savedPayment.getAmount());
    }

    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        payment.setItemId(paymentDTO.getItemId());
        payment.setAmount(paymentDTO.getAmount());
        Payment updatedPayment = paymentRepository.save(payment);
        return new PaymentDTO(updatedPayment.getId(), updatedPayment.getItemId(), updatedPayment.getAmount());
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public PaymentDTO getPayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        return new PaymentDTO(payment.getId(), payment.getItemId(), payment.getAmount());
    }
}