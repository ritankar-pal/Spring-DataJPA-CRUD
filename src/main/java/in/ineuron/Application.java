package in.ineuron;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		 * list.add(new CoronaVaccine(null, "Sputnki V", "Sputnik", "Russia", 507.90,3)); 
		 * list.add(new CoronaVaccine(null, "Nuvaxovid", "Novovax", "Australia",
		 * 300.5, 2)); 
		 * list.add(new CoronaVaccine(null, "Spikevax", "Moderna", "USA", 407.90, 3)); 
		 * list.add(new CoronaVaccine(null, "Comirnaty", "Pfizer", "USA", 450.90, 2));
		 * 
		 * Iterable<CoronaVaccine> vaccines = service.registerInBatch(list);
		 * vaccines.forEach(vcc -> System.out.println("Vaccine ID: " + vcc.getRegNo()));
		 */
		
		
		
		//count::
		/*
		 * Long count = service.getVaccinesCount();
		 * System.out.println("Total No.of Records are: " + count);
		 */
		
		
		
		//Check for an object on the basis of ID::
		/*
		 * boolean status = service.checkAvailabilityByRegNo(3L);
		 * System.out.println("Is Vaccine with ID 3 available? => " + status);
		 */
		
		
		
		//fetch all data::
//		Iterable<CoronaVaccine> fetch = service.fetchAllDetails();
//		fetch.forEach(System.out::println);
		
		//fetch details by ID::
		/*
		 * List<Long> listOfId = new ArrayList<>(); listOfId.add(1L); listOfId.add(3L);
		 * 
		 * Iterable<CoronaVaccine> fetch = service.fetchAllDetailsById(listOfId);
		 * fetch.forEach(System.out::println);
		 */
		
		
		
		//fetch by ID(Optional<>):
		/*
		 * Optional<CoronaVaccine> optional = service.fetchVaccineById(3L);
		 * if(optional.isPresent()) { System.out.println(optional.get()); } else {
		 * System.out.println("Record Not Available"); }
		 */
//		System.out.println(service.fetchVaccineById(10L).orElse(new CoronaVaccine()));
//		System.out.println(service.fetchVaccineById(10L).orElseGet(() -> new CoronaVaccine()));
		
		
		
		//deletion by ID::
		/*
		 * String status = service.removeVaccineById(5L); System.out.println(status);
		 */
		
		
		
		//deletion by Entity::
		/*
		 * String status = service.removeVaccineByObject(new CoronaVaccine(4L,
		 * "Sputnik V", "Sputnik", "Russia", 507.9, 3)); System.out.println(status);
		 */
		
		
		//batch deletion::
		List<Long> list = new ArrayList<>();
		list.add(2L);
		list.add(7L);
		
		String status = service.removeVaccineById(list);
		System.out.println(status);
		
		((ConfigurableApplicationContext) factory).close();
		
		
	}

}
