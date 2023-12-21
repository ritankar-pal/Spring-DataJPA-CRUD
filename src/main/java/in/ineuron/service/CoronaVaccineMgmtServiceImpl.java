package in.ineuron.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;


@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;
	
	@Override
	public String registerVaccine(CoronaVaccine vaccine) {
		System.out.println("In Memory Proxy Class:: " + repo.getClass().getName());
		
		CoronaVaccine saveVaccine = null; 
		
		if(vaccine != null) {
			saveVaccine = repo.save(vaccine);
		}
		
		return saveVaccine != null ? "Vaccine Registered Successfully with ID: " + saveVaccine.getRegNo() : 
			"Vaccine Registration Failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccine) {
		
		if(vaccine != null)
			return repo.saveAll(vaccine);
		
		throw new IllegalArgumentException("Batch Insertion Failed...");
	}

	@Override
	public Long getVaccinesCount() {		
		
		return repo.count();
		
	}

}
