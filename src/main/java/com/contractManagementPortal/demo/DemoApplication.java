package com.contractManagementPortal.demo;

import com.contractManagementPortal.demo.entities.Contractor;
import com.contractManagementPortal.demo.entities.PaymentType;
import com.contractManagementPortal.demo.repository.ContractorRepository;
import com.contractManagementPortal.demo.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

//Command line runner to boot strap data into H2 database at application start up.
@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private ContractorRepository contractorRepository;

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	@Override
	public void run(String... args) throws Exception {

		//Create contractor 1.
		Contractor contractor = new Contractor();
		contractor.setId(UUID.randomUUID());
		contractor.setName("Mickey's Engineering");
		contractor.setStreet("8300 Metcalf Avenue");
		contractor.setCity("Overland Park");
		contractor.setState("Kansas");
		contractor.setZip("66212");
		Date date = new Date();
		contractor.setDateAdded(date);
		contractorRepository.save(contractor);

		//Create contractor 2.
		Contractor contractor2 = new Contractor();
		contractor2.setId(UUID.randomUUID());
		contractor2.setName("JE Contractor's");
		contractor2.setStreet("1200 Main Street");
		contractor2.setCity("Kansas City");
		contractor2.setState("Missouri");
		contractor2.setZip("64114");
		Date date2 = new Date();
		contractor2.setDateAdded(date2);
		contractorRepository.save(contractor2);

		Contractor contractor3 = new Contractor();
		contractor3.setId(UUID.randomUUID());
		contractor3.setName("KC Concrete Cutters");
		contractor3.setStreet("2100 Southwest Boulevard");
		contractor3.setCity("Kansas City");
		contractor3.setState("Missouri");
		contractor3.setZip("64118");
		Date date3 = new Date();
		contractor3.setDateAdded(date3);
		contractorRepository.save(contractor3);

		//Start here:  http://progressivecoder.com/inserting-records-to-table-using-spring-boot/

		//Create payment types
		PaymentType paymentType = new PaymentType();
		paymentType.setType("ACH");
		paymentTypeRepository.save(paymentType);

		PaymentType paymentType2 = new PaymentType();
		paymentType2.setType("Credit Card");
		paymentTypeRepository.save(paymentType2);

		PaymentType paymentType3 = new PaymentType();
		paymentType3.setType("Unknown");
		paymentTypeRepository.save(paymentType3);

	}
}
