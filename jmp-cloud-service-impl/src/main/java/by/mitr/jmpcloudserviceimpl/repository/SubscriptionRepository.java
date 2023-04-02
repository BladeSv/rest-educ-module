package by.mitr.jmpcloudserviceimpl.repository;

import by.mitr.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {
}
