package pe.edu.cibertec.buscar_placas_backend.service;

import pe.edu.cibertec.buscar_placas_backend.dto.VehicleRequest;

import java.io.IOException;

public interface AuthenticationService {
    String[] validarPlaca(VehicleRequest vehicleRequest) throws IOException;
}
