package bg.softuni.autoservice.web.advice;

import bg.softuni.autoservice.exception.VehicleNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    public ModelAndView handleVehicleNotFound(VehicleNotFoundException exception) {

        ModelAndView modelAndView = new ModelAndView("error-not-found");

        modelAndView.addObject("errorMessage", exception.getMessage());

        return modelAndView;
    }
}