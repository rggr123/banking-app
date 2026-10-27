package kodevo.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kodevo.banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
