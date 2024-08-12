package com.example.mallexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/") // 기본 경로에 접근 시
    public String index() {
        return "index"; // index.html을 호출한다.
    }

    @GetMapping("/main") // 주소창에 /main이라고 들어오면
    public String mainPage() {
        return "main"; // main.html을 호출한다.
    }

    @GetMapping("/login") // 주소창에 /login이라고 들어오면
    public String loginPage() {
        return "login"; // login.html을 호출한다.
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam("email") String email, 
                            @RequestParam("password") String password) {
        System.out.println(email);
        System.out.println(password);
        
        // 로그인 인증 처리 로직 추가 (예: 데이터베이스 조회)
        boolean isAuthenticated = authenticateUser(email, password);
        
        if (isAuthenticated) {
            return "redirect:/main"; // 로그인 성공 시 메인 페이지로 리다이렉션
        } else {
            return "login"; // 로그인 실패 시 로그인 페이지로 돌아감
        }
    }

    private boolean authenticateUser(String email, String password) {
        // 실제 인증 로직 구현 (예: DB에서 사용자 확인)
        return "test@example.com".equals(email) && "password".equals(password); // 예시
    }

    @GetMapping("/favourite") // 주소창에 /favourite이라고 들어오면
    public String favouritePage() {
        return "favourite"; // favourite.html을 호출한다.
    }

    @GetMapping("/productdetails") // 주소창에 /productdetails이라고 들어오면
    public String productDetails() {
        return "productdetails"; // productdetails.html을 호출한다.
    }

    @GetMapping("/products")
    public String products() {
        return "products"; // products.html을 호출한다.
    }

    @GetMapping("/card")
    public String card() {
        return "card"; // card.html을 호출한다.
    }
    
    @GetMapping("/create")
    public String create(@RequestParam("title") String title) {
        System.out.println("제목: " + title);
        return "card"; // 카드 페이지로 리턴
    }
}
