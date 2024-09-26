package pe.edu.cibertec.buscar_placas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.buscar_placas_backend.dto.VehicleRequest;
import pe.edu.cibertec.buscar_placas_backend.dto.VehicleResponse;
import pe.edu.cibertec.buscar_placas_backend.service.AuthenticationService;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class PlacasController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/consulta")
    public VehicleResponse consulta(@RequestBody VehicleRequest vehicleRequest) {
        try {
            String[] dataVehicle = authenticationService.validarPlaca(vehicleRequest);
            if (dataVehicle == null) {
                return new VehicleResponse("ERROR","","","","","","");
            }
            return new VehicleResponse(dataVehicle[0],dataVehicle[1],dataVehicle[2],dataVehicle[3],dataVehicle[4],dataVehicle[5],dataVehicle[6]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
