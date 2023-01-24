package shop.mtcoding.buyer7.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer7.dto.PurchaseAllDto;
import shop.mtcoding.buyer7.model.PurchaseRepository;
import shop.mtcoding.buyer7.model.User;
import shop.mtcoding.buyer7.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    HttpSession session;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @PostMapping("/product/{id}/purchase")
    public String purchase(@PathVariable int id, int count) {
        // 인증
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        // 서비스
        int res = purchaseService.구매하기(id, principal.getId(), count);
        if (res == -1) {
            return "redirect:/notfound";
        }

        return "redirect:/";
    }

    @GetMapping("/purchase")
    public String purchase(Model model) {
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            return "redirect:/notfound";
        }

        List<PurchaseAllDto> purchaseList = purchaseRepository.findByUserId(user.getId());

        model.addAttribute("purchase", purchaseList);

        return "purchase/list";
    }

    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable int id) {
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            return "redirect:/notfound";
        }

        int res = purchaseService.삭제하기(id);
        if (res == -1) {
            return "redirect:/notfound";
        }

        return "redirect:/purchase";
    }
}
