package atu;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class PassengerService {

    private final PassengerRepo passengerRepo;

    public List<Passenger> getPassengers()
    {
        return passengerRepo.findAll();

    }

    @GetMapping("/{passengerID}")
    public Passenger getPassenger(String passengerID){
        Passenger myPassenger = new Passenger("Mr", "Aidan", "123123", 619L, 24);
        return myPassenger;

    }

    public void savePassenger(Passenger passenger)
    {
        passengerRepo.save(passenger);
    }

    public Passenger findPassengerByName(String name) {
        return passengerRepo.findPassengerByName(name);
    }

    public void deletePassenger(Long count)
    {
        passengerRepo.deleteById(count);
    }

    public List<Passenger> findPassengerByAgeRange(int age1, int age2)
    {
        return passengerRepo.findPassengerByAge(age1, age2);
    }




}