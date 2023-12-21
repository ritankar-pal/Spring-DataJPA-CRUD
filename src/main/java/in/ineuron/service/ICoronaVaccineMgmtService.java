package in.ineuron.service;
import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;


public interface ICoronaVaccineMgmtService {
	public String registerVaccine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccine);
	public Long getVaccinesCount();
	public boolean checkAvailabilityByRegNo(Long regNO);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> id);
	public Optional<CoronaVaccine> fetchVaccineById(Long id);
	public String removeVaccineById(Long id);
	public String removeVaccineByObject(CoronaVaccine vaccine);
	public String removeVaccineById(List<Long> ids);
}
