package com.apinoz.apirest.controller;

import com.apinoz.apirest.model.dto.ClienteDto;
import com.apinoz.apirest.model.entity.Cliente;
import com.apinoz.apirest.model.payload.MensajeResponse;
import com.apinoz.apirest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
        Cliente clienteSave = null;
        try {
          clienteSave = clienteService.save(clienteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(ClienteDto.builder()
                            .idCliente(clienteSave.getIdCliente())
                            .nombre(clienteSave.getNombre())
                            .apellido(clienteSave.getApellido())
                            .email(clienteSave.getEmail())
                            .fechaRegistro(clienteSave.getFechaRegistro())
                             .build())
                     .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping
    public  ResponseEntity<?> update(@RequestBody ClienteDto clienteDto) {
        Cliente clienteUpdate = null;
        try {
            clienteUpdate = clienteService.save(clienteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Actualizado correctamente")
                    .object(ClienteDto.builder()
                            .idCliente(clienteUpdate.getIdCliente())
                            .nombre(clienteUpdate.getNombre())
                            .apellido(clienteUpdate.getApellido())
                            .email(clienteUpdate.getEmail())
                            .fechaRegistro(clienteUpdate.getFechaRegistro())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro que intenta actualizar no existe")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
                return new ResponseEntity<>(clienteDelete, HttpStatus.NOT_FOUND);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                        .mensaje(exDt.getMessage())
                        .object(null)
                        .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro que intenta buscar no existe")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Consulta exitosa")
                        .object(ClienteDto.builder()
                                .idCliente(cliente.getIdCliente())
                                .nombre(cliente.getNombre())
                                .apellido(cliente.getApellido())
                                .email(cliente.getEmail())
                                .fechaRegistro(cliente.getFechaRegistro())
                                .build())
                        .build(),
                HttpStatus.OK);
    }
}
