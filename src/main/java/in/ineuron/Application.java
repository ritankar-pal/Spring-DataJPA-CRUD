package in.ineuron;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.CoronaVaccineMgmtServiceImpl;
import in.ineuron.service.ICoronaVaccineMgmtService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext factory = SpringApplication.run(Application.class, args);
		
		ICoronaVaccineMgmtService service = factory.getBean("service" ,CoronaVaccineMgmtServiceImpl.class);
		
		//Single Insertion::
		/*
		 * CoronaVaccine vaccine = new CoronaVaccine(null, "Covishield", "Astra-Zeneca",
		 * "UK", 500.54, 3); System.out.println(service.registerVaccine(vaccine));
		 */
		
		
		//Bulk Insertion::
		
		/*
		 * List<CoronaVaccine> list = new ArrayList<>();
		 * 
		 * list.add(new CoronaVaccine(null, "Covovax", "Serum", "India", 300.0, 2));
		 * list.add(new CoronaVaccine(null, "Sputnki V", "Sputnik", "Russia", 507.90,
		 * 3)); list.add(new CoronaVaccine(null, "Nuvaxovid", "Novovax", "Australia",
		 * 300.5, 2)); list.add(new CoronaVaccine(null, "Spikevax", "Moderna", "USA",
		 * 407.90, 3)); list.add(new CoronaVaccine(null, "Comirnaty", "Pfizer", "USA",
		 * 450.90, 2));
		 * 
		 * Iterable<CoronaVaccine> vaccines = service.registerInBatch(list);
		 * vaccines.forEach(vcc -> System.out.println("Vaccine ID: " + vcc.getRegNo()));
		 */
		
		//count::
		Long count = service.getVaccinesCount();
//		System.out.println("Total No.of Records are: " + count);
		
		
	
		
		((ConfigurableApplicationContext) factory).close();
	}

}
