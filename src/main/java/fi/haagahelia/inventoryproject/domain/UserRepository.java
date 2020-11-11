package fi.haagahelia.inventoryproject.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository {
    public User findByUsername(String username);
    public void save(User user);
}