package kodevo.banking_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/banking")
public class BankingController {

    // View accounts accessible by users or admins
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/accounts")
    public ResponseEntity<?> getAccounts() {
        return ResponseEntity.ok("Account details list");
    }

    // High level closing commands strictly for system administrators
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> closeAccount(@PathVariable Long id) {
        return ResponseEntity.ok("Account successfully terminated");
    }
}
