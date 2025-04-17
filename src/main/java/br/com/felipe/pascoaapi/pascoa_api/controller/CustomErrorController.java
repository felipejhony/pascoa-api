package br.com.felipe.pascoaapi.pascoa_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<Map<String, String>> handleError(HttpServletRequest request) {
        Object status = request.getAttribute("javax.servlet.error.status_code");

        if (status != null && Integer.parseInt(status.toString()) == 404) {
            Map<String, String> body = new HashMap<>();
            body.put("mensagem", "O recurso não foi encontrado.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }

        Map<String, String> body = new HashMap<>();
        body.put("mensagem", "Ocorreu um erro inesperado.");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
