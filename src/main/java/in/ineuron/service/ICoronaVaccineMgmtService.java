package in.ineuron.service;
import in.ineuron.bo.CoronaVaccine;


public interface ICoronaVaccineMgmtService {
	public String registerVaccine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccine);
	public Long getVaccinesCount();
}
