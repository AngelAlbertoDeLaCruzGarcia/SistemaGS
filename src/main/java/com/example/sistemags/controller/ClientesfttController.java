package com.example.sistemags.controller;

import com.example.sistemags.dto.ClientesfttDto;
import com.example.sistemags.entity.Clientesftt;
import com.example.sistemags.entity.DatosComplementariosftt;
import com.example.sistemags.responses.Response;
import com.example.sistemags.responses.Response2;
import com.example.sistemags.service.ClientesfttService;
import com.example.sistemags.service.Curp;
import com.example.sistemags.service.DatosComplementariosfttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/clientesftt")
@CrossOrigin(origins = "")
public class ClientesfttController {
    @Autowired
    ClientesfttService clientesfttService;
    DatosComplementariosfttService datosComplementariosfttService;
    Curp curp;

    @GetMapping("")
    public ResponseEntity<?> get() {
        try {
            List<Clientesftt> employeeList = clientesfttService.list();
            if( employeeList.isEmpty()){
                return new ResponseEntity(new Response("No hay registros", 200), HttpStatus.OK);
            }else {
                return new ResponseEntity(new Response2("Exito", 200, employeeList), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody ClientesfttDto clientesfttDto, Errors errors){
        try {
            String msgError = "";
            if(errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    msgError += error.getDefaultMessage() + ", " ;
                }
                return new ResponseEntity(new Response(msgError, -1), HttpStatus.BAD_REQUEST);
            }
            curp = new Curp();
            curp.calculaCurp(clientesfttDto.getNombre(), clientesfttDto.getApellidoPaterno(), clientesfttDto.getApellidoMaterno(),
                    clientesfttDto.getFechaNac().toInstant().toString().substring(0,10), clientesfttDto.getEntidadNac(),
                    String.valueOf(clientesfttDto.getGenero().charAt(0)), "");
            DatosComplementariosftt datosComplementariosftt  = new DatosComplementariosftt(curp.getCurp().toString(),
                    curp.getRfc().toString(), new Date(), clientesfttDto.getFechaActualizacion());
            Clientesftt clientesftt = new Clientesftt(clientesfttDto.getNombre(), clientesfttDto.getApellidoPaterno(),
                    clientesfttDto.getApellidoMaterno(), clientesfttDto.getFechaNac(), clientesfttDto.getEntidadNac(),
                    clientesfttDto.getGenero(), new Date(), clientesfttDto.getFechaActualizacion(), datosComplementariosftt);
            clientesfttService.save(clientesftt);
            return new ResponseEntity(new Response("Cliente creado", 201), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(new Response(e.toString(), 400), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update/{clienteId}")
    public ResponseEntity<?> update(@Valid @RequestBody ClientesfttDto clientesfttDto, @PathVariable int clienteId,Errors errors){
        try {
            String msgError = "";
            if(errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    msgError += error.getDefaultMessage() + ", " ;
                }
                return new ResponseEntity(new Response(msgError, -1), HttpStatus.BAD_REQUEST);
            }
            Clientesftt clientesftt = clientesfttService.getOneById(clienteId).get();
            //System.out.println();
            int longitudCurp = clientesftt.getDatosComplementariosftt().getCurp().length();
            curp = new Curp();
            try {
                DatosComplementariosftt datosComplementariosftt = clientesftt.getDatosComplementariosftt();
                curp.calculaCurp(clientesfttDto.getNombre(), clientesfttDto.getApellidoPaterno(), clientesfttDto.getApellidoMaterno(),
                        clientesfttDto.getFechaNac().toInstant().toString().substring(0,10), clientesfttDto.getEntidadNac(),
                        String.valueOf(clientesfttDto.getGenero().charAt(0)), clientesftt.getDatosComplementariosftt()
                                .getCurp().substring(longitudCurp-2, longitudCurp));
                datosComplementariosftt.setCurp(curp.getCurp().toString());
                datosComplementariosftt.setRfc(curp.getRfc().toString());
                datosComplementariosftt.setFechaActualizacion(new Date());
                datosComplementariosfttService.save(datosComplementariosftt);
            }catch (Exception e){

            }
            clientesftt.setNombre(clientesfttDto.getNombre());
            clientesftt.setApellidoPaterno(clientesfttDto.getApellidoPaterno());
            clientesftt.setApellidoMaterno(clientesfttDto.getApellidoMaterno());
            clientesftt.setFechaNac(clientesfttDto.getFechaNac());
            clientesftt.setEntidadNac(clientesfttDto.getEntidadNac());
            clientesftt.setGenero(clientesfttDto.getGenero());
            clientesftt.setFechaActualizacion(new Date());
            clientesfttService.save(clientesftt);
            return new ResponseEntity(new Response("Cliente Actualizado", 201), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(new Response(e.toString(), 400), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!clientesfttService.existsById(id)) {
            return new ResponseEntity(new Response("No existe el registro", 404), HttpStatus.NOT_FOUND);
        } else {
            clientesfttService.delete(id);
            return new ResponseEntity(new Response("Eliminado", 200), HttpStatus.OK);
        }
    }
}
