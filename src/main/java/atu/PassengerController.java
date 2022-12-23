package atu;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/passenger")
public class PassengerController {

    PassengerService myService;


    public PassengerController(PassengerService myService) {
        this.myService = myService;
    }

    @GetMapping
    public List<Passenger> getPassengers(){
        return myService.getPassengers();

    }


    @GetMapping("/{passengerID}")
    public Passenger getPassenger(@PathVariable String passengerID){
        Passenger myPassenger = new Passenger("Mr", "Aidan", "123", 659L, 24);
        return myPassenger;

    }

    @PostMapping("")
    public void savePassenger(
            @RequestBody Passenger passenger)
    {
        myService.savePassenger(passenger);
    }

    @GetMapping("/name/{name}")
    public Passenger getPassengerByName(@PathVariable("name") String name)
    {
        return myService.findPassengerByName(name);
    }

    @DeleteMapping("/delete/{count}")
    public void deletePassenger(@PathVariable("count") Long count)
    {
        myService.deletePassenger(count);
    }

    @GetMapping("/age")
    public List<Passenger> getPassengersByAge(@RequestParam(name= "age_start") int age1, @RequestParam(name= "age_end") int age2)
    {
        return myService.findPassengerByAgeRange(age1, age2);
    }


}
