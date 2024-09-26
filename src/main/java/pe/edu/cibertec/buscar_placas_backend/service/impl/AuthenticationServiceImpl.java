package pe.edu.cibertec.buscar_placas_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.buscar_placas_backend.dto.VehicleRequest;
import pe.edu.cibertec.buscar_placas_backend.service.AuthenticationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarPlaca(VehicleRequest vehicleRequest) throws IOException {
        String[] dataVehicle = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(";");
                if (vehicleRequest.placa().equals(data[1])) {
                    dataVehicle = new String[7];
                    dataVehicle[0] = data[0];
                    dataVehicle[1] = data[1];
                    dataVehicle[2] = data[2];
                    dataVehicle[3] = data[3];
                    dataVehicle[4] = data[4];
                    dataVehicle[5] = data[5];
                    dataVehicle[6] = data[6];
                }
            }

        } catch (IOException e) {
            throw new IOException(e);
        }
        
        return dataVehicle;
    }
}
