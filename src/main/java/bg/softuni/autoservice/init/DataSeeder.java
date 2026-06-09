package bg.softuni.autoservice.init;

import bg.softuni.autoservice.model.entity.ServiceType;
import bg.softuni.autoservice.repository.ServiceTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ServiceTypeRepository serviceTypeRepository;

    public DataSeeder(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (serviceTypeRepository.count() == 0) {

            ServiceType diagnostics = ServiceType.builder()
                    .name("Diagnostics")
                    .description("Full computer diagnostics and system scan")
                    .price(50.00)
                    .build();

            ServiceType maintenance = ServiceType.builder()
                    .name("Regular Maintenance")
                    .description("Standard service including oil, filters, and basic fluid checks")
                    .price(100.00)
                    .build();

            ServiceType repair = ServiceType.builder()
                    .name("General Repair")
                    .description("Mechanical or electrical repairs. Final price is determined after inspection.")
                    .price(0.00)
                    .build();

            ServiceType inspection = ServiceType.builder()
                    .name("Annual Technical Inspection")
                    .description("Official vehicle safety and emissions check")
                    .price(60.00)
                    .build();

            serviceTypeRepository.saveAll(List.of(diagnostics, maintenance, repair, inspection));
        }
    }
}