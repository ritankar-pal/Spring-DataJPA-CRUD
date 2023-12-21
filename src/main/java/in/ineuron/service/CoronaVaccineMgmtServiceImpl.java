package in.ineuron.service;
import java.util.List;
import java.util.Optional;

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

	
	
	@Override
	public boolean checkAvailabilityByRegNo(Long regNO) {
		return repo.existsById(regNO);
	}

	
	
	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return repo.findAll();
	}


	
	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> id) {
		return repo.findAllById(id);
	}

	
	
	
	@Override
	public Optional<CoronaVaccine> fetchVaccineById(Long id) {
		return repo.findById(id);
	}

	
	
	@Override
	public String removeVaccineById(Long id) {
		
		Optional<CoronaVaccine> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Record Deleted with the id: " + id;
		}
		
		return "Record Not availabel for the id: " + id;
	}

	
	
	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		
		Optional<CoronaVaccine> optional = repo.findById(vaccine.getRegNo());
		
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Record deleted with the given id: " + vaccine.getRegNo();
		}

		return "Record Not Available";
	}

	
	
	@Override
	public String removeVaccineById(List<Long> ids) {
		
		Iterable<CoronaVaccine> listEntities = repo.findAllById(ids);
		
		int count = ids.size();
		
		if(count == ((List<CoronaVaccine>) listEntities).size()) {
			repo.deleteAll(listEntities);
			return count + " ids are deleted.";
		}
		
		return "Problem in Deleting the Records...";
	}

}
