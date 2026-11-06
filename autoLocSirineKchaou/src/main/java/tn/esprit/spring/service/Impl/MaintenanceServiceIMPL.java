package tn.esprit.spring.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Maintenance;
import tn.esprit.spring.entity.Vehicule;
import tn.esprit.spring.repository.MaintenanceRepository;
import tn.esprit.spring.repository.VehiculeRepository;
import tn.esprit.spring.service.Interface.IMaintenanceService;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceIMPL implements IMaintenanceService {



    MaintenanceRepository maintenanceRepository;

    VehiculeRepository vehiculeRepository;

    @Override
    public Maintenance affecterVehiculeMaintenance(Long idVehicule, Long idMaintenance) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Maintenance maintenance = maintenanceRepository.findById(idMaintenance).orElse(null);

        assert maintenance != null;  //verification si maintenance null ou pas
        maintenance.setVehicule(vehicule);

        return maintenanceRepository.save(maintenance);
    }
    @Override
    public Maintenance creer(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance obtenirParId(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> listerTous() {
        return (List<Maintenance>) maintenanceRepository.findAll();
    }

    @Override
    public Maintenance mettreAJour(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void supprimer(Long id) {
       maintenanceRepository.deleteById(id);
    }
}
