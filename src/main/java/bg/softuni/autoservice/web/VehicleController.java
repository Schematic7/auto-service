package bg.softuni.autoservice.web;

import bg.softuni.autoservice.model.dto.vehicle.VehicleAddDTO;
import bg.softuni.autoservice.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ModelAttribute("vehicleAddDTO")
    public VehicleAddDTO vehicleAddDTO() {
        return new VehicleAddDTO();
    }

    @GetMapping("/add")
    public String addVehicle() {
        return "vehicle-add";
    }

    @PostMapping("/add")
    public String addVehicleConfirm(@Valid VehicleAddDTO vehicleAddDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("vehicleAddDTO", vehicleAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vehicleAddDTO", bindingResult);

            return "redirect:/vehicles/add";
        }

        vehicleService.addVehicle(vehicleAddDTO, userDetails);

        return "redirect:/";
    }
}